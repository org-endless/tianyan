package org.endless.tianyan.sales.components.market.trade.market.trade.application.query.anticorruption;

import org.endless.tianyan.sales.common.model.application.query.anticorruption.*;
import org.endless.tianyan.sales.components.market.trade.market.trade.domain.anticorruption.*;
import org.endless.tianyan.sales.components.market.trade.market.trade.domain.entity.*;

/**
 * MarketTradeQueryRepository
 * <p>市场交易聚合查询仓储接口
 * <p>
 * create 2025/07/26 18:57
 * <p>
 * update 2025/07/26 18:57
 *
 * @author Deng Haozhi
 * @see MarketTradeRepository
 * @see TianyanSalesQueryRepository
 * @since 0.0.1
 */
public interface MarketTradeQueryRepository extends MarketTradeRepository, TianyanSalesQueryRepository<MarketTradeAggregate> {
}
