package org.endless.tianyan.sales.components.market.group.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.sales.common.model.application.command.transfer.TianyanSalesCommandReqTransfer;

/**
 * MarketGroupModifyParentCReqTransfer
 * <p>市场分组修改父分组命令请求传输对象
 * <p>
 * create 2025/07/24 20:31
 * <p>
 * update 2025/07/24 20:31
 *
 * @param marketGroupId 市场分组ID
 * @param parentId      父市场分组ID
 * @param modifyUserId  修改用户ID
 * @author Deng Haozhi
 * @see TianyanSalesCommandReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"marketGroupId", "parentId", "modifyUserId"})
public record MarketGroupModifyParentCReqTransfer(
        @NotBlank(message = "市场分组中文全称不能为空") String marketGroupId,
        @NotBlank(message = "父市场分组ID不能为空") String parentId,
        @NotBlank(message = "修改用户ID不能为空") String modifyUserId
) implements TianyanSalesCommandReqTransfer {

    @Override
    public MarketGroupModifyParentCReqTransfer validate() {
        return this;
    }
}
