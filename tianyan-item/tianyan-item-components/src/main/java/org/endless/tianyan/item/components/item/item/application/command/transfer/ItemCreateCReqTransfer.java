package org.endless.tianyan.item.components.item.item.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferValidateException;
import org.endless.tianyan.item.common.model.application.command.transfer.TianyanItemCommandReqTransfer;
import org.springframework.util.StringUtils;

/**
 * ItemCreateReqCReqTransfer
 * <p>资源项创建命令请求传输对象
 * <p>
 * create 2025/07/24 20:14
 * <p>
 * update 2025/07/24 20:14
 *
 * @param metaGroupId   元分组ID
 * @param itemGroupId   资源项分组ID
 * @param marketGroupId 市场分组ID
 * @param fullNameZh    资源项中文全称
 * @param fullNameEn    资源项英文全称
 * @param description   资源项描述
 * @param createUserId  创建用户ID
 * @author Deng Haozhi
 * @see TianyanItemCommandReqTransfer
 * @since 0.0.1
 */
@Builder
@JSONType(orders = {"metaGroupId", "itemGroupId", "marketGroupId", "fullNameZh", "fullNameEn", "description", "createUserId"})
public record ItemCreateCReqTransfer(
        String metaGroupId,
        String itemGroupId,
        String marketGroupId,
        String fullNameZh,
        String fullNameEn,
        String description,
        String createUserId
) implements TianyanItemCommandReqTransfer {

    @Override
    public ItemCreateCReqTransfer validate() {
        validateItemGroupId();
        validateFullNameZh();
        validateCreateUserId();
        return this;
    }

    private void validateItemGroupId() {
        if (!StringUtils.hasText(itemGroupId)) {
            throw new CommandReqTransferValidateException("资源项分组ID不能为空");
        }
    }

    private void validateFullNameZh() {
        if (!StringUtils.hasText(fullNameZh)) {
            throw new CommandReqTransferValidateException("资源项中文全称不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandReqTransferValidateException("创建用户ID不能为空");
        }
    }
}
