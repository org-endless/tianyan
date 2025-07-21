package org.endless.tianyan.metadata.components.data.game.eve.facade.adapter.spring;

import org.endless.tianyan.metadata.components.data.game.eve.application.command.handler.GameEveDataCommandHandler;
import org.endless.tianyan.metadata.components.data.game.eve.application.command.transfer.GameEveDataLoadReqCTransfer;
import org.endless.tianyan.metadata.components.data.game.eve.application.query.handler.GameEveDataQueryHandler;
import org.endless.tianyan.metadata.components.data.game.eve.facade.adapter.GameEveDataDrivingAdapter;

/**
 * SpringGameEveDataDrivingAdapter
 * <p>游戏EVE数据领域主动适配器Spring实现类
 * <p>
 * create 2025/07/20 21:24
 * <p>
 * update 2025/07/20 21:24
 *
 * @author Deng Haozhi
 * @see GameEveDataDrivingAdapter
 * @since 0.0.1
 */
public class SpringGameEveDataDrivingAdapter implements GameEveDataDrivingAdapter {

    /**
     * 游戏EVE数据领域命令处理器
     */
    private final GameEveDataCommandHandler gameEveDataCommandHandler;

    /**
     * 游戏EVE数据领域查询处理器
     */
    private final GameEveDataQueryHandler gameEveDataQueryHandler;

    public SpringGameEveDataDrivingAdapter(GameEveDataCommandHandler gameEveDataCommandHandler, GameEveDataQueryHandler gameEveDataQueryHandler) {
        this.gameEveDataCommandHandler = gameEveDataCommandHandler;
        this.gameEveDataQueryHandler = gameEveDataQueryHandler;
    }

    @Override
    public void load(GameEveDataLoadReqCTransfer command) {
        gameEveDataCommandHandler.load(command);
    }
}
