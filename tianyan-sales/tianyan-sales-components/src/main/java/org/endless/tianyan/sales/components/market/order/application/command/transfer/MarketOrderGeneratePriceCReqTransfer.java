package org.endless.tianyan.sales.components.market.order.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.tianyan.sales.common.model.application.command.transfer.TianyanSalesCommandReqTransfer;

/**
 * MarketOrderGeneratePriceReqCTransfer
 * <p>市场订单生成价格命令请求传输对象
 * <p>
 * create 2025/07/28 00:46
 * <p>
 * update 2025/07/28 00:46
 *
 * @param itemId       资源项ID
 * @param createUserId 创建用户ID
 * @author Deng Haozhi
 * @see TianyanSalesCommandReqTransfer
 * @since 0.0.1
 */
@Builder
@JSONType(orders = {"itemId", "createUserId"})
public record MarketOrderGeneratePriceCReqTransfer(
        @NotBlank(message = "资源项ID不能为空") String itemId,
        @NotBlank(message = "创建用户ID不能为空") String createUserId
) implements TianyanSalesCommandReqTransfer {

    @Override
    public MarketOrderGeneratePriceCReqTransfer validate() {
        return this;
    }
}
