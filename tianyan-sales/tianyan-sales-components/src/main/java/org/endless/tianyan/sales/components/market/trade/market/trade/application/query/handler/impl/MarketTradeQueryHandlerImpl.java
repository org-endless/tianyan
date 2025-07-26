package org.endless.tianyan.sales.components.market.trade.market.trade.application.query.handler.impl;

import org.endless.tianyan.sales.components.market.trade.market.trade.application.query.handler.*;
import org.endless.tianyan.sales.components.market.trade.market.trade.application.query.anticorruption.*;
import org.endless.tianyan.sales.components.market.trade.market.trade.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.handler.*;

/**
 * MarketTradeQueryHandlerImpl
 * <p>市场交易领域查询处理器
 * <p>
 * create 2025/07/26 18:57
 * <p>
 * update 2025/07/26 18:57
 *
 * @author Deng Haozhi
 * @see MarketTradeQueryHandler
 * @since 0.0.1
 */
public class MarketTradeQueryHandlerImpl implements MarketTradeQueryHandler {

    /**
     * 市场交易聚合查询仓储接口
     */
    private final MarketTradeQueryRepository marketTradeQueryRepository;

    public MarketTradeQueryHandlerImpl(MarketTradeQueryRepository marketTradeQueryRepository) {
        this.marketTradeQueryRepository = marketTradeQueryRepository;
    }
}
