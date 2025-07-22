package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.group;

import com.alibaba.fastjson2.util.TypeUtils;
import lombok.extern.slf4j.Slf4j;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.manager.DrivenAdapterManagerException;
import org.endless.tianyan.metadata.common.model.application.command.handler.TianyanMetadataCommandHandler;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.item.category.rest.GameEveDataItemCategoryRestClient;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.item.group.rest.GameEveDataItemGroupRestClient;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.GameEveDataLoadTask;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.group.transfer.GameEveDataFileItemGroupRespDTransfer;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.GameEveItemGroupCreateReqDTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.Optional;

/**
 * GameEveDataItemGroupLoadTask
 * <p>
 * create 2025/07/21 15:52
 * <p>
 * update 2025/07/21 15:53
 *
 * @author Deng Haozhi
 * @see GameEveDataLoadTask
 * @since 2.0.0
 */
@Slf4j
@Lazy
@Component
public class GameEveDataItemGroupLoadTask implements GameEveDataLoadTask {

    private final GameEveDataItemCategoryRestClient gameEveDataItemCategoryRestClient;

    private final GameEveDataItemGroupRestClient gameEveDataItemGroupRestClient;

    public GameEveDataItemGroupLoadTask(GameEveDataItemCategoryRestClient gameEveDataItemCategoryRestClient, GameEveDataItemGroupRestClient gameEveDataItemGroupRestClient) {
        this.gameEveDataItemCategoryRestClient = gameEveDataItemCategoryRestClient;
        this.gameEveDataItemGroupRestClient = gameEveDataItemGroupRestClient;
    }

    @Override
    public void execute(Map<String, Object> dataMap) {
        Optional.ofNullable(dataMap)
                .filter(m -> !CollectionUtils.isEmpty(m))
                .orElseThrow(() -> new DrivenAdapterManagerException("物品分组数据列表为空，无法执行数据加载任务"));
        dataMap.forEach((key, value) -> {
            try {
                GameEveDataFileItemGroupRespDTransfer group = TypeUtils.cast(value, GameEveDataFileItemGroupRespDTransfer.class).validate();
                String categoryId = gameEveDataItemCategoryRestClient.findIdByCode(group.getCategoryID())
                        .orElseThrow(() -> new DrivenAdapterManagerException("物品分类不存在，无法执行数据加载任务"));
                gameEveDataItemGroupRestClient.create(GameEveItemGroupCreateReqDTransfer.builder()
                        .code(key)
                        .gameEveItemCategoryId(categoryId)
                        .nameZh(group.getName().getZh())
                        .nameEn(group.getName().getEn())
                        .isPublished(group.getPublished())
                        .isUseBasePrice(group.getUseBasePrice())
                        .createUserId(TianyanMetadataCommandHandler.TIANYAN_METADATA_USER_ID)
                        .build().validate());
            } catch (DrivenAdapterManagerException e) {
                log.error("加载物品分组数据失败，key:{}, value:{}, error:{}", key, value, e.getMessage());
            }
        });
    }

    @Override
    public String getFilePath() {
        return "data/game/eve/groupIDs.yaml";
    }
}
