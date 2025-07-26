package org.endless.tianyan.sales.components.market.price.history.application.query.handler.impl;

import org.endless.tianyan.sales.components.market.price.history.application.query.handler.*;
import org.endless.tianyan.sales.components.market.price.history.application.query.anticorruption.*;
import org.endless.tianyan.sales.components.market.price.history.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.handler.*;

/**
 * MarketPriceHistoryQueryHandlerImpl
 * <p>市场价格历史领域查询处理器
 * <p>
 * create 2025/07/26 18:57
 * <p>
 * update 2025/07/26 18:57
 *
 * @author Deng Haozhi
 * @see MarketPriceHistoryQueryHandler
 * @since 0.0.1
 */
public class MarketPriceHistoryQueryHandlerImpl implements MarketPriceHistoryQueryHandler {

    /**
     * 市场价格历史聚合查询仓储接口
     */
    private final MarketPriceHistoryQueryRepository marketPriceHistoryQueryRepository;

    public MarketPriceHistoryQueryHandlerImpl(MarketPriceHistoryQueryRepository marketPriceHistoryQueryRepository) {
        this.marketPriceHistoryQueryRepository = marketPriceHistoryQueryRepository;
    }
}
