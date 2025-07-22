package org.endless.tianyan.sales.components.market.game.eve.group.application.query.anticorruption;

import org.endless.tianyan.sales.common.model.application.query.anticorruption.*;
import org.endless.tianyan.sales.components.market.game.eve.group.domain.anticorruption.*;
import org.endless.tianyan.sales.components.market.game.eve.group.domain.entity.*;

/**
 * GameEveMarketGroupQueryRepository
 * <p>游戏EVE市场分组聚合查询仓储接口
 * <p>
 * create 2025/07/22 09:09
 * <p>
 * update 2025/07/22 09:09
 *
 * @author Deng Haozhi
 * @see GameEveMarketGroupRepository
 * @see TianyanSalesQueryRepository
 * @since 0.0.1
 */
public interface GameEveMarketGroupQueryRepository extends GameEveMarketGroupRepository, TianyanSalesQueryRepository<GameEveMarketGroupAggregate> {
}
