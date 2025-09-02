package org.endless.tianyan.sales.components.market.group.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.sales.common.model.application.query.transfer.TianyanSalesQueryReqTransfer;

/**
 * MarketGroupFindByIdReqQTransfer
 * <p>市场分组根ID查询请求传输对象
 * <p>
 * create 2025/07/24 17:36
 * <p>
 * update 2025/07/24 17:36
 *
 * @param marketGroupId 市场分组ID
 * @author Deng Haozhi
 * @see TianyanSalesQueryReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"marketGroupId"})
public record MarketGroupFindByIdReqQReqTransfer(
        @NotBlank(message = "市场分组ID不能为空") String marketGroupId
) implements TianyanSalesQueryReqTransfer {

    @Override
    public MarketGroupFindByIdReqQReqTransfer validate() {
        return this;
    }
}
