package org.endless.tianyan.sales.components.market.price.history.application.command.handler.impl;

import org.endless.tianyan.sales.components.market.price.history.application.command.handler.*;
import org.endless.tianyan.sales.components.market.price.history.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.handler.*;

/**
 * MarketPriceHistoryCommandHandlerImpl
 * <p>市场价格历史领域命令处理器
 * <p>
 * create 2025/07/26 18:57
 * <p>
 * update 2025/07/26 18:57
 *
 * @author Deng Haozhi
 * @see MarketPriceHistoryCommandHandler
 * @since 0.0.1
 */
public class MarketPriceHistoryCommandHandlerImpl implements MarketPriceHistoryCommandHandler {

    /**
     * 市场价格历史聚合仓储接口
     */
    private final MarketPriceHistoryRepository marketPriceHistoryRepository;

    public MarketPriceHistoryCommandHandlerImpl(MarketPriceHistoryRepository marketPriceHistoryRepository) {
        this.marketPriceHistoryRepository = marketPriceHistoryRepository;
    }
}
