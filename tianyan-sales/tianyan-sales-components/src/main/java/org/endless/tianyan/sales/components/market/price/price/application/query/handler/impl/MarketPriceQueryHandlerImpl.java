package org.endless.tianyan.sales.components.market.price.price.application.query.handler.impl;

import org.endless.tianyan.sales.components.market.price.price.application.query.anticorruption.MarketPriceQueryRepository;
import org.endless.tianyan.sales.components.market.price.price.application.query.handler.MarketPriceQueryHandler;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * MarketPriceQueryHandlerImpl
 * <p>市场价格领域查询处理器
 * <p>
 * create 2025/07/26 18:56
 * <p>
 * update 2025/07/26 18:56
 *
 * @author Deng Haozhi
 * @see MarketPriceQueryHandler
 * @since 0.0.1
 */
@Lazy
@Service
@Validated
public class MarketPriceQueryHandlerImpl implements MarketPriceQueryHandler {

    /**
     * 市场价格聚合查询仓储接口
     */
    private final MarketPriceQueryRepository marketPriceQueryRepository;

    public MarketPriceQueryHandlerImpl(MarketPriceQueryRepository marketPriceQueryRepository) {
        this.marketPriceQueryRepository = marketPriceQueryRepository;
    }
}
