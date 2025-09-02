package org.endless.tianyan.item.components.item.group.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.item.common.model.application.command.transfer.TianyanItemCommandRespTransfer;

/**
 * ItemGroupCreateRespCReqTransfer
 * <p>资源项分组创建命令响应传输对象
 * <p>
 * itemCreate 2025/07/24 20:23
 * <p>
 * update 2025/07/24 20:23
 *
 * @param itemGroupId 资源项分组ID
 * @author Deng Haozhi
 * @see TianyanItemCommandRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"itemGroupId"})
public record ItemGroupCreateCRespTransfer(
        @NotBlank(message = "资源项分组ID不能为空") String itemGroupId
) implements TianyanItemCommandRespTransfer {

    @Override
    public ItemGroupCreateCRespTransfer validate() {
        return this;
    }
}
