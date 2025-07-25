package org.endless.tianyan.sales.components.market.order.game.eve.application.command.handler.impl;

import org.endless.tianyan.sales.components.market.order.game.eve.application.command.handler.GameEveMarketOrderCommandHandler;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.anticorruption.GameEveMarketOrderDrivenAdapter;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.anticorruption.GameEveMarketOrderRepository;

/**
 * GameEveMarketOrderCommandHandlerImpl
 * <p>游戏EVE市场订单领域命令处理器
 * <p>
 * create 2025/07/25 11:19
 * <p>
 * update 2025/07/25 11:19
 *
 * @author Deng Haozhi
 * @see GameEveMarketOrderCommandHandler
 * @since 0.0.1
 */
public class GameEveMarketOrderCommandHandlerImpl implements GameEveMarketOrderCommandHandler {

    /**
     * 游戏EVE市场订单聚合仓储接口
     */
    private final GameEveMarketOrderRepository gameEveMarketOrderRepository;

    /**
     * 游戏EVE市场订单被动适配器接口
     */
    private final GameEveMarketOrderDrivenAdapter gameEveMarketOrderDrivenAdapter;

    public GameEveMarketOrderCommandHandlerImpl(GameEveMarketOrderRepository gameEveMarketOrderRepository, GameEveMarketOrderDrivenAdapter gameEveMarketOrderDrivenAdapter) {
        this.gameEveMarketOrderRepository = gameEveMarketOrderRepository;
        this.gameEveMarketOrderDrivenAdapter = gameEveMarketOrderDrivenAdapter;
    }


}
