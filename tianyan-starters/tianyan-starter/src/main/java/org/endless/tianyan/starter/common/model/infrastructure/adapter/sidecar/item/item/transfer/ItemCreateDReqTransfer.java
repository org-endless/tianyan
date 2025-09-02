package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.item.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenReqTransfer;

/**
 * ItemCreateDRespTransfer
 * <p>资源项创建命令被动请求传输对象
 * <p>
 * create 2025/08/23 00:36
 * <p>
 * update 2025/08/23 00:36
 *
 * @param itemGroupId   资源项分组ID
 * @param metagroupId   元分组ID
 * @param marketGroupId 市场分组ID
 * @param fullNameZh    资源项中文全称
 * @param fullNameEn    资源项英文全称
 * @param description   资源项描述
 * @param createUserId  创建用户ID
 * @author Deng Haozhi
 * @see TianyanCommonDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"itemGroupId", "metagroupId", "marketGroupId", "fullNameZh", "fullNameEn", "description", "createUserId"})
public record ItemCreateDReqTransfer(
        @NotBlank(message = "资源项分组ID不能为空") String itemGroupId,
        String metagroupId,
        String marketGroupId,
        @NotBlank(message = "资源项中文全称不能为空") String fullNameZh,
        String fullNameEn,
        String description,
        @NotBlank(message = "创建用户ID不能为空") String createUserId
) implements TianyanCommonDrivenReqTransfer {

    @Override
    public ItemCreateDReqTransfer validate() {
        return this;
    }
}
