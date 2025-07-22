package org.endless.tianyan.sales.components.market.group.application.query.handler.impl;

import org.endless.tianyan.sales.components.market.group.application.query.handler.*;
import org.endless.tianyan.sales.components.market.group.application.query.anticorruption.*;
import org.endless.tianyan.sales.components.market.group.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.handler.*;

/**
 * MarketGroupQueryHandlerImpl
 * <p>市场分组领域查询处理器
 * <p>
 * create 2025/07/22 09:08
 * <p>
 * update 2025/07/22 09:08
 *
 * @author Deng Haozhi
 * @see MarketGroupQueryHandler
 * @since 0.0.1
 */
public class MarketGroupQueryHandlerImpl implements MarketGroupQueryHandler {

    /**
     * 市场分组聚合查询仓储接口
     */
    private final MarketGroupQueryRepository marketGroupQueryRepository;

    public MarketGroupQueryHandlerImpl(MarketGroupQueryRepository marketGroupQueryRepository) {
        this.marketGroupQueryRepository = marketGroupQueryRepository;
    }
}
