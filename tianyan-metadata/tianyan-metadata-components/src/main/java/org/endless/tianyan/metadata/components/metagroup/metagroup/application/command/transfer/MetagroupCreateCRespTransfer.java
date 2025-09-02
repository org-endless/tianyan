package org.endless.tianyan.metadata.components.metagroup.metagroup.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.metadata.common.model.application.command.transfer.TianyanMetadataCommandRespTransfer;

/**
 * MetagroupCreateRespCTransfer
 * <p>元分组创建命令响应传输对象
 * <p>
 * create 2025/07/24 20:25
 * <p>
 * update 2025/07/24 20:25
 *
 * @param metagroupId 元分组ID
 * @author Deng Haozhi
 * @see TianyanMetadataCommandRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"metagroupId"})
public record MetagroupCreateCRespTransfer(
        @NotBlank(message = "元分组ID不能为空") String metagroupId
) implements TianyanMetadataCommandRespTransfer {

    @Override
    public MetagroupCreateCRespTransfer validate() {
        return this;
    }
}
