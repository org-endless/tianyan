package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.item.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenRespTransfer;

/**
 * ItemCreateDRespTransfer
 * <p>资源项创建命令被动响应传输对象
 * <p>
 * create 2025/08/23 00:38
 * <p>
 * update 2025/08/23 00:38
 *
 * @param itemId 资源项ID
 * @author Deng Haozhi
 * @see TianyanCommonDrivenRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"itemId"})
public record ItemCreateDRespTransfer(
        @NotBlank(message = "资源项ID不能为空") String itemId
) implements TianyanCommonDrivenRespTransfer {

    @Override
    public ItemCreateDRespTransfer validate() {
        return this;
    }
}
