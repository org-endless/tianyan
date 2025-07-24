package org.endless.tianyan.sales.components.market.group.application.command.handler;

import org.endless.tianyan.sales.common.model.application.command.handler.TianyanSalesCommandHandler;
import org.endless.tianyan.sales.components.market.group.application.command.transfer.MarketGroupCreateReqCTransfer;
import org.endless.tianyan.sales.components.market.group.application.command.transfer.MarketGroupCreateRespCTransfer;
import org.endless.tianyan.sales.components.market.group.domain.entity.MarketGroupAggregate;

/**
 * MarketGroupCommandHandler
 * <p>市场分组领域命令处理器
 * <p>
 * create 2025/07/22 16:05
 * <p>
 * update 2025/07/22 16:05
 *
 * @author Deng Haozhi
 * @see TianyanSalesCommandHandler<MarketGroupAggregate>
 * @since 0.0.1
 */
public interface MarketGroupCommandHandler extends TianyanSalesCommandHandler<MarketGroupAggregate> {

    MarketGroupCreateRespCTransfer create(MarketGroupCreateReqCTransfer command);

}
