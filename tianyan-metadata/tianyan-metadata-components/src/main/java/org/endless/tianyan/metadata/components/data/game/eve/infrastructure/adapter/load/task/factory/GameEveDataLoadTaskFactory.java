package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.factory;

import lombok.extern.slf4j.Slf4j;
import org.endless.tianyan.metadata.components.data.game.eve.domain.type.GameEveDataTypeEnum;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.GameEveDataLoadTask;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.blueprint.GameEveDataBlueprintLoadTask;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.item.category.GameEveDataItemCategoryLoadTask;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.item.group.GameEveDataItemGroupLoadTask;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.item.item.GameEveDataItemLoadTask;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.market.group.GameEveDataMarketGroupLoadTask;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.meta.group.GameEveDataMetaGroupLoadTask;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

/**
 * GameEveDataLoadTaskFactory
 * <p>
 * create 2025/07/20 21:35
 * <p>
 * update 2025/07/20 21:35
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@Lazy
@Component
@Slf4j
public class GameEveDataLoadTaskFactory {

    private final Map<GameEveDataTypeEnum, GameEveDataLoadTask> executorMap = new EnumMap<>(GameEveDataTypeEnum.class);

    public GameEveDataLoadTaskFactory(GameEveDataLoadTask... tasks) {
        for (GameEveDataLoadTask task : tasks) {
            Class<?> clazz = AopProxyUtils.ultimateTargetClass(task);
            if (clazz == GameEveDataItemLoadTask.class)
                executorMap.put(GameEveDataTypeEnum.ITEM, task);
            if (clazz == GameEveDataItemCategoryLoadTask.class)
                executorMap.put(GameEveDataTypeEnum.ITEM_CATEGORY, task);
            if (clazz == GameEveDataItemGroupLoadTask.class)
                executorMap.put(GameEveDataTypeEnum.ITEM_GROUP, task);
            if (clazz == GameEveDataMarketGroupLoadTask.class)
                executorMap.put(GameEveDataTypeEnum.MARKET_GROUP, task);
            if (clazz == GameEveDataBlueprintLoadTask.class)
                executorMap.put(GameEveDataTypeEnum.BLUEPRINT, task);
            if (clazz == GameEveDataMetaGroupLoadTask.class)
                executorMap.put(GameEveDataTypeEnum.META_GROUP, task);
        }
    }

    public GameEveDataLoadTask get(GameEveDataTypeEnum dataType) {
        GameEveDataLoadTask task = executorMap.get(dataType);
        if (task == null) {
            throw new UnsupportedOperationException("不支持处理的数据类型: " + dataType);
        }
        return task;
    }
}
