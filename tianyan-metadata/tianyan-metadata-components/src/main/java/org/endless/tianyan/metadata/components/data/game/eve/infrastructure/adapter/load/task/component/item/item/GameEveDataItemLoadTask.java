package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.item.item;

import lombok.extern.slf4j.Slf4j;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.DrivenAdapterFailedException;
import org.endless.ddd.starter.common.utils.model.object.ObjectTools;
import org.endless.tianyan.metadata.common.model.application.command.handler.TianyanMetadataCommandHandler;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.GameEveDataLoadTask;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.item.item.transfer.GameEveDataFileItemDRespTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.group.TianyanSidecarGameEveItemGroupRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.item.TianyanSidecarGameEveItemRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.item.transfer.GameEveItemCreateDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.item.TianyanSidecarItemRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.item.transfer.ItemCreateDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.game.eve.group.TianyanSidecarGameEveMarketGroupRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.game.eve.TianyanSidecarGameEveMetagroupRestClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;
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
 * @since 0.0.1
 */
@Slf4j
@Lazy
@Component
public class GameEveDataItemLoadTask implements GameEveDataLoadTask {

    private final TianyanSidecarItemRestClient itemRestClient;

    private final TianyanSidecarGameEveItemRestClient gameEveItemRestClient;

    private final TianyanSidecarGameEveItemGroupRestClient gameEveItemGroupRestClient;

    private final TianyanSidecarGameEveMetagroupRestClient gameEveMetagroupRestClient;

    private final TianyanSidecarGameEveMarketGroupRestClient gameEveMarketGroupRestClient;

    public GameEveDataItemLoadTask(
            TianyanSidecarItemRestClient itemRestClient,
            TianyanSidecarGameEveItemRestClient gameEveItemRestClient,
            TianyanSidecarGameEveItemGroupRestClient gameEveItemGroupRestClient,
            TianyanSidecarGameEveMetagroupRestClient gameEveMetagroupRestClient,
            TianyanSidecarGameEveMarketGroupRestClient gameEveMarketGroupRestClient) {
        this.itemRestClient = itemRestClient;
        this.gameEveItemRestClient = gameEveItemRestClient;
        this.gameEveItemGroupRestClient = gameEveItemGroupRestClient;
        this.gameEveMetagroupRestClient = gameEveMetagroupRestClient;
        this.gameEveMarketGroupRestClient = gameEveMarketGroupRestClient;
    }

    @Override
    public CompletableFuture<Void> execute(Map<String, Object> dataMap) {
        return CompletableFuture.runAsync(() -> dataMap.forEach((gameEveItemCode, gameEveItem) -> {
            try {
                GameEveDataFileItemDRespTransfer item =
                        ObjectTools.of(gameEveItem, GameEveDataFileItemDRespTransfer.class).validate();
                String itemId = itemRestClient.create(ItemCreateDReqTransfer.builder()
                                .itemGroupId(gameEveItemGroupRestClient.findItemGroupIdByCode(item.groupID())
                                        .orElseThrow(() -> new DrivenAdapterFailedException("资源项分类ID不存在，无法创建资源项数据")))
                                .metagroupId(StringUtils.hasText(item.metaGroupID())
                                        ? gameEveMetagroupRestClient.findMetagroupIdByCode(item.metaGroupID().replaceAll("\\..*$", ""))
                                        .orElse(null)
                                        : null)
                                .marketGroupId(StringUtils.hasText(item.marketGroupID())
                                        ? gameEveMarketGroupRestClient.findMarketGroupIdByCode(item.marketGroupID())
                                        .orElseThrow(() -> new DrivenAdapterFailedException("市场分组ID不存在，无法创建资源项数据"))
                                        : null)
                                .fullNameZh(StringUtils.hasText(item.name().zh())
                                        ? item.name().zh()
                                        : item.name().en())
                                .fullNameEn(item.name().en())
                                .createUserId(TianyanMetadataCommandHandler.TIANYAN_METADATA_USER_ID)
                                .build())
                        .orElseThrow(() -> new DrivenAdapterFailedException("资源项创建失败"));
                gameEveItemRestClient.create(GameEveItemCreateDReqTransfer.builder()
                        .itemId(itemId)
                        .gameEveItemCode(gameEveItemCode)
                        .isPublished(item.published())
                        .createUserId(TianyanMetadataCommandHandler.TIANYAN_METADATA_USER_ID)
                        .build());
            } catch (Exception e) {
                log.error("加载资源项数据失败，gameEveItemCode:{}, gameEveItem:{}, error:{}", gameEveItemCode, gameEveItem, e.getMessage());
            }
        }));
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
