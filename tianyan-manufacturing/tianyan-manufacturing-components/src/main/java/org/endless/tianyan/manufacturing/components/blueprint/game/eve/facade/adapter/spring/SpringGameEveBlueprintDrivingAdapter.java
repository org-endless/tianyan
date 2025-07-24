package org.endless.tianyan.manufacturing.components.blueprint.game.eve.facade.adapter.spring;

import org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.command.handler.GameEveBlueprintCommandHandler;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.command.transfer.GameEveBlueprintCreateReqCTransfer;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.query.handler.GameEveBlueprintQueryHandler;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.facade.adapter.GameEveBlueprintDrivingAdapter;

/**
 * SpringGameEveBlueprintDrivingAdapter
 * <p>游戏EVE蓝图领域主动适配器Spring实现类
 * <p>
 * create 2025/07/24 09:18
 * <p>
 * update 2025/07/24 09:18
 *
 * @author Deng Haozhi
 * @see GameEveBlueprintDrivingAdapter
 * @since 0.0.1
 */
public class SpringGameEveBlueprintDrivingAdapter implements GameEveBlueprintDrivingAdapter {

    /**
     * 游戏EVE蓝图领域命令处理器
     */
    private final GameEveBlueprintCommandHandler gameEveBlueprintCommandHandler;

    /**
     * 游戏EVE蓝图领域查询处理器
     */
    private final GameEveBlueprintQueryHandler gameEveBlueprintQueryHandler;

    public SpringGameEveBlueprintDrivingAdapter(GameEveBlueprintCommandHandler gameEveBlueprintCommandHandler, GameEveBlueprintQueryHandler gameEveBlueprintQueryHandler) {
        this.gameEveBlueprintCommandHandler = gameEveBlueprintCommandHandler;
        this.gameEveBlueprintQueryHandler = gameEveBlueprintQueryHandler;
    }

    @Override
    public void create(GameEveBlueprintCreateReqCTransfer command) {

        gameEveBlueprintCommandHandler.create(command);
    }
}
