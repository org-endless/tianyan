package org.endless.tianyan.sales.components.market.group.game.eve.application.query.anticorruption;

import org.endless.tianyan.sales.common.model.application.query.anticorruption.TianyanSalesQueryRepository;
import org.endless.tianyan.sales.components.market.group.game.eve.domain.anticorruption.GameEveMarketGroupRepository;
import org.endless.tianyan.sales.components.market.group.game.eve.domain.entity.GameEveMarketGroupAggregate;

/**
 * GameEveMarketGroupQueryRepository
 * <p>游戏EVE市场分组聚合查询仓储接口
 * <p>
 * create 2025/07/24 17:37
 * <p>
 * update 2025/07/24 17:37
 *
 * @author Deng Haozhi
 * @see GameEveMarketGroupRepository
 * @see TianyanSalesQueryRepository
 * @since 0.0.1
 */
public interface GameEveMarketGroupQueryRepository extends GameEveMarketGroupRepository, TianyanSalesQueryRepository<GameEveMarketGroupAggregate> {
}
