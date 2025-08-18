package org.endless.tianyan.sales.components.market.price.market.price.application.query.anticorruption;

import org.endless.tianyan.sales.common.model.application.query.anticorruption.TianyanSalesQueryRepository;
import org.endless.tianyan.sales.components.market.price.market.price.domain.anticorruption.MarketPriceRepository;
import org.endless.tianyan.sales.components.market.price.market.price.domain.entity.MarketPriceAggregate;

/**
 * MarketPriceQueryRepository
 * <p>市场价格聚合查询仓储接口
 * <p>
 * create 2025/07/26 18:56
 * <p>
 * update 2025/07/26 18:56
 *
 * @author Deng Haozhi
 * @see MarketPriceRepository
 * @see TianyanSalesQueryRepository
 * @since 0.0.1
 */
public interface MarketPriceQueryRepository extends MarketPriceRepository, TianyanSalesQueryRepository<MarketPriceAggregate> {
}
