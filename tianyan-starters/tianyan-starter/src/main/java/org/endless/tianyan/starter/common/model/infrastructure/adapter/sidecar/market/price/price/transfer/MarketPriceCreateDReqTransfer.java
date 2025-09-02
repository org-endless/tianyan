package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.price.price.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.ddd.starter.common.annotation.validate.number.amount.TransferAmount;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenReqTransfer;

/**
 * MarketPriceCreateReqCTransfer
 * <p>市场价格创建命令被动请求传输对象
 * <p>
 * create 2025/07/27 21:56
 * <p>
 * update 2025/07/27 21:56
 *
 * @param itemId       资源项ID
 * @param buyPrice     买入价格(17, 2)
 * @param sellPrice    卖出价格(17, 2)
 * @param createUserId 创建用户ID
 * @author Deng Haozhi
 * @see TianyanCommonDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"itemId", "buyPrice", "sellPrice", "createUserId"})
public record MarketPriceCreateDReqTransfer(
        @NotBlank(message = "资源项ID不能为空") String itemId,
        @NotBlank(message = "买入价格不能为空") @TransferAmount String buyPrice,
        @NotBlank(message = "卖出价格不能为空") @TransferAmount String sellPrice,
        @NotBlank(message = "创建用户ID不能为空") String createUserId
) implements TianyanCommonDrivenReqTransfer {

    @Override
    public MarketPriceCreateDReqTransfer validate() {
        return this;
    }
}
