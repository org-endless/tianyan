package org.endless.tianyan.sales.components.market.order.market.order.application.command.handler.impl;

import org.endless.tianyan.sales.components.market.order.market.order.application.command.handler.*;
import org.endless.tianyan.sales.components.market.order.market.order.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.handler.*;

/**
 * MarketOrderCommandHandlerImpl
 * <p>市场订单领域命令处理器
 * <p>
 * create 2025/07/25 13:11
 * <p>
 * update 2025/07/25 13:11
 *
 * @author Deng Haozhi
 * @see MarketOrderCommandHandler
 * @since 0.0.1
 */
public class MarketOrderCommandHandlerImpl implements MarketOrderCommandHandler {

    /**
     * 市场订单聚合仓储接口
     */
    private final MarketOrderRepository marketOrderRepository;

    public MarketOrderCommandHandlerImpl(MarketOrderRepository marketOrderRepository) {
        this.marketOrderRepository = marketOrderRepository;
    }
}
