package org.endless.tianyan.metadata.components.meta.group.meta.group.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandRespTransferValidateException;
import org.endless.tianyan.metadata.common.model.application.command.transfer.TianyanMetadataCommandTransfer;
import org.springframework.util.StringUtils;

/**
 * MetaGroupCreateRespCTransfer
 * <p>元分组创建命令响应传输对象
 * <p>
 * create 2025/07/24 20:25
 * <p>
 * update 2025/07/24 20:25
 *
 * @author Deng Haozhi
 * @see TianyanMetadataCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"metaGroupId"})
public class MetaGroupCreateRespCTransfer implements TianyanMetadataCommandTransfer {

    /**
     * 元分组ID
     */
    private final String metaGroupId;

    @Override
    public MetaGroupCreateRespCTransfer validate() {
        validateMetaGroupId();
        return this;
    }

    private void validateMetaGroupId() {
        if (!StringUtils.hasText(metaGroupId)) {
            throw new CommandRespTransferValidateException("元分组ID不能为空");
        }
    }
}
