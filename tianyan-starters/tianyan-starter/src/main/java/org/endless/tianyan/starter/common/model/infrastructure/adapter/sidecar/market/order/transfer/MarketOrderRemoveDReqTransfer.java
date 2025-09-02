package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.order.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenReqTransfer;

/**
 * MarketOrderRemoveReqCTransfer
 * <p>市场订单删除命令被动请求传输对象
 * <p>
 * create 2025/07/28 00:46
 * <p>
 * update 2025/07/28 00:46
 *
 * @param marketOrderId 市场订单ID
 * @param modifyUserId  修改用户ID
 * @author Deng Haozhi
 * @see TianyanCommonDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@JSONType(orders = {"marketOrderId", "modifyUserId"})
public record MarketOrderRemoveDReqTransfer(
        @NotBlank(message = "市场订单ID不能为空") String marketOrderId,
        @NotBlank(message = "修改用户ID不能为空") String modifyUserId
) implements TianyanCommonDrivenReqTransfer {

    @Override
    public MarketOrderRemoveDReqTransfer validate() {
        return this;
    }
}
