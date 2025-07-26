package org.endless.tianyan.sales.components.market.trade.history.application.query.anticorruption;

import org.endless.tianyan.sales.common.model.application.query.anticorruption.*;
import org.endless.tianyan.sales.components.market.trade.history.domain.anticorruption.*;
import org.endless.tianyan.sales.components.market.trade.history.domain.entity.*;

/**
 * MarketTradeHistoryQueryRepository
 * <p>市场交易历史聚合查询仓储接口
 * <p>
 * create 2025/07/26 18:57
 * <p>
 * update 2025/07/26 18:57
 *
 * @author Deng Haozhi
 * @see MarketTradeHistoryRepository
 * @see TianyanSalesQueryRepository
 * @since 0.0.1
 */
public interface MarketTradeHistoryQueryRepository extends MarketTradeHistoryRepository, TianyanSalesQueryRepository<MarketTradeHistoryAggregate> {
}
