package org.endless.tianyan.sales.components.market.group.application.command.handler.impl;

import org.endless.tianyan.sales.components.market.group.application.command.handler.*;
import org.endless.tianyan.sales.components.market.group.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.handler.*;

/**
 * MarketGroupCommandHandlerImpl
 * <p>市场分组领域命令处理器
 * <p>
 * create 2025/07/22 09:08
 * <p>
 * update 2025/07/22 09:08
 *
 * @author Deng Haozhi
 * @see MarketGroupCommandHandler
 * @since 0.0.1
 */
public class MarketGroupCommandHandlerImpl implements MarketGroupCommandHandler {

    /**
     * 市场分组聚合仓储接口
     */
    private final MarketGroupRepository marketGroupRepository;

    public MarketGroupCommandHandlerImpl(MarketGroupRepository marketGroupRepository) {
        this.marketGroupRepository = marketGroupRepository;
    }
}
