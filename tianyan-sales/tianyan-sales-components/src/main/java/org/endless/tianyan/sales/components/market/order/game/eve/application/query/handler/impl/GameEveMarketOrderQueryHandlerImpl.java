package org.endless.tianyan.sales.components.market.order.game.eve.application.query.handler.impl;

import org.endless.tianyan.sales.components.market.order.game.eve.application.query.handler.*;
import org.endless.tianyan.sales.components.market.order.game.eve.application.query.anticorruption.*;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.handler.*;

/**
 * GameEveMarketOrderQueryHandlerImpl
 * <p>游戏EVE市场订单领域查询处理器
 * <p>
 * create 2025/07/25 11:19
 * <p>
 * update 2025/07/25 11:19
 *
 * @author Deng Haozhi
 * @see GameEveMarketOrderQueryHandler
 * @since 0.0.1
 */
public class GameEveMarketOrderQueryHandlerImpl implements GameEveMarketOrderQueryHandler {

    /**
     * 游戏EVE市场订单聚合查询仓储接口
     */
    private final GameEveMarketOrderQueryRepository gameEveMarketOrderQueryRepository;

    public GameEveMarketOrderQueryHandlerImpl(GameEveMarketOrderQueryRepository gameEveMarketOrderQueryRepository) {
        this.gameEveMarketOrderQueryRepository = gameEveMarketOrderQueryRepository;
    }
}
