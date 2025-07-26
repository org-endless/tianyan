package org.endless.tianyan.sales.components.market.trade.history.application.command.handler.impl;

import org.endless.tianyan.sales.components.market.trade.history.application.command.handler.*;
import org.endless.tianyan.sales.components.market.trade.history.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.handler.*;

/**
 * MarketTradeHistoryCommandHandlerImpl
 * <p>市场交易历史领域命令处理器
 * <p>
 * create 2025/07/26 18:57
 * <p>
 * update 2025/07/26 18:57
 *
 * @author Deng Haozhi
 * @see MarketTradeHistoryCommandHandler
 * @since 0.0.1
 */
public class MarketTradeHistoryCommandHandlerImpl implements MarketTradeHistoryCommandHandler {

    /**
     * 市场交易历史聚合仓储接口
     */
    private final MarketTradeHistoryRepository marketTradeHistoryRepository;

    public MarketTradeHistoryCommandHandlerImpl(MarketTradeHistoryRepository marketTradeHistoryRepository) {
        this.marketTradeHistoryRepository = marketTradeHistoryRepository;
    }
}
