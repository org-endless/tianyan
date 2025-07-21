package org.endless.tianyan.item.components.item.category.game.eve.application.query.handler.impl;

import org.endless.tianyan.item.components.item.category.game.eve.application.query.handler.*;
import org.endless.tianyan.item.components.item.category.game.eve.application.query.anticorruption.*;
import org.endless.tianyan.item.components.item.category.game.eve.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.handler.*;

/**
 * GameEveItemCategoryQueryHandlerImpl
 * <p>游戏EVE物品分类领域查询处理器
 * <p>
 * create 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see GameEveItemCategoryQueryHandler
 * @since 0.0.1
 */
public class GameEveItemCategoryQueryHandlerImpl implements GameEveItemCategoryQueryHandler {

    /**
     * 游戏EVE物品分类聚合查询仓储接口
     */
    private final GameEveItemCategoryQueryRepository gameEveItemCategoryQueryRepository;

    public GameEveItemCategoryQueryHandlerImpl(GameEveItemCategoryQueryRepository gameEveItemCategoryQueryRepository) {
        this.gameEveItemCategoryQueryRepository = gameEveItemCategoryQueryRepository;
    }
}
