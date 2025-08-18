package org.endless.tianyan.metadata.components.meta.group.meta.group.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferValidateException;
import org.endless.tianyan.metadata.common.model.application.command.transfer.TianyanMetadataCommandTransfer;
import org.springframework.util.StringUtils;

/**
 * MetaGroupCreateReqCTransfer
 * <p>元分组创建命令请求传输对象
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
@JSONType(orders = {"fullNameZh", "fullNameEn", "createUserId"})
public class MetaGroupCreateReqCTransfer implements TianyanMetadataCommandTransfer {

    /**
     * 元分组中文全称
     */
    private final String fullNameZh;

    /**
     * 元分组英文全称
     */
    private final String fullNameEn;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    @Override
    public MetaGroupCreateReqCTransfer validate() {
        validateFullNameZh();
        validateCreateUserId();
        return this;
    }

    private void validateFullNameZh() {
        if (!StringUtils.hasText(fullNameZh)) {
            throw new CommandReqTransferValidateException("元分组中文全称不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandReqTransferValidateException("创建用户ID不能为空");
        }
    }
}
