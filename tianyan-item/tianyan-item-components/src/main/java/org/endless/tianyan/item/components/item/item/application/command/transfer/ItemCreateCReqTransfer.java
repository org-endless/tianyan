package org.endless.tianyan.item.components.item.item.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.item.common.model.application.command.transfer.TianyanItemCommandReqTransfer;

/**
 * ItemCreateReqCReqTransfer
 * <p>资源项创建命令请求传输对象
 * <p>
 * itemCreate 2025/07/24 20:14
 * <p>
 * update 2025/07/24 20:14
 *
 * @param itemGroupId   资源项分组ID
 * @param metagroupId   元分组ID
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
@Transfer
@JSONType(orders = {"itemGroupId", "metagroupId", "marketGroupId", "fullNameZh", "fullNameEn", "description", "createUserId"})
public record ItemCreateCReqTransfer(
        @NotBlank(message = "资源项分组ID不能为空") String itemGroupId,
        String metagroupId,
        String marketGroupId,
        @NotBlank(message = "资源项中文全称不能为空") String fullNameZh,
        String fullNameEn,
        String description,
        @NotBlank(message = "创建用户ID不能为空") String createUserId
) implements TianyanItemCommandReqTransfer {

    @Override
    public ItemCreateCReqTransfer validate() {
        return this;
    }
}
