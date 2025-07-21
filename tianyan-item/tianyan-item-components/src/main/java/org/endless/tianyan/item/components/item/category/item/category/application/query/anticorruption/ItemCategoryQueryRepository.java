package org.endless.tianyan.item.components.item.category.item.category.application.query.anticorruption;

import org.endless.tianyan.item.common.model.application.query.anticorruption.*;
import org.endless.tianyan.item.components.item.category.item.category.domain.anticorruption.*;
import org.endless.tianyan.item.components.item.category.item.category.domain.entity.*;

/**
 * ItemCategoryQueryRepository
 * <p>物品分类聚合查询仓储接口
 * <p>
 * create 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see ItemCategoryRepository
 * @see TianyanItemQueryRepository
 * @since 0.0.1
 */
public interface ItemCategoryQueryRepository extends ItemCategoryRepository, TianyanItemQueryRepository<ItemCategoryAggregate> {
}
