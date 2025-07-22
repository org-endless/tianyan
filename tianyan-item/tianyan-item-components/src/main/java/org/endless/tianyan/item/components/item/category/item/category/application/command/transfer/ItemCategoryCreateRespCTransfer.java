package org.endless.tianyan.item.components.item.category.item.category.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.CommandTransferValidateException;
import org.endless.tianyan.item.common.model.application.command.transfer.TianyanItemCommandTransfer;
import org.springframework.util.StringUtils;

/**
 * ItemCategoryCreateRespCTransfer
 * <p>物品分类创建命令响应传输对象
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
@JSONType(orders = {"itemCategoryId"})
public class ItemCategoryCreateRespCTransfer implements TianyanItemCommandTransfer {

    /**
     * 物品分类ID
     */
    private final String itemCategoryId;

    @Override
    public ItemCategoryCreateRespCTransfer validate() {
        validateItemCategoryId();
        return this;
    }

    private void validateItemCategoryId() {
        if (!StringUtils.hasText(itemCategoryId)) {
            throw new CommandTransferValidateException("物品分类ID不能为空");
        }
    }
}
