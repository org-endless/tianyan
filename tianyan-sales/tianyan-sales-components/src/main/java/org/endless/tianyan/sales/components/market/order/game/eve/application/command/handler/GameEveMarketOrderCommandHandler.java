package org.endless.tianyan.sales.components.market.order.game.eve.application.command.handler;

import org.endless.tianyan.sales.common.model.application.command.handler.TianyanSalesCommandHandler;
import org.endless.tianyan.sales.components.market.order.game.eve.application.command.transfer.GameEveMarketOrderFetchReqCTransfer;
import org.endless.tianyan.sales.components.market.order.game.eve.application.command.transfer.GameEveMarketOrderGeneratePriceReqCTransfer;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.entity.GameEveMarketOrderAggregate;

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

    void fetch(GameEveMarketOrderFetchReqCTransfer command);

    void generatePrice(GameEveMarketOrderGeneratePriceReqCTransfer command);

}
