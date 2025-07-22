package org.endless.tianyan.item.components.item.group.game.eve.facade.adapter.spring;

import org.endless.tianyan.item.components.item.group.game.eve.application.command.handler.GameEveItemGroupCommandHandler;
import org.endless.tianyan.item.components.item.group.game.eve.application.command.transfer.GameEveItemGroupCreateReqCTransfer;
import org.endless.tianyan.item.components.item.group.game.eve.application.query.handler.GameEveItemGroupQueryHandler;
import org.endless.tianyan.item.components.item.group.game.eve.facade.adapter.GameEveItemGroupDrivingAdapter;

/**
 * SpringGameEveItemGroupDrivingAdapter
 * <p>游戏EVE物品分组领域主动适配器Spring实现类
 * <p>
 * create 2025/07/21 16:03
 * <p>
 * update 2025/07/21 16:03
 *
 * @author Deng Haozhi
 * @see GameEveItemGroupDrivingAdapter
 * @since 0.0.1
 */
public class SpringGameEveItemGroupDrivingAdapter implements GameEveItemGroupDrivingAdapter {

    /**
     * 游戏EVE物品分组领域命令处理器
     */
    private final GameEveItemGroupCommandHandler gameEveItemGroupCommandHandler;

    /**
     * 游戏EVE物品分组领域查询处理器
     */
    private final GameEveItemGroupQueryHandler gameEveItemGroupQueryHandler;

    public SpringGameEveItemGroupDrivingAdapter(GameEveItemGroupCommandHandler gameEveItemGroupCommandHandler, GameEveItemGroupQueryHandler gameEveItemGroupQueryHandler) {
        this.gameEveItemGroupCommandHandler = gameEveItemGroupCommandHandler;
        this.gameEveItemGroupQueryHandler = gameEveItemGroupQueryHandler;
    }

    @Override
    public void create(GameEveItemGroupCreateReqCTransfer command) {
        gameEveItemGroupCommandHandler.create(command);
    }
}
