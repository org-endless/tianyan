package org.endless.tianyan.sales.components.market.order.market.order.facade.adapter.spring;

import org.endless.tianyan.sales.components.market.order.market.order.application.command.handler.MarketOrderCommandHandler;
import org.endless.tianyan.sales.components.market.order.market.order.application.command.transfer.MarketOrderCreateReqCTransfer;
import org.endless.tianyan.sales.components.market.order.market.order.application.command.transfer.MarketOrderCreateRespCTransfer;
import org.endless.tianyan.sales.components.market.order.market.order.application.command.transfer.MarketOrderModifyReqCTransfer;
import org.endless.tianyan.sales.components.market.order.market.order.application.command.transfer.MarketOrderRemoveReqCTransfer;
import org.endless.tianyan.sales.components.market.order.market.order.application.query.handler.MarketOrderQueryHandler;
import org.endless.tianyan.sales.components.market.order.market.order.application.query.transfer.MarketOrderFindByItemIdReqQTransfer;
import org.endless.tianyan.sales.components.market.order.market.order.application.query.transfer.MarketOrderFindIdsRespQTransfer;
import org.endless.tianyan.sales.components.market.order.market.order.facade.adapter.MarketOrderDrivingAdapter;

/**
 * SpringMarketOrderDrivingAdapter
 * <p>市场订单领域主动适配器Spring实现类
 * <p>
 * create 2025/07/25 13:11
 * <p>
 * update 2025/07/25 13:11
 *
 * @author Deng Haozhi
 * @see MarketOrderDrivingAdapter
 * @since 0.0.1
 */
public class SpringMarketOrderDrivingAdapter implements MarketOrderDrivingAdapter {

    /**
     * 市场订单领域命令处理器
     */
    private final MarketOrderCommandHandler marketOrderCommandHandler;

    /**
     * 市场订单领域查询处理器
     */
    private final MarketOrderQueryHandler marketOrderQueryHandler;

    public SpringMarketOrderDrivingAdapter(MarketOrderCommandHandler marketOrderCommandHandler, MarketOrderQueryHandler marketOrderQueryHandler) {
        this.marketOrderCommandHandler = marketOrderCommandHandler;
        this.marketOrderQueryHandler = marketOrderQueryHandler;
    }

    @Override
    public MarketOrderCreateRespCTransfer create(MarketOrderCreateReqCTransfer command) {
        return marketOrderCommandHandler.create(command);
    }

    @Override
    public void modify(MarketOrderModifyReqCTransfer command) {
        marketOrderCommandHandler.modify(command);
    }

    @Override
    public void remove(MarketOrderRemoveReqCTransfer command) {
        marketOrderCommandHandler.remove(command);
    }

    @Override
    public MarketOrderFindIdsRespQTransfer findIdsByItemId(MarketOrderFindByItemIdReqQTransfer query) {
        return marketOrderQueryHandler.findIdsByItemId(query);
    }
}
