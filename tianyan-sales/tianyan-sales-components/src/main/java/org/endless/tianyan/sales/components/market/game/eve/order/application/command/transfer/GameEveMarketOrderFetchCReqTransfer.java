package org.endless.tianyan.sales.components.market.game.eve.order.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.sales.common.model.application.command.transfer.TianyanSalesCommandReqTransfer;

/**
 * GameEveMarketOrderFetchReqCTransfer
 * <p>游戏EVE市场订单获取命令请求传输对象
 * <p>
 * create 2025/07/28 00:37
 * <p>
 * update 2025/07/28 00:37
 *
 * @param gameEveItemCode 游戏EVE资源项编码
 * @param createUserId    创建用户ID
 * @author Deng Haozhi
 * @see TianyanSalesCommandReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"gameEveItemCode", "createUserId"})
public record GameEveMarketOrderFetchCReqTransfer(
        @NotBlank(message = "游戏EVE资源项编码不能为空") String gameEveItemCode,
        @NotBlank(message = "创建用户ID不能为空") String createUserId
) implements TianyanSalesCommandReqTransfer {

    @Override
    public GameEveMarketOrderFetchCReqTransfer validate() {
        return this;
    }
}
