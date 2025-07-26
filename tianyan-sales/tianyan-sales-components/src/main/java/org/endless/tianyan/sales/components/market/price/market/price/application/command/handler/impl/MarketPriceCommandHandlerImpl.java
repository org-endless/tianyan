package org.endless.tianyan.sales.components.market.price.market.price.application.command.handler.impl;

import org.endless.tianyan.sales.components.market.price.market.price.application.command.handler.*;
import org.endless.tianyan.sales.components.market.price.market.price.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.handler.*;

/**
 * MarketPriceCommandHandlerImpl
 * <p>市场价格领域命令处理器
 * <p>
 * create 2025/07/26 18:56
 * <p>
 * update 2025/07/26 18:56
 *
 * @author Deng Haozhi
 * @see MarketPriceCommandHandler
 * @since 0.0.1
 */
public class MarketPriceCommandHandlerImpl implements MarketPriceCommandHandler {

    /**
     * 市场价格聚合仓储接口
     */
    private final MarketPriceRepository marketPriceRepository;

    public MarketPriceCommandHandlerImpl(MarketPriceRepository marketPriceRepository) {
        this.marketPriceRepository = marketPriceRepository;
    }
}
