package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.category.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenRespTransfer;

/**
 * FindItemCategoryIdDRespTransfer
 * <p>资源项分类ID查询被动响应传输对象
 * <p>
 * itemCreate 2025/07/26 05:25
 * <p>
 * update 2025/08/23 04:17
 *
 * @param itemCategoryId 资源项分类ID
 * @author Deng Haozhi
 * @see TianyanCommonDrivenRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"itemCategoryId"})
public record FindItemCategoryIdDRespTransfer(
        @NotBlank(message = "资源项分类ID不能为空") String itemCategoryId
) implements TianyanCommonDrivenRespTransfer {

    @Override
    public FindItemCategoryIdDRespTransfer validate() {
        return this;
    }
}
