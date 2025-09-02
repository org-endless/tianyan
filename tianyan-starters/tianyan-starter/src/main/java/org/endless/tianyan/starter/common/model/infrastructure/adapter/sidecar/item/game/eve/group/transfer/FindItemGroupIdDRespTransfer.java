package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.group.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenRespTransfer;

/**
 * FindItemGroupIdDRespTransfer
 * <p>资源项分组ID查询被动响应传输对象
 * <p>
 * itemCreate 2025/07/26 05:25
 * <p>
 * update 2025/07/26 05:25
 *
 * @param itemGroupId 资源项分组ID
 * @author Deng Haozhi
 * @see TianyanCommonDrivenRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"itemGroupId"})
public record FindItemGroupIdDRespTransfer(
        @NotBlank(message = "资源项分组ID不能为空") String itemGroupId
) implements TianyanCommonDrivenRespTransfer {

    @Override
    public FindItemGroupIdDRespTransfer validate() {
        return this;
    }
}
