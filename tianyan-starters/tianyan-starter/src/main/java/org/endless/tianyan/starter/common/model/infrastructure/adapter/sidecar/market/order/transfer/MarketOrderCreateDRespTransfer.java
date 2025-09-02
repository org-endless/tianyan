package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.order.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenRespTransfer;

/**
 * MarketOrderCreateRespCTransfer
 * <p>市场订单创建命令被动响应传输对象
 * <p>
 * create 2025/07/28 00:46
 * <p>
 * update 2025/07/28 00:46
 *
 * @param marketOrderId 市场订单ID
 * @author Deng Haozhi
 * @see TianyanCommonDrivenRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"marketOrderId"})
public record MarketOrderCreateDRespTransfer(
        @NotBlank(message = "市场订单ID不能为空") String marketOrderId
) implements TianyanCommonDrivenRespTransfer {

    @Override
    public MarketOrderCreateDRespTransfer validate() {
        return this;
    }
}
