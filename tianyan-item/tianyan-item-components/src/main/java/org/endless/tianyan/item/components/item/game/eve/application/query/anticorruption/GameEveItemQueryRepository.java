package org.endless.tianyan.item.components.item.game.eve.application.query.anticorruption;

import org.endless.tianyan.item.common.model.application.query.anticorruption.*;
import org.endless.tianyan.item.components.item.game.eve.domain.anticorruption.*;
import org.endless.tianyan.item.components.item.game.eve.domain.entity.*;

/**
 * GameEveItemQueryRepository
 * <p>游戏EVE物品聚合查询仓储接口
 * <p>
 * create 2025/07/19 09:28
 * <p>
 * update 2025/07/19 09:28
 *
 * @author Deng Haozhi
 * @see GameEveItemRepository
 * @see TianyanItemQueryRepository
 * @since 0.0.1
 */
public interface GameEveItemQueryRepository extends GameEveItemRepository, TianyanItemQueryRepository<GameEveItemAggregate> {
}
