package org.endless.tianyan.sales.components.market.order.market.order.application.query.anticorruption;

import org.endless.tianyan.sales.common.model.application.query.anticorruption.TianyanSalesQueryRepository;
import org.endless.tianyan.sales.components.market.order.market.order.domain.anticorruption.MarketOrderRepository;
import org.endless.tianyan.sales.components.market.order.market.order.domain.entity.MarketOrderAggregate;

import java.util.List;

/**
 * MarketOrderQueryRepository
 * <p>市场订单聚合查询仓储接口
 * <p>
 * create 2025/07/25 13:11
 * <p>
 * update 2025/07/25 13:11
 *
 * @author Deng Haozhi
 * @see MarketOrderRepository
 * @see TianyanSalesQueryRepository
 * @since 0.0.1
 */
public interface MarketOrderQueryRepository extends MarketOrderRepository, TianyanSalesQueryRepository<MarketOrderAggregate> {

    List<String> findIdsByItemId(String itemId);
}
