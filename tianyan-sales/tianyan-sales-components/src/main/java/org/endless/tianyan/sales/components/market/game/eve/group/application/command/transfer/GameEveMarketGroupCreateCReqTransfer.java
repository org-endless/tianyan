package org.endless.tianyan.sales.components.market.game.eve.group.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.sales.common.model.application.command.transfer.TianyanSalesCommandReqTransfer;

/**
 * GameEveMarketGroupCreateReqCTransfer
 * <p>游戏EVE市场分组创建命令请求传输对象
 * <p>
 * create 2025/07/24 20:33
 * <p>
 * update 2025/07/24 20:33
 *
 * @param marketGroupId          市场分组ID
 * @param gameEveMarketGroupCode 游戏EVE市场分组编码
 * @param createUserId           创建用户ID
 * @author Deng Haozhi
 * @see TianyanSalesCommandReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"gameEveMarketGroupCode", "createUserId"})
public record GameEveMarketGroupCreateCReqTransfer(
        @NotBlank(message = "市场分组ID不能为空") String marketGroupId,
        @NotBlank(message = "游戏EVE市场分组编码不能为空") String gameEveMarketGroupCode,
        @NotBlank(message = "创建用户ID不能为空") String createUserId
) implements TianyanSalesCommandReqTransfer {

    @Override
    public GameEveMarketGroupCreateCReqTransfer validate() {
        return this;
    }
}
