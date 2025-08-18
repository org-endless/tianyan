package org.endless.tianyan.item.components.item.item.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandRespTransferValidateException;
import org.endless.tianyan.item.common.model.application.command.transfer.TianyanItemCommandRespTransfer;
import org.springframework.util.StringUtils;

/**
 * ItemCreateRespCReqTransfer
 * <p>资源项创建命令响应传输对象
 * <p>
 * create 2025/07/24 20:14
 * <p>
 * update 2025/08/18 18:21:19
 *
 * @param itemId 资源项ID
 * @author Deng Haozhi
 * @see TianyanItemCommandRespTransfer
 * @since 0.0.1
 */
@Builder
@JSONType(orders = {"itemId"})
public record ItemCreateCRespTransfer(
        String itemId
) implements TianyanItemCommandRespTransfer {

    @Override
    public ItemCreateCRespTransfer validate() {
        validateItemId();
        return this;
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new CommandRespTransferValidateException("资源项ID不能为空");
        }
    }
}
