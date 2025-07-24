package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.market.group;

import com.alibaba.fastjson2.util.TypeUtils;
import lombok.extern.slf4j.Slf4j;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.manager.DrivenAdapterManagerException;
import org.endless.tianyan.metadata.common.model.application.command.handler.TianyanMetadataCommandHandler;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.GameEveDataLoadTask;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.market.group.rest.GameEveDataMarketGroupRestClient;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.GameEveDataFileMarketGroupRespDTransfer;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.GameEveMarketGroupCreateReqDTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.CompletableFuture;

/**
 * GameEveDataMarketGroupLoadTask
 * <p>
 * create 2025/07/22 10:08
 * <p>
 * update 2025/07/22 10:08
 *
 * @author Deng Haozhi
 * @see GameEveDataLoadTask
 * @since 2.0.0
 */
@Slf4j
@Lazy
@Component
public class GameEveDataMarketGroupLoadTask implements GameEveDataLoadTask {

    private final GameEveDataMarketGroupRestClient gameEveDataMarketGroupRestClient;

    public GameEveDataMarketGroupLoadTask(GameEveDataMarketGroupRestClient gameEveDataMarketGroupRestClient) {
        this.gameEveDataMarketGroupRestClient = gameEveDataMarketGroupRestClient;
    }


    @Override
    public CompletableFuture<Void> execute(Map<String, Object> dataMap) {
        Optional.ofNullable(dataMap)
                .filter(m -> !CollectionUtils.isEmpty(m))
                .orElseThrow(() -> new DrivenAdapterManagerException("市场分类数据列表为空，无法执行数据加载任务"));
        return CompletableFuture.runAsync(() -> {
            Map<String, GameEveMarketGroupCreateReqDTransfer> sourceMap = new HashMap<>();
            dataMap.forEach((key, value) -> {
                try {
                    GameEveDataFileMarketGroupRespDTransfer marketGroup = TypeUtils.cast(dataMap.get(key), GameEveDataFileMarketGroupRespDTransfer.class).validate();
                    sourceMap.put(key,
                            GameEveMarketGroupCreateReqDTransfer.builder()
                                    .code(key)
                                    .fullNameZh(marketGroup.getNameID().getZh() == null ? marketGroup.getNameID().getEn() : marketGroup.getNameID().getZh())
                                    .fullNameEn(marketGroup.getNameID().getEn())
                                    .parentCode(marketGroup.getParentGroupID())
                                    .createUserId(TianyanMetadataCommandHandler.TIANYAN_METADATA_USER_ID)
                                    .build().validate());
                } catch (Exception e) {
                    log.error("加载市场分类数据失败，key:{}, value:{}, error:{}", key, value, e.getMessage());
                }
            });
            final String ROOT = "ROOT";
            Map<String, List<String>> graph = new HashMap<>();
            Map<String, Integer> inDegree = new HashMap<>();
            for (GameEveMarketGroupCreateReqDTransfer marketGroup : sourceMap.values()) {
                String code = marketGroup.getCode();
                String parentCode = StringUtils.hasText(marketGroup.getParentCode())
                        ? marketGroup.getParentCode()
                        : ROOT;
                graph.computeIfAbsent(parentCode, k -> new ArrayList<>()).add(code);
                inDegree.put(code, inDegree.getOrDefault(code, 0) + 1);
                inDegree.putIfAbsent(parentCode, 0);
            }
            Queue<String> queue = new LinkedList<>();
            inDegree.forEach((code, degree) -> {
                if (degree == 0) {
                    queue.offer(code);
                }
            });
            int processed = 0;
            while (!queue.isEmpty()) {
                List<String> currentLayer = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    currentLayer.add(queue.poll());
                }

                List<CompletableFuture<Void>> futures = currentLayer.stream()
                        .filter(currentCode -> !ROOT.equals(currentCode))
                        .map(currentCode -> {
                            GameEveMarketGroupCreateReqDTransfer current = sourceMap.get(currentCode);
                            return gameEveDataMarketGroupRestClient.create(current)
                                    .exceptionally(ex -> {
                                        log.error("加载蓝图数据失败，currentCode:{},dataMap:{},  current:{}, error:{}", currentCode, dataMap.get(currentCode), current, ex.getMessage());
                                        return null;
                                    });
                        })
                        .toList();
                // 等待当前层所有任务完成
                CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
                processed += currentLayer.size();
                for (String currentId : currentLayer) {
                    List<String> children = graph.getOrDefault(currentId, Collections.emptyList());
                    for (String child : children) {
                        inDegree.put(child, inDegree.get(child) - 1);
                        if (inDegree.get(child) == 0) {
                            queue.offer(child);
                        }
                    }
                }
            }
            if (processed < sourceMap.size()) {
                throw new DrivenAdapterManagerException("存在循环依赖，无法完成市场分类创建");
            }
        });
    }

    @Override
    public String filePath() {
        return "data/game/eve/marketGroups.yaml";
    }

    @Override
    public Integer pageSize() {
        return 10000;
    }
}
