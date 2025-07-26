package org.endless.tianyan.sales.components.market.price.market.price.facade.adapter.spring;

import org.endless.tianyan.sales.components.market.price.market.price.facade.adapter.*;
import org.endless.tianyan.sales.components.market.price.market.price.application.command.handler.*;
import org.endless.tianyan.sales.components.market.price.market.price.application.query.handler.*;
import org.endless.ddd.simplified.starter.common.exception.model.facade.adapter.*;

/**
 * SpringMarketPriceDrivingAdapter
 * <p>市场价格领域主动适配器Spring实现类
 * <p>
 * create 2025/07/26 18:56
 * <p>
 * update 2025/07/26 18:56
 *
 * @author Deng Haozhi
 * @see MarketPriceDrivingAdapter
 * @since 0.0.1
 */
public class SpringMarketPriceDrivingAdapter implements MarketPriceDrivingAdapter {

    /**
     * 市场价格领域命令处理器
     */
    private final MarketPriceCommandHandler marketPriceCommandHandler;

    /**
     * 市场价格领域查询处理器
     */
    private final MarketPriceQueryHandler marketPriceQueryHandler;

    public SpringMarketPriceDrivingAdapter(MarketPriceCommandHandler marketPriceCommandHandler, MarketPriceQueryHandler marketPriceQueryHandler) {
        this.marketPriceCommandHandler = marketPriceCommandHandler;
        this.marketPriceQueryHandler = marketPriceQueryHandler;
    }
}
