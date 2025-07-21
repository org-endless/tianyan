package org.endless.tianyan.item.components.item.category.item.category.application.query.handler.impl;

import org.endless.tianyan.item.components.item.category.item.category.application.query.handler.*;
import org.endless.tianyan.item.components.item.category.item.category.application.query.anticorruption.*;
import org.endless.tianyan.item.components.item.category.item.category.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.handler.*;

/**
 * ItemCategoryQueryHandlerImpl
 * <p>物品分类领域查询处理器
 * <p>
 * create 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see ItemCategoryQueryHandler
 * @since 0.0.1
 */
public class ItemCategoryQueryHandlerImpl implements ItemCategoryQueryHandler {

    /**
     * 物品分类聚合查询仓储接口
     */
    private final ItemCategoryQueryRepository itemCategoryQueryRepository;

    public ItemCategoryQueryHandlerImpl(ItemCategoryQueryRepository itemCategoryQueryRepository) {
        this.itemCategoryQueryRepository = itemCategoryQueryRepository;
    }
}
