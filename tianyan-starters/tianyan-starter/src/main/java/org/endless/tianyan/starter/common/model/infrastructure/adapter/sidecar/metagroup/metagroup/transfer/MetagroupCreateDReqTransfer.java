package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.metagroup.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenReqTransfer;

/**
 * MetagroupCreateReqCTransfer
 * <p>元分组创建命令被动请求传输对象
 * <p>
 * create 2025/07/24 20:25
 * <p>
 * update 2025/08/23 23:08
 *
 * @param fullNameZh   元分组中文全称
 * @param fullNameEn   元分组英文全称
 * @param createUserId 创建用户ID
 * @author Deng Haozhi
 * @see TianyanCommonDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"fullNameZh", "fullNameEn", "createUserId"})
public record MetagroupCreateDReqTransfer(
        @NotBlank(message = "元分组中文全称不能为空") String fullNameZh,
        String fullNameEn,
        @NotBlank(message = "创建用户ID不能为空") String createUserId
) implements TianyanCommonDrivenReqTransfer {

    @Override
    public MetagroupCreateDReqTransfer validate() {
        return this;
    }
}
