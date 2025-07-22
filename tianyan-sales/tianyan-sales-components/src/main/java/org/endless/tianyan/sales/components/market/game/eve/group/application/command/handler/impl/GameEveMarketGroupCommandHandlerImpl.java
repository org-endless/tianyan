package org.endless.tianyan.sales.components.market.game.eve.group.application.command.handler.impl;

import org.endless.tianyan.sales.components.market.game.eve.group.application.command.handler.*;
import org.endless.tianyan.sales.components.market.game.eve.group.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.handler.*;

/**
 * GameEveMarketGroupCommandHandlerImpl
 * <p>游戏EVE市场分组领域命令处理器
 * <p>
 * create 2025/07/22 09:09
 * <p>
 * update 2025/07/22 09:09
 *
 * @author Deng Haozhi
 * @see GameEveMarketGroupCommandHandler
 * @since 0.0.1
 */
public class GameEveMarketGroupCommandHandlerImpl implements GameEveMarketGroupCommandHandler {

    /**
     * 游戏EVE市场分组聚合仓储接口
     */
    private final GameEveMarketGroupRepository gameEveMarketGroupRepository;

    public GameEveMarketGroupCommandHandlerImpl(GameEveMarketGroupRepository gameEveMarketGroupRepository) {
        this.gameEveMarketGroupRepository = gameEveMarketGroupRepository;
    }
}
