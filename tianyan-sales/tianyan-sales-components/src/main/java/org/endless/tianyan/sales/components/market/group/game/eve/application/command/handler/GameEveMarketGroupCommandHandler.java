package org.endless.tianyan.sales.components.market.group.game.eve.application.command.handler;

import org.endless.tianyan.sales.common.model.application.command.handler.TianyanSalesCommandHandler;
import org.endless.tianyan.sales.components.market.group.game.eve.application.command.transfer.GameEveMarketGroupCreateReqCTransfer;
import org.endless.tianyan.sales.components.market.group.game.eve.domain.entity.GameEveMarketGroupAggregate;

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

    void create(GameEveMarketGroupCreateReqCTransfer command);

}
