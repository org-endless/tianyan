package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.order.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.number.amount.TransferAmount;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenReqTransfer;

/**
 * MarketOrderModifyReqCTransfer
 * <p>市场订单修改命令被动请求传输对象
 * <p>
 * create 2025/07/28 00:46
 * <p>
 * update 2025/07/28 00:46
 *
 * @param marketOrderId      市场订单ID
 * @param totalItemQuantity  市场订单资源项总数(20, 5)
 * @param remainItemQuantity 市场订单资源项剩余数量(20, 5)
 * @param minItemQuantity    市场订单资源项最小交易数量(20, 5)
 * @param price              市场订单价格(17, 2)
 * @param issuedAt           市场订单创建时间(yyyy-MM-dd HH:mm:ss:SSS)
 * @param expireAt           市场订单过期时间(yyyy-MM-dd HH:mm:ss:SSS)
 * @param modifyUserId       修改用户ID
 * @author Deng Haozhi
 * @see TianyanCommonDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@JSONType(orders = {"marketOrderId", "totalItemQuantity", "remainItemQuantity", "minItemQuantity", "price", "issuedAt", "expireAt", "modifyUserId"})
public record MarketOrderModifyDReqTransfer(
        @NotBlank(message = "市场订单ID不能为空") String marketOrderId,
        String totalItemQuantity,
        String remainItemQuantity,
        String minItemQuantity,
        @TransferAmount String price,
        String issuedAt,
        String expireAt,
        @NotBlank(message = "修改用户ID不能为空") String modifyUserId
) implements TianyanCommonDrivenReqTransfer {

    @Override
    public MarketOrderModifyDReqTransfer validate() {
        return this;
    }
}
