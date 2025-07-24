package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.item.category;

import com.alibaba.fastjson2.util.TypeUtils;
import lombok.extern.slf4j.Slf4j;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.manager.DrivenAdapterManagerException;
import org.endless.tianyan.metadata.common.model.application.command.handler.TianyanMetadataCommandHandler;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.item.category.rest.GameEveDataItemCategoryRestClient;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.GameEveDataLoadTask;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.GameEveDataFileItemCategoryRespDTransfer;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.GameEveItemCategoryCreateReqDTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * GameEveDataItemCategoryLoadTask
 * <p>
 * create 2025/07/20 23:04
 * <p>
 * update 2025/07/20 23:04
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@Slf4j
@Lazy
@Component
public class GameEveDataItemCategoryLoadTask implements GameEveDataLoadTask {

    private final GameEveDataItemCategoryRestClient gameEveDataItemCategoryRestClient;

    public GameEveDataItemCategoryLoadTask(GameEveDataItemCategoryRestClient gameEveDataItemCategoryRestClient) {
        this.gameEveDataItemCategoryRestClient = gameEveDataItemCategoryRestClient;
    }


    @Override
    public CompletableFuture<Void> execute(Map<String, Object> dataMap) {
        Optional.ofNullable(dataMap)
                .filter(m -> !CollectionUtils.isEmpty(m))
                .orElseThrow(() -> new DrivenAdapterManagerException("资源项分类数据列表为空，无法执行数据加载任务"));
        return CompletableFuture.runAsync(() -> {
            dataMap.forEach((key, value) -> {
                try {
                    GameEveDataFileItemCategoryRespDTransfer itemCategory = TypeUtils.cast(value, GameEveDataFileItemCategoryRespDTransfer.class)
                            .validate();
                    gameEveDataItemCategoryRestClient.create(GameEveItemCategoryCreateReqDTransfer.builder()
                            .code(key)
                            .fullNameZh(StringUtils.hasText(itemCategory.getName().getZh()) ? itemCategory.getName().getEn() : itemCategory.getName().getZh())
                            .fullNameEn(itemCategory.getName().getEn())
                            .isPublished(itemCategory.getPublished())
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
        return "data/game/eve/categories.yaml";
    }

    @Override
    public Integer pageSize() {
        return 100;
    }
}
