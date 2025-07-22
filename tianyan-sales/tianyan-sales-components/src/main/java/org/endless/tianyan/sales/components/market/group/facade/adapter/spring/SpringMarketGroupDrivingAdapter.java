package org.endless.tianyan.sales.components.market.group.facade.adapter.spring;

import org.endless.tianyan.sales.components.market.group.facade.adapter.*;
import org.endless.tianyan.sales.components.market.group.application.command.handler.*;
import org.endless.tianyan.sales.components.market.group.application.query.handler.*;
import org.endless.ddd.simplified.starter.common.exception.model.facade.adapter.*;

/**
 * SpringMarketGroupDrivingAdapter
 * <p>市场分组领域主动适配器Spring实现类
 * <p>
 * create 2025/07/22 09:08
 * <p>
 * update 2025/07/22 09:08
 *
 * @author Deng Haozhi
 * @see MarketGroupDrivingAdapter
 * @since 0.0.1
 */
public class SpringMarketGroupDrivingAdapter implements MarketGroupDrivingAdapter {

    /**
     * 市场分组领域命令处理器
     */
    private final MarketGroupCommandHandler marketGroupCommandHandler;

    /**
     * 市场分组领域查询处理器
     */
    private final MarketGroupQueryHandler marketGroupQueryHandler;

    public SpringMarketGroupDrivingAdapter(MarketGroupCommandHandler marketGroupCommandHandler, MarketGroupQueryHandler marketGroupQueryHandler) {
        this.marketGroupCommandHandler = marketGroupCommandHandler;
        this.marketGroupQueryHandler = marketGroupQueryHandler;
    }
}
