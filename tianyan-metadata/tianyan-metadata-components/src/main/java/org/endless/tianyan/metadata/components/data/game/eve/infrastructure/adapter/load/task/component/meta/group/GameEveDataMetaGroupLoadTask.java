package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.meta.group;

import com.alibaba.fastjson2.util.TypeUtils;
import lombok.extern.slf4j.Slf4j;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.manager.DrivenAdapterException;
import org.endless.tianyan.metadata.common.model.application.command.handler.TianyanMetadataCommandHandler;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.GameEveDataLoadTask;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.meta.group.GameEveDataMetaGroupDrivenAdapter;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.GameEveDataFileMarketGroupRespDTransfer;
import org.endless.tianyan.metadata.components.meta.group.game.eve.application.command.transfer.GameEveMetaGroupCreateReqCTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * GameEveDataMetaGroupLoadTask
 * <p>
 * create 2025/07/24 11:45
 * <p>
 * update 2025/07/24 11:45
 *
 * @author Deng Haozhi
 * @see GameEveDataLoadTask
 * @since 0.0.1
 */
@Slf4j
@Lazy
@Component
public class GameEveDataMetaGroupLoadTask implements GameEveDataLoadTask {

    private final GameEveDataMetaGroupDrivenAdapter gameEveDataMetaGroupDrivenAdapter;

    public GameEveDataMetaGroupLoadTask(GameEveDataMetaGroupDrivenAdapter gameEveDataMetaGroupDrivenAdapter) {
        this.gameEveDataMetaGroupDrivenAdapter = gameEveDataMetaGroupDrivenAdapter;
    }

    @Override
    public CompletableFuture<Void> execute(Map<String, Object> dataMap) {
        Optional.ofNullable(dataMap)
                .filter(m -> !CollectionUtils.isEmpty(m))
                .orElseThrow(() -> new DrivenAdapterException("资源项分类数据列表为空，无法执行数据加载任务"));
        return CompletableFuture.runAsync(() -> {
            dataMap.forEach((key, value) -> {
                try {
                    GameEveDataFileMarketGroupRespDTransfer metaGroup = TypeUtils.cast(value, GameEveDataFileMarketGroupRespDTransfer.class)
                            .validate();
                    gameEveDataMetaGroupDrivenAdapter.create(GameEveMetaGroupCreateReqCTransfer.builder()
                            .code(key)
                            .fullNameZh(metaGroup.getNameID().getZh() == null ? metaGroup.getNameID().getEn() : metaGroup.getNameID().getZh())
                            .fullNameEn(metaGroup.getNameID().getEn())
                            .createUserId(TianyanMetadataCommandHandler.TIANYAN_METADATA_USER_ID)
                            .build().validate());
                } catch (Exception e) {
                    log.error("加载资源项分类数据失败，key:{}, value:{}, error:{}", key, value, e.getMessage());
                }
            });
        });
    }

    @Override
    public String filePath() {
        return "data/game/eve/metaGroups.yaml";
    }

    @Override
    public Integer pageSize() {
        return 100;
    }
}
