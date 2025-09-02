package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.order.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenRespTransfer;

import java.util.List;

/**
 * MarketOrderFindIdsRespQTransfer
 * <p>市场订单ID列表查询被动响应传输对象
 * <p>
 * create 2025/07/26 05:38
 * <p>
 * update 2025/07/26 05:38
 *
 * @param marketOrderIds 市场订单ID列表
 * @author Deng Haozhi
 * @see TianyanCommonDrivenRespTransfer
 * @since 0.0.1
 */
@Builder
@JSONType(orders = {"marketOrderIds"})
public record FindMarketOrderIdsDRespTransfer(
        List<String> marketOrderIds
) implements TianyanCommonDrivenRespTransfer {

    @Override
    public FindMarketOrderIdsDRespTransfer validate() {
        return this;
    }
}
