package org.endless.tianyan.sales.components.market.game.eve.group.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.sales.common.model.application.query.transfer.TianyanSalesQueryRespTransfer;

/**
 * FindMarketGroupIdQRespTransfer
 * <p>市场分组ID查询响应传输对象
 * <p>
 * create 2025/07/26 05:28
 * <p>
 * update 2025/07/26 05:28
 *
 * @param marketGroupId 市场分组ID
 * @author Deng Haozhi
 * @see TianyanSalesQueryRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"marketGroupId"})
public record FindMarketGroupIdQRespTransfer(
        @NotBlank(message = "市场分组ID不能为空") String marketGroupId
) implements TianyanSalesQueryRespTransfer {

    @Override
    public FindMarketGroupIdQRespTransfer validate() {
        return this;
    }
}
