package org.endless.tianyan.sales.components.market.game.eve.group.application.command.handler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.sales.common.model.application.command.handler.TianyanSalesCommandHandler;
import org.endless.tianyan.sales.components.market.game.eve.group.application.command.transfer.GameEveMarketGroupCreateCReqTransfer;
import org.endless.tianyan.sales.components.market.game.eve.group.domain.entity.GameEveMarketGroupAggregate;

/**
 * GameEveMarketGroupCommandHandler
 * <p>游戏EVE市场分组领域命令处理器
 * <p>
 * create 2025/07/24 17:37
 * <p>
 * update 2025/07/24 17:37
 *
 * @author Deng Haozhi
 * @see TianyanSalesCommandHandler<GameEveMarketGroupAggregate>
 * @since 0.0.1
 */
public interface GameEveMarketGroupCommandHandler extends TianyanSalesCommandHandler<GameEveMarketGroupAggregate> {

    /**
     * 游戏EVE市场分组创建命令
     *
     * @param command 游戏EVE市场分组创建命令请求传输对象
     */
    void create(
            @NotNull(message = "游戏EVE市场分组创建命令请求传输对象不能为空")
            @Valid GameEveMarketGroupCreateCReqTransfer command);

}
