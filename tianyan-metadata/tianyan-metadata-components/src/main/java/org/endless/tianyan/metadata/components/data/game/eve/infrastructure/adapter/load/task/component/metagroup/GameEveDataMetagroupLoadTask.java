package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.metagroup;

import lombok.extern.slf4j.Slf4j;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.DrivenAdapterFailedException;
import org.endless.ddd.starter.common.utils.model.object.ObjectTools;
import org.endless.tianyan.metadata.common.model.application.command.handler.TianyanMetadataCommandHandler;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.GameEveDataLoadTask;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.metagroup.transfer.GameEveDataFileMetagroupDRespTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.game.eve.TianyanSidecarGameEveMetagroupRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.game.eve.transfer.GameEveMetagroupCreateDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.metagroup.TianyanSidecarMetagroupRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.metagroup.transfer.MetagroupCreateDReqTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;
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
public class GameEveDataMetagroupLoadTask implements GameEveDataLoadTask {

    private final TianyanSidecarMetagroupRestClient metagroupRestClient;

    private final TianyanSidecarGameEveMetagroupRestClient gameEveMetagroupRestClient;

    public GameEveDataMetagroupLoadTask(TianyanSidecarMetagroupRestClient metagroupRestClient, TianyanSidecarGameEveMetagroupRestClient gameEveMetagroupRestClient) {
        this.metagroupRestClient = metagroupRestClient;
        this.gameEveMetagroupRestClient = gameEveMetagroupRestClient;
    }


    @Override
    public CompletableFuture<Void> execute(Map<String, Object> dataMap) {
        return CompletableFuture.runAsync(() -> dataMap.forEach((gameEveMetagroupCode, gameEveMetagroup) -> {
            try {
                GameEveDataFileMetagroupDRespTransfer metagroup =
                        ObjectTools.of(gameEveMetagroup, GameEveDataFileMetagroupDRespTransfer.class).validate();
                String metagroupId = metagroupRestClient.create(MetagroupCreateDReqTransfer.builder()
                                .fullNameZh(StringUtils.hasText(metagroup.nameID().zh())
                                        ? metagroup.nameID().zh()
                                        : metagroup.nameID().en())
                                .fullNameEn(metagroup.nameID().en())
                                .createUserId(TianyanMetadataCommandHandler.TIANYAN_METADATA_USER_ID)
                                .build())
                        .orElseThrow(() -> new DrivenAdapterFailedException("元分组创建失败"));
                gameEveMetagroupRestClient.create(GameEveMetagroupCreateDReqTransfer.builder()
                        .gameEveMetagroupCode(gameEveMetagroupCode)
                        .metagroupId(metagroupId)
                        .createUserId(TianyanMetadataCommandHandler.TIANYAN_METADATA_USER_ID)
                        .build());
            } catch (Exception e) {
                log.error("加载资源项分类数据失败，gameEveMetagroupCode: {}, metagroup: {}, error: {}", gameEveMetagroupCode, gameEveMetagroup, e.getMessage());
                log.trace("", e);
            }
        }));
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
