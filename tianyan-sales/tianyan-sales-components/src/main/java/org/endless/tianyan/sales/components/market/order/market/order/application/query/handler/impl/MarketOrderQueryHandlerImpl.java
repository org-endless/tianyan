package org.endless.tianyan.sales.components.market.order.market.order.application.query.handler.impl;

import org.endless.tianyan.sales.components.market.order.market.order.application.query.handler.*;
import org.endless.tianyan.sales.components.market.order.market.order.application.query.anticorruption.*;
import org.endless.tianyan.sales.components.market.order.market.order.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.handler.*;

/**
 * MarketOrderQueryHandlerImpl
 * <p>市场订单领域查询处理器
 * <p>
 * create 2025/07/25 13:11
 * <p>
 * update 2025/07/25 13:11
 *
 * @author Deng Haozhi
 * @see MarketOrderQueryHandler
 * @since 0.0.1
 */
public class MarketOrderQueryHandlerImpl implements MarketOrderQueryHandler {

    /**
     * 市场订单聚合查询仓储接口
     */
    private final MarketOrderQueryRepository marketOrderQueryRepository;

    public MarketOrderQueryHandlerImpl(MarketOrderQueryRepository marketOrderQueryRepository) {
        this.marketOrderQueryRepository = marketOrderQueryRepository;
    }
}
