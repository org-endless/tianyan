package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.group.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenRespTransfer;

/**
 * ItemGroupCreateDRespTransfer
 * <p>资源项分组创建命令被动响应传输对象
 * <p>
 * create 2025/08/23 02:43
 * <p>
 * update 2025/08/23 05:30
 *
 * @param itemGroupId 资源项分组ID
 * @author Deng Haozhi
 * @see TianyanCommonDrivenRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"itemGroupId"})
public record ItemGroupCreateDRespTransfer(
        @NotBlank(message = "资源项分组ID不能为空") String itemGroupId
) implements TianyanCommonDrivenRespTransfer {

    @Override
    public ItemGroupCreateDRespTransfer validate() {
        return this;
    }
}
