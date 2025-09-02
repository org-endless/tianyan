package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.blueprint.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenReqTransfer;

/**
 * BlueprintCreateDReqTransfer
 * <p>
 * 蓝图创建命令被动请求传输对象
 * <p>
 * create 2025/08/24 19:50
 * <p>
 * update 2025/08/24 19:50
 *
 * @param itemId        资源项ID
 * @param blueprintCode 蓝图编码
 * @param isPublished   蓝图是否发布
 * @param createUserId  创建用户ID
 * @author Deng Haozhi
 * @see TianyanCommonDrivenReqTransfer
 * @since 1.0.0
 */
@Builder
@Transfer
@JSONType(orders = {"itemId", "blueprintCode", "isPublished", "createUserId"})
public record BlueprintCreateDReqTransfer(
        @NotBlank(message = "资源项ID不能为空") String itemId,
        @NotBlank(message = "蓝图编码不能为空") String blueprintCode,
        @NotBlank(message = "蓝图是否发布不能为空") Boolean isPublished,
        @NotBlank(message = "创建用户ID不能为空") String createUserId) implements TianyanCommonDrivenReqTransfer {

    @Override
    public BlueprintCreateDReqTransfer validate() {
        return this;
    }
}
