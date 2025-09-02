package org.endless.tianyan.sales.components.market.order.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.sales.common.model.application.command.transfer.TianyanSalesCommandRespTransfer;

/**
 * MarketOrderCreateRespCTransfer
 * <p>市场订单创建命令响应传输对象
 * <p>
 * create 2025/07/28 00:46
 * <p>
 * update 2025/07/28 00:46
 *
 * @param marketOrderId 市场订单ID
 * @author Deng Haozhi
 * @see TianyanSalesCommandRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"marketOrderId"})
public record MarketOrderCreateCRespTransfer(
        @NotBlank(message = "市场订单ID不能为空") String marketOrderId
) implements TianyanSalesCommandRespTransfer {

    @Override
    public MarketOrderCreateCRespTransfer validate() {
        return this;
    }
}
