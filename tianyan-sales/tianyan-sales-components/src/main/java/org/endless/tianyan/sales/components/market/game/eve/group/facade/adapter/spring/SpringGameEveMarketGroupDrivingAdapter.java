package org.endless.tianyan.sales.components.market.game.eve.group.facade.adapter.spring;

import org.endless.tianyan.sales.components.market.game.eve.group.application.command.handler.GameEveMarketGroupCommandHandler;
import org.endless.tianyan.sales.components.market.game.eve.group.application.command.transfer.GameEveMarketGroupCreateReqCTransfer;
import org.endless.tianyan.sales.components.market.game.eve.group.application.query.handler.GameEveMarketGroupQueryHandler;
import org.endless.tianyan.sales.components.market.game.eve.group.application.query.transfer.GameEveMarketGroupFindByCodeReqQTransfer;
import org.endless.tianyan.sales.components.market.game.eve.group.application.query.transfer.GameEveMarketGroupFindIdRespQTransfer;
import org.endless.tianyan.sales.components.market.game.eve.group.facade.adapter.GameEveMarketGroupDrivingAdapter;

/**
 * SpringGameEveMarketGroupDrivingAdapter
 * <p>游戏EVE市场分组领域主动适配器Spring实现类
 * <p>
 * create 2025/07/22 09:09
 * <p>
 * update 2025/07/22 09:09
 *
 * @author Deng Haozhi
 * @see GameEveMarketGroupDrivingAdapter
 * @since 0.0.1
 */
public class SpringGameEveMarketGroupDrivingAdapter implements GameEveMarketGroupDrivingAdapter {

    /**
     * 游戏EVE市场分组领域命令处理器
     */
    private final GameEveMarketGroupCommandHandler gameEveMarketGroupCommandHandler;

    /**
     * 游戏EVE市场分组领域查询处理器
     */
    private final GameEveMarketGroupQueryHandler gameEveMarketGroupQueryHandler;

    public SpringGameEveMarketGroupDrivingAdapter(GameEveMarketGroupCommandHandler gameEveMarketGroupCommandHandler, GameEveMarketGroupQueryHandler gameEveMarketGroupQueryHandler) {
        this.gameEveMarketGroupCommandHandler = gameEveMarketGroupCommandHandler;
        this.gameEveMarketGroupQueryHandler = gameEveMarketGroupQueryHandler;
    }

    @Override
    public void create(GameEveMarketGroupCreateReqCTransfer command) {
        gameEveMarketGroupCommandHandler.create(command);
    }

    @Override
    public GameEveMarketGroupFindIdRespQTransfer findMarketGroupIdByCode(GameEveMarketGroupFindByCodeReqQTransfer query) {
        return gameEveMarketGroupQueryHandler.findMarketGroupIdByCode(query);
    }
}
