package org.endless.tianyan.item.components.item.category.item.category.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandRespTransferValidateException;
import org.endless.tianyan.item.common.model.application.command.transfer.TianyanItemCommandReqTransfer;
import org.springframework.util.StringUtils;

/**
 * ItemCategoryCreateRespCReqTransfer
 * <p>资源项分类创建命令响应传输对象
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
@JSONType(orders = {"itemCategoryId"})
public class ItemCategoryCreateRespCReqTransfer implements TianyanItemCommandReqTransfer {

    /**
     * 资源项分类ID
     */
    private final String itemCategoryId;

    @Override
    public ItemCategoryCreateRespCReqTransfer validate() {
        validateItemCategoryId();
        return this;
    }

    private void validateItemCategoryId() {
        if (!StringUtils.hasText(itemCategoryId)) {
            throw new CommandRespTransferValidateException("资源项分类ID不能为空");
        }
    }
}
