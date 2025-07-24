package org.endless.tianyan.sales.components.market.group.facade.adapter.spring;

import org.endless.tianyan.sales.components.market.group.application.command.handler.MarketGroupCommandHandler;
import org.endless.tianyan.sales.components.market.group.application.command.transfer.MarketGroupCreateReqCTransfer;
import org.endless.tianyan.sales.components.market.group.application.command.transfer.MarketGroupCreateRespCTransfer;
import org.endless.tianyan.sales.components.market.group.application.query.handler.MarketGroupQueryHandler;
import org.endless.tianyan.sales.components.market.group.application.query.transfer.MarketGroupFindByIdReqQTransfer;
import org.endless.tianyan.sales.components.market.group.facade.adapter.MarketGroupDrivingAdapter;

/**
 * SpringMarketGroupDrivingAdapter
 * <p>市场分组领域主动适配器Spring实现类
 * <p>
 * create 2025/07/22 16:05
 * <p>
 * update 2025/07/22 16:05
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

    @Override
    public MarketGroupCreateRespCTransfer create(MarketGroupCreateReqCTransfer command) {
        return marketGroupCommandHandler.create(command);
    }

    @Override
    public void existsById(MarketGroupFindByIdReqQTransfer query) {
        marketGroupQueryHandler.existsById(query);
    }
}
