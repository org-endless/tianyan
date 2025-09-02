package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.item.group;

import lombok.extern.slf4j.Slf4j;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.DrivenAdapterFailedException;
import org.endless.ddd.starter.common.utils.model.object.ObjectTools;
import org.endless.tianyan.metadata.common.model.application.command.handler.TianyanMetadataCommandHandler;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.GameEveDataLoadTask;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.item.group.transfer.GameEveDataFileItemGroupDRespTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.category.TianyanSidecarGameEveItemCategoryRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.group.TianyanSidecarGameEveItemGroupRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.group.transfer.GameEveItemGroupCreateDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.group.TianyanSidecarItemGroupRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.group.transfer.ItemGroupCreateDReqTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * GameEveDataItemGroupLoadTask
 * <p>
 * create 2025/07/21 15:52
 * <p>
 * update 2025/07/21 15:53
 *
 * @author Deng Haozhi
 * @see GameEveDataLoadTask
 * @since 0.0.1
 */
@Slf4j
@Lazy
@Component
public class GameEveDataItemGroupLoadTask implements GameEveDataLoadTask {

    private final TianyanSidecarItemGroupRestClient itemGroupRestClient;

    private final TianyanSidecarGameEveItemGroupRestClient gameEveItemGroupRestClient;

    private final TianyanSidecarGameEveItemCategoryRestClient gameEveItemCategoryRestClient;

    public GameEveDataItemGroupLoadTask(
            TianyanSidecarItemGroupRestClient itemGroupRestClient,
            TianyanSidecarGameEveItemGroupRestClient gameEveItemGroupRestClient,
            TianyanSidecarGameEveItemCategoryRestClient gameEveItemCategoryRestClient) {
        this.itemGroupRestClient = itemGroupRestClient;
        this.gameEveItemGroupRestClient = gameEveItemGroupRestClient;
        this.gameEveItemCategoryRestClient = gameEveItemCategoryRestClient;
    }

    @Override
    public CompletableFuture<Void> execute(Map<String, Object> dataMap) {
        return CompletableFuture.runAsync(() -> dataMap.forEach((gameEveItemGroupCode, gameEveItemGroup) -> {
            try {
                GameEveDataFileItemGroupDRespTransfer itemGroup =
                        ObjectTools.of(gameEveItemGroup, GameEveDataFileItemGroupDRespTransfer.class).validate();
                String itemCategoryId = gameEveItemCategoryRestClient.findItemCategoryIdByCode(itemGroup.categoryID())
                        .orElseThrow(() -> new DrivenAdapterFailedException("资源项分类不存在，无法执行数据加载任务"));
                String itemGroupId = itemGroupRestClient.create(ItemGroupCreateDReqTransfer.builder()
                                .itemCategoryId(itemCategoryId)
                                .fullNameZh(StringUtils.hasText(itemGroup.name().zh())
                                        ? itemGroup.name().zh()
                                        : itemGroup.name().en())
                                .fullNameEn(itemGroup.name().en())
                                .createUserId(TianyanMetadataCommandHandler.TIANYAN_METADATA_USER_ID)
                                .build())
                        .orElseThrow(() -> new DrivenAdapterFailedException("资源项分组创建失败"));
                gameEveItemGroupRestClient.create(GameEveItemGroupCreateDReqTransfer.builder()
                        .gameEveItemGroupCode(gameEveItemGroupCode)
                        .itemGroupId(itemGroupId)
                        .isPublished(itemGroup.published())
                        .isUseBasePrice(itemGroup.useBasePrice())
                        .createUserId(TianyanMetadataCommandHandler.TIANYAN_METADATA_USER_ID)
                        .build());
            } catch (Exception e) {
                log.error("加载资源项分组数据失败，gameEveItemGroupCode:{}, gameEveItemGroup:{}, error:{}", gameEveItemGroupCode, gameEveItemGroup, e.getMessage(), e);
            }
        }));
    }

    @Override
    public String filePath() {
        return "data/game/eve/groups.yaml";
    }

    @Override
    public Integer pageSize() {
        return 100;
    }
}
