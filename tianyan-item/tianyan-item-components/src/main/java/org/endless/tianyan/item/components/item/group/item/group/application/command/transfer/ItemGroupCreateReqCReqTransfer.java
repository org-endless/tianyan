package org.endless.tianyan.item.components.item.group.item.group.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferValidateException;
import org.endless.tianyan.item.common.model.application.command.transfer.TianyanItemCommandReqTransfer;
import org.springframework.util.StringUtils;

/**
 * ItemGroupCreateReqCReqTransfer
 * <p>资源项分组创建命令请求传输对象
 * <p>
 * itemCreate 2025/07/24 20:23
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
@JSONType(orders = {"fullNameZh", "fullNameEn", "createUserId"})
public class ItemGroupCreateReqCReqTransfer implements TianyanItemCommandReqTransfer {

    /**
     * 资源项分组中文全称
     */
    private final String fullNameZh;

    /**
     * 资源项分组英文全称
     */
    private final String fullNameEn;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    @Override
    public ItemGroupCreateReqCReqTransfer validate() {
        validateFullNameZh();
        validateCreateUserId();
        return this;
    }

    private void validateFullNameZh() {
        if (!StringUtils.hasText(fullNameZh)) {
            throw new CommandReqTransferValidateException("资源项分组中文全称不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandReqTransferValidateException("创建用户ID不能为空");
        }
    }
}
