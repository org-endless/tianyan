package org.endless.tianyan.sales.components.market.trade.market.trade.application.command.handler.impl;

import org.endless.tianyan.sales.components.market.trade.market.trade.application.command.handler.*;
import org.endless.tianyan.sales.components.market.trade.market.trade.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.handler.*;

/**
 * MarketTradeCommandHandlerImpl
 * <p>市场交易领域命令处理器
 * <p>
 * create 2025/07/26 18:57
 * <p>
 * update 2025/07/26 18:57
 *
 * @author Deng Haozhi
 * @see MarketTradeCommandHandler
 * @since 0.0.1
 */
public class MarketTradeCommandHandlerImpl implements MarketTradeCommandHandler {

    /**
     * 市场交易聚合仓储接口
     */
    private final MarketTradeRepository marketTradeRepository;

    public MarketTradeCommandHandlerImpl(MarketTradeRepository marketTradeRepository) {
        this.marketTradeRepository = marketTradeRepository;
    }
}
