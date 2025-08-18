package org.endless.tianyan.sales.components.market.trade.history.application.query.handler.impl;

import org.endless.tianyan.sales.components.market.trade.history.application.query.anticorruption.MarketTradeHistoryQueryRepository;
import org.endless.tianyan.sales.components.market.trade.history.application.query.handler.MarketTradeHistoryQueryHandler;

/**
 * MarketTradeHistoryQueryHandlerImpl
 * <p>市场交易历史领域查询处理器
 * <p>
 * create 2025/07/26 18:57
 * <p>
 * update 2025/07/26 18:57
 *
 * @author Deng Haozhi
 * @see MarketTradeHistoryQueryHandler
 * @since 0.0.1
 */
public class MarketTradeHistoryQueryHandlerImpl implements MarketTradeHistoryQueryHandler {

    /**
     * 市场交易历史聚合查询仓储接口
     */
    private final MarketTradeHistoryQueryRepository marketTradeHistoryQueryRepository;

    public MarketTradeHistoryQueryHandlerImpl(MarketTradeHistoryQueryRepository marketTradeHistoryQueryRepository) {
        this.marketTradeHistoryQueryRepository = marketTradeHistoryQueryRepository;
    }
}
