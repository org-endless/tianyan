package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.group.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenReqTransfer;

/**
 * MarketGroupCreateReqCTransfer
 * <p>市场分组创建命令被动请求传输对象
 * <p>
 * create 2025/07/24 20:31
 * <p>
 * update 2025/07/24 20:31
 *
 * @param fullNameZh   市场分组中文全称
 * @param fullNameEn   市场分组英文全称
 * @param parentId     父市场分组ID
 * @param createUserId 创建用户ID
 * @author Deng Haozhi
 * @see TianyanCommonDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"fullNameZh", "fullNameEn", "parentId", "createUserId"})
public record MarketGroupCreateDReqTransfer(
        @NotBlank(message = "市场分组中文全称不能为空") String fullNameZh,
        String fullNameEn,
        String parentId,
        @NotBlank(message = "创建用户ID不能为空") String createUserId
) implements TianyanCommonDrivenReqTransfer {

    @Override
    public MarketGroupCreateDReqTransfer validate() {
        return this;
    }
}
