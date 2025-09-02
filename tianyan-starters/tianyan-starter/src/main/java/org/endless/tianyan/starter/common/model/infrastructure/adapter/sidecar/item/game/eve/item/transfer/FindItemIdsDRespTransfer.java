package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.item.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenRespTransfer;

import java.util.List;

/**
 * FindItemIdsQRespTransfer
 * <p>资源项ID列表查询被动响应传输对象
 * <p>
 * itemCreate 2025/07/27 23:06
 * <p>
 * update 2025/08/23 04:18
 *
 * @param itemIds 资源项ID列表
 * @author Deng Haozhi
 * @see TianyanCommonDrivenRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"itemIds"})
public record FindItemIdsDRespTransfer(
        @NotEmpty(message = "资源项ID列表不能为空") List<String> itemIds
) implements TianyanCommonDrivenRespTransfer {

    @Override
    public FindItemIdsDRespTransfer validate() {
        return this;
    }
}
