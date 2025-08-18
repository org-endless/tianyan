package org.endless.tianyan.item.components.item.group.item.group.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandRespTransferValidateException;
import org.endless.tianyan.item.common.model.application.command.transfer.TianyanItemCommandReqTransfer;
import org.springframework.util.StringUtils;

/**
 * ItemGroupCreateRespCReqTransfer
 * <p>资源项分组创建命令响应传输对象
 * <p>
 * create 2025/07/24 20:23
 * <p>
 * update 2025/07/24 20:23
 *
 * @author Deng Haozhi
 * @see TianyanItemCommandReqTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"itemGroupId"})
public class ItemGroupCreateRespCReqTransfer implements TianyanItemCommandReqTransfer {

    /**
     * 资源项分组ID
     */
    private final String itemGroupId;

    @Override
    public ItemGroupCreateRespCReqTransfer validate() {
        validateItemGroupId();
        return this;
    }

    private void validateItemGroupId() {
        if (!StringUtils.hasText(itemGroupId)) {
            throw new CommandRespTransferValidateException("资源项分组ID不能为空");
        }
    }
}
