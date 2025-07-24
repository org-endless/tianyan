package org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.query.handler.impl;

import org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.query.handler.*;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.query.anticorruption.*;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.handler.*;

/**
 * GameEveBlueprintQueryHandlerImpl
 * <p>游戏EVE蓝图领域查询处理器
 * <p>
 * create 2025/07/24 09:18
 * <p>
 * update 2025/07/24 09:18
 *
 * @author Deng Haozhi
 * @see GameEveBlueprintQueryHandler
 * @since 0.0.1
 */
public class GameEveBlueprintQueryHandlerImpl implements GameEveBlueprintQueryHandler {

    /**
     * 游戏EVE蓝图聚合查询仓储接口
     */
    private final GameEveBlueprintQueryRepository gameEveBlueprintQueryRepository;

    public GameEveBlueprintQueryHandlerImpl(GameEveBlueprintQueryRepository gameEveBlueprintQueryRepository) {
        this.gameEveBlueprintQueryRepository = gameEveBlueprintQueryRepository;
    }
}
