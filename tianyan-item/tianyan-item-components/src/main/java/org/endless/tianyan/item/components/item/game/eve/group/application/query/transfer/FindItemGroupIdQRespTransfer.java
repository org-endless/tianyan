package org.endless.tianyan.item.components.item.game.eve.group.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.item.common.model.application.query.transfer.TianyanItemQueryReqTransfer;
import org.endless.tianyan.item.common.model.application.query.transfer.TianyanItemQueryRespTransfer;

/**
 * FindItemGroupIdQRespTransfer
 * <p>资源项分组ID查询响应传输对象
 * <p>
 * itemCreate 2025/07/26 05:25
 * <p>
 * update 2025/07/26 05:25
 *
 * @param itemGroupId 资源项分组ID
 * @author Deng Haozhi
 * @see TianyanItemQueryReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"itemGroupId"})
public record FindItemGroupIdQRespTransfer(
        @NotBlank(message = "资源项分组ID不能为空") String itemGroupId
) implements TianyanItemQueryRespTransfer {

    @Override
    public FindItemGroupIdQRespTransfer validate() {
        return this;
    }
}
