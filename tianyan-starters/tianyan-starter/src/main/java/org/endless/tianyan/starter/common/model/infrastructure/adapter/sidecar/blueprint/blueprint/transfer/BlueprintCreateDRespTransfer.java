package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.blueprint.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenRespTransfer;

/**
 * BlueprintCreateDRespTransfer
 * <p>
 * 蓝图创建命令被动响应传输对象
 * <p>
 * create 2025/08/24 19:51
 * <p>
 * update 2025/08/24 19:51
 *
 * @param blueprintId 蓝图ID
 * @author Deng Haozhi
 * @see TianyanCommonDrivenRespTransfer
 * @since 1.0.0
 */
@Builder
@Transfer
@JSONType(orders = {"blueprintId"})
public record BlueprintCreateDRespTransfer(
        @NotBlank(message = "蓝图ID不能为空") String blueprintId) implements TianyanCommonDrivenRespTransfer {

    @Override
    public BlueprintCreateDRespTransfer validate() {
        return this;
    }
}
