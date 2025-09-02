package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.item.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenRespTransfer;

/**
 * FindItemIdQRespTransfer
 * <p>资源项ID查询被动响应传输对象
 * <p>
 * itemCreate 2025/07/27 23:06
 * <p>
 * update 2025/08/23 04:18
 *
 * @param itemId 资源项ID
 * @author Deng Haozhi
 * @see FindItemIdDRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"itemId"})
public record FindItemIdDRespTransfer(
        @NotBlank(message = "资源项ID不能为空") String itemId
) implements TianyanCommonDrivenRespTransfer {

    @Override
    public FindItemIdDRespTransfer validate() {
        return this;
    }
}
