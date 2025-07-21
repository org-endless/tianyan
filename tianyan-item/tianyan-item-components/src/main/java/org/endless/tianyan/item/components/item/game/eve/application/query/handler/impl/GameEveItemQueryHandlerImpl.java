package org.endless.tianyan.item.components.item.game.eve.application.query.handler.impl;

import org.endless.tianyan.item.components.item.game.eve.application.query.handler.*;
import org.endless.tianyan.item.components.item.game.eve.application.query.anticorruption.*;
import org.endless.tianyan.item.components.item.game.eve.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.handler.*;

/**
 * GameEveItemQueryHandlerImpl
 * <p>游戏EVE物品领域查询处理器
 * <p>
 * create 2025/07/19 09:28
 * <p>
 * update 2025/07/19 09:28
 *
 * @author Deng Haozhi
 * @see GameEveItemQueryHandler
 * @since 0.0.1
 */
public class GameEveItemQueryHandlerImpl implements GameEveItemQueryHandler {

    /**
     * 游戏EVE物品聚合查询仓储接口
     */
    private final GameEveItemQueryRepository gameEveItemQueryRepository;

    public GameEveItemQueryHandlerImpl(GameEveItemQueryRepository gameEveItemQueryRepository) {
        this.gameEveItemQueryRepository = gameEveItemQueryRepository;
    }
}
