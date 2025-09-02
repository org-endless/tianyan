package org.endless.tianyan.sales.components.market.order.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.tianyan.sales.common.model.application.command.transfer.TianyanSalesCommandReqTransfer;

/**
 * MarketOrderRemoveReqCTransfer
 * <p>市场订单删除命令请求传输对象
 * <p>
 * create 2025/07/28 00:46
 * <p>
 * update 2025/07/28 00:46
 *
 * @param marketOrderId 市场订单ID
 * @param modifyUserId  修改用户ID
 * @author Deng Haozhi
 * @see TianyanSalesCommandReqTransfer
 * @since 0.0.1
 */
@Builder
@JSONType(orders = {"marketOrderId", "modifyUserId"})
public record MarketOrderRemoveCReqTransfer(
        @NotBlank(message = "市场订单ID不能为空") String marketOrderId,
        @NotBlank(message = "修改用户ID不能为空") String modifyUserId
) implements TianyanSalesCommandReqTransfer {

    @Override
    public MarketOrderRemoveCReqTransfer validate() {
        return this;
    }
}
