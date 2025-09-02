package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.item.category;

import lombok.extern.slf4j.Slf4j;
import org.endless.ddd.starter.common.utils.model.object.ObjectTools;
import org.endless.tianyan.metadata.common.model.application.command.handler.TianyanMetadataCommandHandler;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.GameEveDataLoadTask;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.item.category.transfer.GameEveDataFileItemCategoryDRespTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.category.TianyanSidecarItemCategoryRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.category.transfer.ItemCategoryCreateDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.category.TianyanSidecarGameEveItemCategoryRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.category.transfer.GameEveItemCategoryCreateDReqTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * GameEveDataItemCategoryLoadTask
 * <p>
 * create 2025/07/20 23:04
 * <p>
 * update 2025/07/20 23:04
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@Slf4j
@Lazy
@Component
public class GameEveDataItemCategoryLoadTask implements GameEveDataLoadTask {

    private final TianyanSidecarItemCategoryRestClient itemCategoryRestClient;

    private final TianyanSidecarGameEveItemCategoryRestClient gameEveItemCategoryRestClient;

    public GameEveDataItemCategoryLoadTask(
            TianyanSidecarItemCategoryRestClient itemCategoryRestClient,
            TianyanSidecarGameEveItemCategoryRestClient gameEveItemCategoryRestClient) {
        this.itemCategoryRestClient = itemCategoryRestClient;
        this.gameEveItemCategoryRestClient = gameEveItemCategoryRestClient;
    }

    @Override
    public CompletableFuture<Void> execute(Map<String, Object> dataMap) {
        return CompletableFuture.runAsync(() -> dataMap.forEach((gameEveItemCategoryCode, gameEveItemCategory) -> {
            try {
                GameEveDataFileItemCategoryDRespTransfer itemCategory =
                        ObjectTools.of(gameEveItemCategory, GameEveDataFileItemCategoryDRespTransfer.class).validate();
                String itemCategoryId = itemCategoryRestClient.create(ItemCategoryCreateDReqTransfer.builder()
                                .fullNameZh(StringUtils.hasText(itemCategory.name().zh())
                                        ? itemCategory.name().zh()
                                        : itemCategory.name().en())
                                .fullNameEn(itemCategory.name().en())
                                .createUserId(TianyanMetadataCommandHandler.TIANYAN_METADATA_USER_ID)
                                .build())
                        .orElseThrow(() -> new RuntimeException("创建资源项分类失败"));
                gameEveItemCategoryRestClient.create(GameEveItemCategoryCreateDReqTransfer.builder()
                        .itemCategoryId(itemCategoryId)
                        .gameEveItemCategoryCode(gameEveItemCategoryCode)
                        .isPublished(itemCategory.published())
                        .createUserId(TianyanMetadataCommandHandler.TIANYAN_METADATA_USER_ID)
                        .build());
            } catch (Exception e) {
                log.error("加载资源项分类数据失败，gameEveItemCategoryCode:{}, gameEveItemCategory:{}, error:{}", gameEveItemCategoryCode, gameEveItemCategory, e.getMessage());
            }
        }));
    }

    @Override
    public String filePath() {
        return "data/game/eve/categories.yaml";
    }

    @Override
    public Integer pageSize() {
        return 100;
    }
}
