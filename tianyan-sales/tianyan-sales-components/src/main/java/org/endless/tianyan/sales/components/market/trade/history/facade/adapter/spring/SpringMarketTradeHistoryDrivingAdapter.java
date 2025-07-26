package org.endless.tianyan.sales.components.market.trade.history.facade.adapter.spring;

import org.endless.tianyan.sales.components.market.trade.history.facade.adapter.*;
import org.endless.tianyan.sales.components.market.trade.history.application.command.handler.*;
import org.endless.tianyan.sales.components.market.trade.history.application.query.handler.*;
import org.endless.ddd.simplified.starter.common.exception.model.facade.adapter.*;

/**
 * SpringMarketTradeHistoryDrivingAdapter
 * <p>市场交易历史领域主动适配器Spring实现类
 * <p>
 * create 2025/07/26 18:57
 * <p>
 * update 2025/07/26 18:57
 *
 * @author Deng Haozhi
 * @see MarketTradeHistoryDrivingAdapter
 * @since 0.0.1
 */
public class SpringMarketTradeHistoryDrivingAdapter implements MarketTradeHistoryDrivingAdapter {

    /**
     * 市场交易历史领域命令处理器
     */
    private final MarketTradeHistoryCommandHandler marketTradeHistoryCommandHandler;

    /**
     * 市场交易历史领域查询处理器
     */
    private final MarketTradeHistoryQueryHandler marketTradeHistoryQueryHandler;

    public SpringMarketTradeHistoryDrivingAdapter(MarketTradeHistoryCommandHandler marketTradeHistoryCommandHandler, MarketTradeHistoryQueryHandler marketTradeHistoryQueryHandler) {
        this.marketTradeHistoryCommandHandler = marketTradeHistoryCommandHandler;
        this.marketTradeHistoryQueryHandler = marketTradeHistoryQueryHandler;
    }
}
