package org.endless.tianyan.sales.components.market.game.eve.group.application.query.handler.impl;

import org.endless.tianyan.sales.components.market.game.eve.group.application.query.handler.*;
import org.endless.tianyan.sales.components.market.game.eve.group.application.query.anticorruption.*;
import org.endless.tianyan.sales.components.market.game.eve.group.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.handler.*;

/**
 * GameEveMarketGroupQueryHandlerImpl
 * <p>游戏EVE市场分组领域查询处理器
 * <p>
 * create 2025/07/22 09:09
 * <p>
 * update 2025/07/22 09:09
 *
 * @author Deng Haozhi
 * @see GameEveMarketGroupQueryHandler
 * @since 0.0.1
 */
public class GameEveMarketGroupQueryHandlerImpl implements GameEveMarketGroupQueryHandler {

    /**
     * 游戏EVE市场分组聚合查询仓储接口
     */
    private final GameEveMarketGroupQueryRepository gameEveMarketGroupQueryRepository;

    public GameEveMarketGroupQueryHandlerImpl(GameEveMarketGroupQueryRepository gameEveMarketGroupQueryRepository) {
        this.gameEveMarketGroupQueryRepository = gameEveMarketGroupQueryRepository;
    }
}
