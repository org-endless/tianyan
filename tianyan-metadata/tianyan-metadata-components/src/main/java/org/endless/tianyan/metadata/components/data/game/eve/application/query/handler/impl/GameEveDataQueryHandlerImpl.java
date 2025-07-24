package org.endless.tianyan.metadata.components.data.game.eve.application.query.handler.impl;

import org.endless.tianyan.metadata.components.data.game.eve.application.query.handler.*;
import org.endless.tianyan.metadata.components.data.game.eve.application.query.anticorruption.*;
import org.endless.tianyan.metadata.components.data.game.eve.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.handler.*;

/**
 * GameEveDataQueryHandlerImpl
 * <p>游戏EVE数据领域查询处理器
 * <p>
 * create 2025/07/24 08:49
 * <p>
 * update 2025/07/24 08:49
 *
 * @author Deng Haozhi
 * @see GameEveDataQueryHandler
 * @since 0.0.1
 */
public class GameEveDataQueryHandlerImpl implements GameEveDataQueryHandler {

    /**
     * 游戏EVE数据聚合查询仓储接口
     */
    private final GameEveDataQueryRepository gameEveDataQueryRepository;

    public GameEveDataQueryHandlerImpl(GameEveDataQueryRepository gameEveDataQueryRepository) {
        this.gameEveDataQueryRepository = gameEveDataQueryRepository;
    }
}
