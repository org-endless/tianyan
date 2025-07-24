package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.item.item;

import com.alibaba.fastjson2.util.TypeUtils;
import lombok.extern.slf4j.Slf4j;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.manager.DrivenAdapterManagerException;
import org.endless.tianyan.metadata.common.model.application.command.handler.TianyanMetadataCommandHandler;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.item.group.rest.GameEveDataItemGroupRestClient;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.item.item.rest.GameEveDataItemRestClient;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.GameEveDataLoadTask;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.market.group.rest.GameEveDataMarketGroupRestClient;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.GameEveDataFileItemRespDTransfer;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.GameEveItemCreateReqDTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * GameEveDataItemLoadTask
 * <p>
 * create 2025/07/20 21:36
 * <p>
 * update 2025/07/23 00:26
 *
 * @author Deng Haozhi
 * @see GameEveDataLoadTask
 * @since 2.0.0
 */
@Slf4j
@Lazy
@Component
public class GameEveDataItemLoadTask implements GameEveDataLoadTask {

    private final GameEveDataItemGroupRestClient gameEveDataItemGroupRestClient;

    private final GameEveDataMarketGroupRestClient gameEveDataMarketGroupRestClient;

    private final GameEveDataItemRestClient gameEveDataItemRestClient;


    public GameEveDataItemLoadTask(GameEveDataItemGroupRestClient gameEveDataItemGroupRestClient, GameEveDataMarketGroupRestClient gameEveDataMarketGroupRestClient, GameEveDataItemRestClient gameEveDataItemRestClient) {
        this.gameEveDataItemGroupRestClient = gameEveDataItemGroupRestClient;
        this.gameEveDataMarketGroupRestClient = gameEveDataMarketGroupRestClient;
        this.gameEveDataItemRestClient = gameEveDataItemRestClient;
    }

    @Override
    public CompletableFuture<Void> execute(Map<String, Object> dataMap) {
        Optional.ofNullable(dataMap)
                .filter(m -> !CollectionUtils.isEmpty(m))
                .orElseThrow(() -> new DrivenAdapterManagerException("资源项数据列表为空，无法执行数据加载任务"));
        return CompletableFuture.runAsync(() -> {
            for (Map.Entry<String, Object> entry : dataMap.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                log.info("加载资源项分类数据，key:{}, value:{}", key, value);
                try {
                    GameEveDataFileItemRespDTransfer item = TypeUtils.cast(value, GameEveDataFileItemRespDTransfer.class).validate();
                    if (item.getGroupID() == null || item.getName() == null || item.getPublished() == null) {
                        log.error("加载资源项分类数据失败，key:{}, item:{}", key, item);
                        continue;
                    }
                    gameEveDataItemRestClient.create(GameEveItemCreateReqDTransfer.builder()
                            .code(key)
                            .metaGroupId(item.getMetaGroupID())
                            .itemGroupId(gameEveDataItemGroupRestClient.findItemGroupIdByCode(item.getGroupID())
                                    .orElseThrow(() -> new DrivenAdapterManagerException("资源项分类ID不存在，无法创建资源项数据")))
                            .marketGroupId(item.getMarketGroupID() == null ? null : gameEveDataMarketGroupRestClient.findMarketGroupIdByCode(item.getMarketGroupID())
                                    .orElseThrow(() -> new DrivenAdapterManagerException("市场分类ID不存在，无法创建资源项数据")))
                            .fullNameZh(item.getName().getZh() == null ? item.getName().getEn() : item.getName().getZh())
                            .fullNameEn(item.getName().getEn())
                            .isPublished(item.getPublished())
                            .createUserId(TianyanMetadataCommandHandler.TIANYAN_METADATA_USER_ID)
                            .build().validate());
                } catch (Exception e) {
                    log.error("加载资源项分类数据失败，key:{}, value:{}, error:{}", key, value, e.getMessage());
                }
            }
        });
    }

    @Override
    public String filePath() {
        return "data/game/eve/types.yaml";
    }

    @Override
    public Integer pageSize() {
        return 100;
    }
}
