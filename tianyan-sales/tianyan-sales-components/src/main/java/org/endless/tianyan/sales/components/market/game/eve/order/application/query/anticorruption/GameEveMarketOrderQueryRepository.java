package org.endless.tianyan.sales.components.market.game.eve.order.application.query.anticorruption;

import org.endless.tianyan.sales.common.model.application.query.anticorruption.TianyanSalesQueryRepository;
import org.endless.tianyan.sales.components.market.game.eve.order.domain.anticorruption.GameEveMarketOrderRepository;
import org.endless.tianyan.sales.components.market.game.eve.order.domain.entity.GameEveMarketOrderAggregate;

/**
 * GameEveMarketOrderQueryRepository
 * <p>游戏EVE市场订单聚合查询仓储接口
 * <p>
 * create 2025/07/25 11:19
 * <p>
 * update 2025/07/25 11:19
 *
 * @author Deng Haozhi
 * @see GameEveMarketOrderRepository
 * @see TianyanSalesQueryRepository
 * @since 0.0.1
 */
public interface GameEveMarketOrderQueryRepository extends GameEveMarketOrderRepository, TianyanSalesQueryRepository<GameEveMarketOrderAggregate> {

}
