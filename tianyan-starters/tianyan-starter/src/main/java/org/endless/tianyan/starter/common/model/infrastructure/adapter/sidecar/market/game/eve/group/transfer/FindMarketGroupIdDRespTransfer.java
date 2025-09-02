package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.game.eve.group.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenRespTransfer;

/**
 * FindMarketGroupIdQRespTransfer
 * <p>市场分组ID查询被动响应传输对象
 * <p>
 * create 2025/07/26 05:28
 * <p>
 * update 2025/07/26 05:28
 *
 * @param marketGroupId 市场分组ID
 * @author Deng Haozhi
 * @see TianyanCommonDrivenRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"marketGroupId"})
public record FindMarketGroupIdDRespTransfer(
        @NotBlank(message = "市场分组ID不能为空") String marketGroupId
) implements TianyanCommonDrivenRespTransfer {

    @Override
    public FindMarketGroupIdDRespTransfer validate() {
        return this;
    }
}
