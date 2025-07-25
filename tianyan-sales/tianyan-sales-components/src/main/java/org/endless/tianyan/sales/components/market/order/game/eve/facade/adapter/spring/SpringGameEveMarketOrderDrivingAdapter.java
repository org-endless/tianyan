package org.endless.tianyan.sales.components.market.order.game.eve.facade.adapter.spring;

import org.endless.tianyan.sales.components.market.order.game.eve.facade.adapter.*;
import org.endless.tianyan.sales.components.market.order.game.eve.application.command.handler.*;
import org.endless.tianyan.sales.components.market.order.game.eve.application.query.handler.*;
import org.endless.ddd.simplified.starter.common.exception.model.facade.adapter.*;

/**
 * SpringGameEveMarketOrderDrivingAdapter
 * <p>游戏EVE市场订单领域主动适配器Spring实现类
 * <p>
 * create 2025/07/25 11:19
 * <p>
 * update 2025/07/25 11:19
 *
 * @author Deng Haozhi
 * @see GameEveMarketOrderDrivingAdapter
 * @since 0.0.1
 */
public class SpringGameEveMarketOrderDrivingAdapter implements GameEveMarketOrderDrivingAdapter {

    /**
     * 游戏EVE市场订单领域命令处理器
     */
    private final GameEveMarketOrderCommandHandler gameEveMarketOrderCommandHandler;

    /**
     * 游戏EVE市场订单领域查询处理器
     */
    private final GameEveMarketOrderQueryHandler gameEveMarketOrderQueryHandler;

    public SpringGameEveMarketOrderDrivingAdapter(GameEveMarketOrderCommandHandler gameEveMarketOrderCommandHandler, GameEveMarketOrderQueryHandler gameEveMarketOrderQueryHandler) {
        this.gameEveMarketOrderCommandHandler = gameEveMarketOrderCommandHandler;
        this.gameEveMarketOrderQueryHandler = gameEveMarketOrderQueryHandler;
    }
}
