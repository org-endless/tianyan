package org.endless.tianyan.item.components.item.item.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
import org.endless.ddd.starter.common.annotation.validate.ddd.transfer.Transfer;
import org.endless.tianyan.item.common.model.application.command.transfer.TianyanItemCommandRespTransfer;

/**
 * ItemCreateRespCReqTransfer
 * <p>资源项创建命令响应传输对象
 * <p>
 * itemCreate 2025/07/24 20:14
 * <p>
 * update 2025/08/18 18:21:19
 *
 * @param itemId 资源项ID
 * @author Deng Haozhi
 * @see TianyanItemCommandRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"itemId"})
public record ItemCreateCRespTransfer(
        @NotBlank(message = "资源项ID不能为空") String itemId
) implements TianyanItemCommandRespTransfer {

    @Override
    public ItemCreateCRespTransfer validate() {
        return this;
    }
}
