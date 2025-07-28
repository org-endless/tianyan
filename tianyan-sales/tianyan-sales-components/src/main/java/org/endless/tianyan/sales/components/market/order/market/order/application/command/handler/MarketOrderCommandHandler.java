package org.endless.tianyan.sales.components.market.order.market.order.application.command.handler;

import org.endless.tianyan.sales.common.model.application.command.handler.TianyanSalesCommandHandler;
import org.endless.tianyan.sales.components.market.order.market.order.application.command.transfer.*;
import org.endless.tianyan.sales.components.market.order.market.order.domain.entity.MarketOrderAggregate;

/**
 * MarketOrderCommandHandler
 * <p>市场订单领域命令处理器
 * <p>
 * create 2025/07/25 13:11
 * <p>
 * update 2025/07/25 13:11
 *
 * @author Deng Haozhi
 * @see TianyanSalesCommandHandler<MarketOrderAggregate>
 * @since 0.0.1
 */
public interface MarketOrderCommandHandler extends TianyanSalesCommandHandler<MarketOrderAggregate> {

    MarketOrderCreateRespCTransfer create(MarketOrderCreateReqCTransfer command);

    void modify(MarketOrderModifyReqCTransfer command);

    void remove(MarketOrderRemoveReqCTransfer command);

    void generatePrice(MarketOrderGeneratePriceReqCTransfer command);

}
