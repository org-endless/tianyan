package org.endless.tianyan.item.components.item.group.game.eve.application.query.handler.impl;

import org.endless.tianyan.item.components.item.group.game.eve.application.query.handler.*;
import org.endless.tianyan.item.components.item.group.game.eve.application.query.anticorruption.*;
import org.endless.tianyan.item.components.item.group.game.eve.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.handler.*;

/**
 * GameEveItemGroupQueryHandlerImpl
 * <p>游戏EVE物品分组领域查询处理器
 * <p>
 * create 2025/07/21 16:03
 * <p>
 * update 2025/07/21 16:03
 *
 * @author Deng Haozhi
 * @see GameEveItemGroupQueryHandler
 * @since 0.0.1
 */
public class GameEveItemGroupQueryHandlerImpl implements GameEveItemGroupQueryHandler {

    /**
     * 游戏EVE物品分组聚合查询仓储接口
     */
    private final GameEveItemGroupQueryRepository gameEveItemGroupQueryRepository;

    public GameEveItemGroupQueryHandlerImpl(GameEveItemGroupQueryRepository gameEveItemGroupQueryRepository) {
        this.gameEveItemGroupQueryRepository = gameEveItemGroupQueryRepository;
    }
}
