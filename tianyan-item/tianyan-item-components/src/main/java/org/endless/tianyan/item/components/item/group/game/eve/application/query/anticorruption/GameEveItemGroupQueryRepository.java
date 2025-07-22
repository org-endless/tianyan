package org.endless.tianyan.item.components.item.group.game.eve.application.query.anticorruption;

import org.endless.tianyan.item.common.model.application.query.anticorruption.*;
import org.endless.tianyan.item.components.item.group.game.eve.domain.anticorruption.*;
import org.endless.tianyan.item.components.item.group.game.eve.domain.entity.*;

/**
 * GameEveItemGroupQueryRepository
 * <p>游戏EVE物品分组聚合查询仓储接口
 * <p>
 * create 2025/07/21 16:03
 * <p>
 * update 2025/07/21 16:03
 *
 * @author Deng Haozhi
 * @see GameEveItemGroupRepository
 * @see TianyanItemQueryRepository
 * @since 0.0.1
 */
public interface GameEveItemGroupQueryRepository extends GameEveItemGroupRepository, TianyanItemQueryRepository<GameEveItemGroupAggregate> {
}
