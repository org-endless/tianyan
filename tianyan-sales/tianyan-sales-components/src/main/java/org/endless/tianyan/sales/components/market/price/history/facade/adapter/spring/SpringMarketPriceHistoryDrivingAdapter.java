package org.endless.tianyan.sales.components.market.price.history.facade.adapter.spring;

import org.endless.tianyan.sales.components.market.price.history.application.command.handler.MarketPriceHistoryCommandHandler;
import org.endless.tianyan.sales.components.market.price.history.application.query.handler.MarketPriceHistoryQueryHandler;
import org.endless.tianyan.sales.components.market.price.history.facade.adapter.MarketPriceHistoryDrivingAdapter;

/**
 * SpringMarketPriceHistoryDrivingAdapter
 * <p>市场价格历史领域主动适配器Spring实现类
 * <p>
 * create 2025/07/26 18:57
 * <p>
 * update 2025/07/26 18:57
 *
 * @author Deng Haozhi
 * @see MarketPriceHistoryDrivingAdapter
 * @since 0.0.1
 */
public class SpringMarketPriceHistoryDrivingAdapter implements MarketPriceHistoryDrivingAdapter {

    /**
     * 市场价格历史领域命令处理器
     */
    private final MarketPriceHistoryCommandHandler marketPriceHistoryCommandHandler;

    /**
     * 市场价格历史领域查询处理器
     */
    private final MarketPriceHistoryQueryHandler marketPriceHistoryQueryHandler;

    public SpringMarketPriceHistoryDrivingAdapter(MarketPriceHistoryCommandHandler marketPriceHistoryCommandHandler, MarketPriceHistoryQueryHandler marketPriceHistoryQueryHandler) {
        this.marketPriceHistoryCommandHandler = marketPriceHistoryCommandHandler;
        this.marketPriceHistoryQueryHandler = marketPriceHistoryQueryHandler;
    }
}
