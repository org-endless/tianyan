package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.order.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.ddd.starter.common.annotation.validate.number.amount.TransferAmount;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenReqTransfer;

/**
 * MarketOrderCreateReqCTransfer
 * <p>市场订单创建命令被动请求传输对象
 * <p>
 * create 2025/07/28 00:46
 * <p>
 * update 2025/07/28 00:46
 *
 * @param itemId             资源项ID
 * @param type               市场订单类型
 * @param totalItemQuantity  市场订单资源项总数(20, 5)
 * @param remainItemQuantity 市场订单资源项剩余数量(20, 5)
 * @param minItemQuantity    市场订单资源项最小交易数量(20, 5)
 * @param price              市场订单价格(17, 2)
 * @param issuedAt           市场订单创建时间(yyyy-MM-dd HH:mm:ss:SSS)
 * @param expireAt           市场订单过期时间(yyyy-MM-dd HH:mm:ss:SSS)
 * @param createUserId       创建用户ID
 * @author Deng Haozhi
 * @see TianyanCommonDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"itemId", "type", "totalItemQuantity", "remainItemQuantity", "minItemQuantity", "price", "issuedAt", "expireAt", "createUserId"})
public record MarketOrderCreateDReqTransfer(
        @NotBlank(message = "资源项ID不能为空") String itemId,
        @NotBlank(message = "市场订单类型不能为空") String type,
        @NotBlank(message = "市场订单资源项总数不能为空") String totalItemQuantity,
        @NotBlank(message = "市场订单资源项剩余数量不能为空") String remainItemQuantity,
        @NotBlank(message = "市场订单资源项最小交易数量不能为空") String minItemQuantity,
        @NotBlank(message = "市场订单价格不能为空") @TransferAmount String price,
        @NotBlank(message = "市场订单创建时间不能为空") String issuedAt,
        @NotBlank(message = "市场订单过期时间不能为空") String expireAt,
        @NotBlank(message = "创建用户ID不能为空") String createUserId
) implements TianyanCommonDrivenReqTransfer {

    @Override
    public MarketOrderCreateDReqTransfer validate() {
        return this;
    }
}
