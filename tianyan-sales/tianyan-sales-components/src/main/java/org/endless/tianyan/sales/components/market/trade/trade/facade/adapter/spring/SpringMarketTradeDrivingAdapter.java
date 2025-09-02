package org.endless.tianyan.sales.components.market.trade.trade.facade.adapter.spring;

import org.endless.tianyan.sales.components.market.trade.trade.application.command.handler.MarketTradeCommandHandler;
import org.endless.tianyan.sales.components.market.trade.trade.application.query.handler.MarketTradeQueryHandler;
import org.endless.tianyan.sales.components.market.trade.trade.facade.adapter.MarketTradeDrivingAdapter;

/**
 * SpringMarketTradeDrivingAdapter
 * <p>市场交易领域主动适配器Spring实现类
 * <p>
 * create 2025/07/26 18:57
 * <p>
 * update 2025/07/26 18:57
 *
 * @author Deng Haozhi
 * @see MarketTradeDrivingAdapter
 * @since 0.0.1
 */
public class SpringMarketTradeDrivingAdapter implements MarketTradeDrivingAdapter {

    /**
     * 市场交易领域命令处理器
     */
    private final MarketTradeCommandHandler marketTradeCommandHandler;

    /**
     * 市场交易领域查询处理器
     */
    private final MarketTradeQueryHandler marketTradeQueryHandler;

    public SpringMarketTradeDrivingAdapter(MarketTradeCommandHandler marketTradeCommandHandler, MarketTradeQueryHandler marketTradeQueryHandler) {
        this.marketTradeCommandHandler = marketTradeCommandHandler;
        this.marketTradeQueryHandler = marketTradeQueryHandler;
    }
}
