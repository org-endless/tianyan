package org.endless.tianyan.item.components.item.category.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.item.common.model.application.command.transfer.TianyanItemCommandReqTransfer;

/**
 * ItemCategoryCreateReqCReqTransfer
 * <p>资源项分类创建命令请求传输对象
 * <p>
 * itemCreate 2025/07/24 20:15
 * <p>
 * update 2025/07/24 20:15
 *
 * @param fullNameZh   资源项分类中文全称
 * @param fullNameEn   资源项分类英文全称
 * @param createUserId 创建用户ID
 * @author Deng Haozhi
 * @see TianyanItemCommandReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"fullNameZh", "fullNameEn", "createUserId"})
public record ItemCategoryCreateCReqTransfer(
        @NotBlank(message = "资源项分类中文全称不能为空") String fullNameZh,
        String fullNameEn,
        @NotBlank(message = "创建用户ID不能为空") String createUserId
) implements TianyanItemCommandReqTransfer {

    @Override
    public ItemCategoryCreateCReqTransfer validate() {
        return this;
    }
}
