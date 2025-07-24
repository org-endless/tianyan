package org.endless.tianyan.metadata.components.data.game.eve.application.command.handler.impl;

import org.endless.tianyan.metadata.components.data.game.eve.application.command.handler.*;
import org.endless.tianyan.metadata.components.data.game.eve.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.handler.*;

/**
 * GameEveDataCommandHandlerImpl
 * <p>游戏EVE数据领域命令处理器
 * <p>
 * create 2025/07/24 08:49
 * <p>
 * update 2025/07/24 08:49
 *
 * @author Deng Haozhi
 * @see GameEveDataCommandHandler
 * @since 0.0.1
 */
public class GameEveDataCommandHandlerImpl implements GameEveDataCommandHandler {

    /**
     * 游戏EVE数据聚合仓储接口
     */
    private final GameEveDataRepository gameEveDataRepository;

    public GameEveDataCommandHandlerImpl(GameEveDataRepository gameEveDataRepository) {
        this.gameEveDataRepository = gameEveDataRepository;
    }
}
