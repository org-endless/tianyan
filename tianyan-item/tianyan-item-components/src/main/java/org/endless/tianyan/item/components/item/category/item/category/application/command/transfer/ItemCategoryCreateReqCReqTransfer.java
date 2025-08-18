package org.endless.tianyan.item.components.item.category.item.category.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferValidateException;
import org.endless.tianyan.item.common.model.application.command.transfer.TianyanItemCommandReqTransfer;
import org.springframework.util.StringUtils;

/**
 * ItemCategoryCreateReqCReqTransfer
 * <p>资源项分类创建命令请求传输对象
 * <p>
 * create 2025/07/24 20:15
 * <p>
 * update 2025/07/24 20:15
 *
 * @author Deng Haozhi
 * @see TianyanItemCommandReqTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"fullNameZh", "fullNameEn", "createUserId"})
public class ItemCategoryCreateReqCReqTransfer implements TianyanItemCommandReqTransfer {

    /**
     * 资源项分类中文全称
     */
    private final String fullNameZh;

    /**
     * 资源项分类英文全称
     */
    private final String fullNameEn;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    @Override
    public ItemCategoryCreateReqCReqTransfer validate() {
        validateFullNameZh();
        validateCreateUserId();
        return this;
    }

    private void validateFullNameZh() {
        if (!StringUtils.hasText(fullNameZh)) {
            throw new CommandReqTransferValidateException("资源项分类中文全称不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandReqTransferValidateException("创建用户ID不能为空");
        }
    }
}
