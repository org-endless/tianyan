package org.endless.tianyan.sales.components.market.group.game.eve.application.query.handler;

import org.endless.tianyan.sales.common.model.application.query.handler.TianyanSalesQueryHandler;
import org.endless.tianyan.sales.components.market.group.game.eve.application.query.transfer.GameEveMarketGroupFindByCodeReqQTransfer;
import org.endless.tianyan.sales.components.market.group.game.eve.application.query.transfer.GameEveMarketGroupFindIdRespQTransfer;

/**
 * GameEveMarketGroupQueryHandler
 * <p>游戏EVE市场分组领域查询处理器
 * <p>
 * create 2025/07/24 17:37
 * <p>
 * update 2025/07/24 17:37
 *
 * @author Deng Haozhi
 * @see TianyanSalesQueryHandler
 * @since 0.0.1
 */
public interface GameEveMarketGroupQueryHandler extends TianyanSalesQueryHandler {

    GameEveMarketGroupFindIdRespQTransfer findMarketGroupIdByCode(GameEveMarketGroupFindByCodeReqQTransfer query);

}
