package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.metagroup.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenRespTransfer;

/**
 * MetagroupCreateRespCTransfer
 * <p>元分组创建命令被动响应传输对象
 * <p>
 * create 2025/07/24 20:25
 * <p>
 * update 2025/08/23 23:09
 *
 * @param metagroupId 元分组ID
 * @author Deng Haozhi
 * @see TianyanCommonDrivenRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"metagroupId"})
public record MetagroupCreateDRespTransfer(
        @NotBlank(message = "元分组ID不能为空") String metagroupId
) implements TianyanCommonDrivenRespTransfer {

    @Override
    public MetagroupCreateDRespTransfer validate() {
        return this;
    }
}
