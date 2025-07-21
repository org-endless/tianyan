package org.endless.tianyan.item.components.item.game.eve.facade.adapter.spring;

import org.endless.tianyan.item.components.item.game.eve.facade.adapter.*;
import org.endless.tianyan.item.components.item.game.eve.application.command.handler.*;
import org.endless.tianyan.item.components.item.game.eve.application.query.handler.*;
import org.endless.ddd.simplified.starter.common.exception.model.facade.adapter.*;

/**
 * SpringGameEveItemDrivingAdapter
 * <p>游戏EVE物品领域主动适配器Spring实现类
 * <p>
 * create 2025/07/19 09:28
 * <p>
 * update 2025/07/19 09:28
 *
 * @author Deng Haozhi
 * @see GameEveItemDrivingAdapter
 * @since 0.0.1
 */
public class SpringGameEveItemDrivingAdapter implements GameEveItemDrivingAdapter {

    /**
     * 游戏EVE物品领域命令处理器
     */
    private final GameEveItemCommandHandler gameEveItemCommandHandler;

    /**
     * 游戏EVE物品领域查询处理器
     */
    private final GameEveItemQueryHandler gameEveItemQueryHandler;

    public SpringGameEveItemDrivingAdapter(GameEveItemCommandHandler gameEveItemCommandHandler, GameEveItemQueryHandler gameEveItemQueryHandler) {
        this.gameEveItemCommandHandler = gameEveItemCommandHandler;
        this.gameEveItemQueryHandler = gameEveItemQueryHandler;
    }
}
