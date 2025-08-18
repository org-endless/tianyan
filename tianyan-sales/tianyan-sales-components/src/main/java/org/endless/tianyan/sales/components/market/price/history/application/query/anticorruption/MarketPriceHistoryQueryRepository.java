package org.endless.tianyan.sales.components.market.price.history.application.query.anticorruption;

import org.endless.tianyan.sales.common.model.application.query.anticorruption.TianyanSalesQueryRepository;
import org.endless.tianyan.sales.components.market.price.history.domain.anticorruption.MarketPriceHistoryRepository;
import org.endless.tianyan.sales.components.market.price.history.domain.entity.MarketPriceHistoryAggregate;

/**
 * MarketPriceHistoryQueryRepository
 * <p>市场价格历史聚合查询仓储接口
 * <p>
 * create 2025/07/26 18:57
 * <p>
 * update 2025/07/26 18:57
 *
 * @author Deng Haozhi
 * @see MarketPriceHistoryRepository
 * @see TianyanSalesQueryRepository
 * @since 0.0.1
 */
public interface MarketPriceHistoryQueryRepository extends MarketPriceHistoryRepository, TianyanSalesQueryRepository<MarketPriceHistoryAggregate> {
}
