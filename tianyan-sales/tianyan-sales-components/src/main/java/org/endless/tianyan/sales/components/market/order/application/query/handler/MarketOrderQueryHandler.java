package org.endless.tianyan.sales.components.market.order.application.query.handler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.sales.common.model.application.query.handler.TianyanSalesQueryHandler;
import org.endless.tianyan.sales.components.market.order.application.query.transfer.FindByItemIdQReqTransfer;
import org.endless.tianyan.sales.components.market.order.application.query.transfer.FindMarketOrderIdsQRespTransfer;

/**
 * MarketOrderQueryHandler
 * <p>市场订单领域查询处理器
 * <p>
 * create 2025/07/25 13:11
 * <p>
 * update 2025/07/25 13:11
 *
 * @author Deng Haozhi
 * @see TianyanSalesQueryHandler
 * @since 0.0.1
 */
public interface MarketOrderQueryHandler extends TianyanSalesQueryHandler {

    /**
     * 根据资源项ID查询市场订单ID列表
     *
     * @param query 根据资源项ID查询请求传输对象
     * @return {@link FindMarketOrderIdsQRespTransfer }
     */
    @Valid
    @NotNull(message = "市场订单ID列表查询响应传输对象不能为空")
    FindMarketOrderIdsQRespTransfer findIdsByItemId(
            @NotNull(message = "根据资源项ID查询请求传输对象不能为空")
            @Valid FindByItemIdQReqTransfer query);

}
