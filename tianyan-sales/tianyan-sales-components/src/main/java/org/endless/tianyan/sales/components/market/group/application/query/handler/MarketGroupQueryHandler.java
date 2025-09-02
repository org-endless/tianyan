package org.endless.tianyan.sales.components.market.group.application.query.handler;

import org.endless.tianyan.sales.common.model.application.query.handler.TianyanSalesQueryHandler;
import org.endless.tianyan.sales.components.market.group.application.query.transfer.MarketGroupFindByIdReqQReqTransfer;

/**
 * MarketGroupQueryHandler
 * <p>市场分组领域查询处理器
 * <p>
 * create 2025/07/24 17:36
 * <p>
 * update 2025/07/24 17:36
 *
 * @author Deng Haozhi
 * @see TianyanSalesQueryHandler
 * @since 0.0.1
 */
public interface MarketGroupQueryHandler extends TianyanSalesQueryHandler {

    void existsById(MarketGroupFindByIdReqQReqTransfer query);

}
