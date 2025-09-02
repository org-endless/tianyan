package org.endless.tianyan.sales.components.market.group.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.sales.common.model.application.command.transfer.TianyanSalesCommandRespTransfer;

/**
 * MarketGroupCreateRespCTransfer
 * <p>市场分组创建命令响应传输对象
 * <p>
 * create 2025/07/24 20:31
 * <p>
 * update 2025/08/24 04:10
 *
 * @param marketGroupId 市场分组ID
 * @author Deng Haozhi
 * @see TianyanSalesCommandRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"marketGroupId"})
public record MarketGroupCreateCRespTransfer(
        @NotBlank(message = "市场分组ID不能为空") String marketGroupId
) implements TianyanSalesCommandRespTransfer {

    @Override
    public MarketGroupCreateCRespTransfer validate() {
        return this;
    }
}
