package org.endless.tianyan.item.components.item.category.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.item.common.model.application.command.transfer.TianyanItemCommandRespTransfer;

/**
 * ItemCategoryCreateRespCReqTransfer
 * <p>资源项分类创建命令响应传输对象
 * <p>
 * itemCreate 2025/07/24 20:15
 * <p>
 * update 2025/07/24 20:15
 *
 * @param itemCategoryId 资源项分类ID
 * @author Deng Haozhi
 * @see TianyanItemCommandRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"itemCategoryId"})
public record ItemCategoryCreateCRespTransfer(
        @NotBlank(message = "资源项分类ID不能为空") String itemCategoryId
) implements TianyanItemCommandRespTransfer {

    @Override
    public ItemCategoryCreateCRespTransfer validate() {
        return this;
    }
}
