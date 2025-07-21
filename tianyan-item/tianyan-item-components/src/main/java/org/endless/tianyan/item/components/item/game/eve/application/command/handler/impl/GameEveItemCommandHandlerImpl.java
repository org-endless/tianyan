package org.endless.tianyan.item.components.item.game.eve.application.command.handler.impl;

import org.endless.tianyan.item.components.item.game.eve.application.command.handler.*;
import org.endless.tianyan.item.components.item.game.eve.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.handler.*;

/**
 * GameEveItemCommandHandlerImpl
 * <p>游戏EVE物品领域命令处理器
 * <p>
 * create 2025/07/19 09:28
 * <p>
 * update 2025/07/19 09:28
 *
 * @author Deng Haozhi
 * @see GameEveItemCommandHandler
 * @since 0.0.1
 */
public class GameEveItemCommandHandlerImpl implements GameEveItemCommandHandler {

    /**
     * 游戏EVE物品聚合仓储接口
     */
    private final GameEveItemRepository gameEveItemRepository;

    public GameEveItemCommandHandlerImpl(GameEveItemRepository gameEveItemRepository) {
        this.gameEveItemRepository = gameEveItemRepository;
    }
}
