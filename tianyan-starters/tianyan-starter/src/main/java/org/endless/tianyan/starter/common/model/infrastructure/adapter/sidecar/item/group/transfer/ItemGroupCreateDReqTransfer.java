package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.group.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenRespTransfer;

/**
 * ItemGroupCreateDRespTransfer
 * <p>资源项分组创建命令被动请求传输对象
 * <p>
 * create 2025/08/23 02:06
 * <p>
 * update 2025/08/23 02:06
 *
 * @param itemCategoryId 资源项分类ID
 * @param fullNameZh     资源项分组中文全称
 * @param fullNameEn     资源项分组英文全称
 * @param createUserId   创建用户ID
 * @author Deng Haozhi
 * @see TianyanCommonDrivenRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"itemCategoryId", "fullNameZh", "fullNameEn", "createUserId"})
public record ItemGroupCreateDReqTransfer(
        String itemCategoryId,
        @NotBlank(message = "资源项分组中文全称不能为空") String fullNameZh,
        String fullNameEn,
        @NotBlank(message = "创建用户ID不能为空") String createUserId
) implements TianyanCommonDrivenRespTransfer {

    @Override
    public ItemGroupCreateDReqTransfer validate() {
        return this;
    }
}
