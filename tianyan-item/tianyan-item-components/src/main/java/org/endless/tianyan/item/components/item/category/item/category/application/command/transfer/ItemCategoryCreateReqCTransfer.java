package org.endless.tianyan.item.components.item.category.item.category.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.CommandTransferValidateException;
import org.endless.tianyan.item.common.model.application.command.transfer.TianyanItemCommandTransfer;
import org.springframework.util.StringUtils;

/**
 * ItemCategoryCreateReqCTransfer
 * <p>物品分类创建命令请求传输对象
 * <p>
 * create 2025/07/20 22:55
 * <p>
 * update 2025/07/20 22:55
 *
 * @author Deng Haozhi
 * @see TianyanItemCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"nameZh", "nameEn", "createUserId"})
public class ItemCategoryCreateReqCTransfer implements TianyanItemCommandTransfer {

    /**
     * 物品分类中文名称
     */
    private final String nameZh;

    /**
     * 物品分类英文名称
     */
    private final String nameEn;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    @Override
    public ItemCategoryCreateReqCTransfer validate() {
        validateNameZh();
        validateNameEn();
        validateCreateUserId();
        return this;
    }

    private void validateNameZh() {
        if (!StringUtils.hasText(nameZh)) {
            throw new CommandTransferValidateException("物品分类中文名称不能为空");
        }
    }

    private void validateNameEn() {
        if (!StringUtils.hasText(nameEn)) {
            throw new CommandTransferValidateException("物品分类英文名称不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandTransferValidateException("创建用户ID不能为空");
        }
    }
}
