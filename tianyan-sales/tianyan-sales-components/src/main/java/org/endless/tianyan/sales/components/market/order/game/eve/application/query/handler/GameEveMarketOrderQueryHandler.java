package org.endless.tianyan.sales.components.market.order.game.eve.application.query.handler;

import org.endless.tianyan.sales.common.model.application.query.handler.TianyanSalesQueryHandler;
import org.endless.tianyan.sales.components.market.order.game.eve.application.query.transfer.GameEveMarketOrderFindItemIdsRespQTransfer;

/**
 * GameEveMarketOrderQueryHandler
 * <p>游戏EVE市场订单领域查询处理器
 * <p>
 * create 2025/07/25 11:19
 * <p>
 * update 2025/07/25 11:19
 *
 * @author Deng Haozhi
 * @see TianyanSalesQueryHandler
 * @since 0.0.1
 */
public interface GameEveMarketOrderQueryHandler extends TianyanSalesQueryHandler {

    GameEveMarketOrderFindItemIdsRespQTransfer fetchCodes();

}
