package org.endless.tianyan.sales.components.market.game.eve.order.application.command.handler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.sales.common.model.application.command.handler.TianyanSalesCommandHandler;
import org.endless.tianyan.sales.components.market.game.eve.order.application.command.transfer.GameEveMarketOrderFetchCReqTransfer;
import org.endless.tianyan.sales.components.market.game.eve.order.application.command.transfer.GameEveMarketOrderGeneratePriceCReqTransfer;
import org.endless.tianyan.sales.components.market.game.eve.order.domain.entity.GameEveMarketOrderAggregate;

/**
 * GameEveMarketOrderCommandHandler
 * <p>游戏EVE市场订单领域命令处理器
 * <p>
 * create 2025/07/25 11:19
 * <p>
 * update 2025/07/25 11:19
 *
 * @author Deng Haozhi
 * @see TianyanSalesCommandHandler<GameEveMarketOrderAggregate>
 * @since 0.0.1
 */
public interface GameEveMarketOrderCommandHandler extends TianyanSalesCommandHandler<GameEveMarketOrderAggregate> {

    /**
     * 游戏EVE市场订单获取命令
     *
     * @param command 游戏EVE市场订单获取命令请求传输对象
     */
    void fetch(
            @NotNull(message = "游戏EVE市场订单获取命令请求传输对象不能为空")
            @Valid GameEveMarketOrderFetchCReqTransfer command);

    /**
     * 游戏EVE市场订单生成价格命令
     *
     * @param command 游戏EVE市场订单生成价格命令请求传输对象
     */
    void generatePrice(
            @NotNull(message = "游戏EVE市场订单生成价格命令请求传输对象不能为空")
            @Valid GameEveMarketOrderGeneratePriceCReqTransfer command);

}
