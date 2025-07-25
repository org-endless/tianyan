package org.endless.tianyan.sales.components.market.order.market.order.facade.adapter.spring;

import org.endless.tianyan.sales.components.market.order.market.order.facade.adapter.*;
import org.endless.tianyan.sales.components.market.order.market.order.application.command.handler.*;
import org.endless.tianyan.sales.components.market.order.market.order.application.query.handler.*;
import org.endless.ddd.simplified.starter.common.exception.model.facade.adapter.*;

/**
 * SpringMarketOrderDrivingAdapter
 * <p>市场订单领域主动适配器Spring实现类
 * <p>
 * create 2025/07/25 13:11
 * <p>
 * update 2025/07/25 13:11
 *
 * @author Deng Haozhi
 * @see MarketOrderDrivingAdapter
 * @since 0.0.1
 */
public class SpringMarketOrderDrivingAdapter implements MarketOrderDrivingAdapter {

    /**
     * 市场订单领域命令处理器
     */
    private final MarketOrderCommandHandler marketOrderCommandHandler;

    /**
     * 市场订单领域查询处理器
     */
    private final MarketOrderQueryHandler marketOrderQueryHandler;

    public SpringMarketOrderDrivingAdapter(MarketOrderCommandHandler marketOrderCommandHandler, MarketOrderQueryHandler marketOrderQueryHandler) {
        this.marketOrderCommandHandler = marketOrderCommandHandler;
        this.marketOrderQueryHandler = marketOrderQueryHandler;
    }
}
