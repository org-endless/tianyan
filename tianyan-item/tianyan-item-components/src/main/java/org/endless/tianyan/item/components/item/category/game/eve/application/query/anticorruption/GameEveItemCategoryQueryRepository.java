package org.endless.tianyan.item.components.item.category.game.eve.application.query.anticorruption;

import org.endless.tianyan.item.common.model.application.query.anticorruption.*;
import org.endless.tianyan.item.components.item.category.game.eve.domain.anticorruption.*;
import org.endless.tianyan.item.components.item.category.game.eve.domain.entity.*;

/**
 * GameEveItemCategoryQueryRepository
 * <p>游戏EVE物品分类聚合查询仓储接口
 * <p>
 * create 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see GameEveItemCategoryRepository
 * @see TianyanItemQueryRepository
 * @since 0.0.1
 */
public interface GameEveItemCategoryQueryRepository extends GameEveItemCategoryRepository, TianyanItemQueryRepository<GameEveItemCategoryAggregate> {
}
