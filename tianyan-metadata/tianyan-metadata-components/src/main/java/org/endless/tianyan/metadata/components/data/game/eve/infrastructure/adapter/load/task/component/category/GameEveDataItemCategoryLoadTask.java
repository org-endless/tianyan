package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.category;

import com.alibaba.fastjson2.util.TypeUtils;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.manager.DrivenAdapterManagerException;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.item.category.rest.GameEveDataItemCategoryRestClient;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.GameEveDataLoadTask;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.category.transfer.GameEveDataFileItemCategoryRespDTransfer;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.GameEveDataItemCategoryCreateReqDTransfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.Optional;

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
@Lazy
@Component
public class GameEveDataItemCategoryLoadTask implements GameEveDataLoadTask {

    private static final Logger log = LoggerFactory.getLogger(GameEveDataItemCategoryLoadTask.class);

    private final GameEveDataItemCategoryRestClient gameEveDataItemCategoryRestClient;

    public GameEveDataItemCategoryLoadTask(GameEveDataItemCategoryRestClient gameEveDataItemCategoryRestClient) {
        this.gameEveDataItemCategoryRestClient = gameEveDataItemCategoryRestClient;
    }


    @Override
    public void execute(Map<String, Object> dataMap) {
        Optional.ofNullable(dataMap)
                .filter(m -> !CollectionUtils.isEmpty(m))
                .orElseThrow(() -> new DrivenAdapterManagerException("物品分类数据列表为空，无法执行数据加载任务"));
        dataMap.forEach((key, value) -> {
            GameEveDataFileItemCategoryRespDTransfer category = TypeUtils.cast(value, GameEveDataFileItemCategoryRespDTransfer.class).validate();
            gameEveDataItemCategoryRestClient.create(GameEveDataItemCategoryCreateReqDTransfer.builder()
                    .code(key)
                    .nameZh(category.getName().getZh())
                    .nameEn(category.getName().getEn())
                    .isPublished(category.getPublished())
                    .createUserId("admin")
                    .build().validate());
        });
    }

    @Override
    public String getFilePath() {
        return "data/game/eve/categoryIDs.yaml";
    }
}
