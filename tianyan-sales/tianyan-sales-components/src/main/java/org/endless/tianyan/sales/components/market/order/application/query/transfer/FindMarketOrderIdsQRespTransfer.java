package org.endless.tianyan.sales.components.market.order.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.tianyan.sales.common.model.application.query.transfer.TianyanSalesQueryRespTransfer;

import java.util.List;

/**
 * MarketOrderFindIdsRespQTransfer
 * <p>市场订单ID列表查询响应传输对象
 * <p>
 * create 2025/07/26 05:38
 * <p>
 * update 2025/07/26 05:38
 *
 * @param marketOrderIds 市场订单ID列表
 * @author Deng Haozhi
 * @see TianyanSalesQueryRespTransfer
 * @since 0.0.1
 */
@Builder
@JSONType(orders = {"marketOrderIds"})
public record FindMarketOrderIdsQRespTransfer(
        List<String> marketOrderIds
) implements TianyanSalesQueryRespTransfer {

    @Override
    public FindMarketOrderIdsQRespTransfer validate() {
        return this;
    }
}
