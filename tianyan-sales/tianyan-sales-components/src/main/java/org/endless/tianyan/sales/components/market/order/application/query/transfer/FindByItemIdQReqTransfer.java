package org.endless.tianyan.sales.components.market.order.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.sales.common.model.application.query.transfer.TianyanSalesQueryReqTransfer;

/**
 * MarketOrderFindByItemIdReqQTransfer
 * <p>根据资源项ID查询请求传输对象
 * <p>
 * create 2025/07/26 05:38
 * <p>
 * update 2025/07/26 05:38
 *
 * @param itemId 资源项ID
 * @author Deng Haozhi
 * @see TianyanSalesQueryReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"itemId"})
public record FindByItemIdQReqTransfer(
        @NotBlank(message = "资源项ID不能为空") String itemId
) implements TianyanSalesQueryReqTransfer {

    @Override
    public FindByItemIdQReqTransfer validate() {
        return this;
    }
}
