package org.endless.tianyan.item.components.item.game.eve.facade.adapter.spring;

import org.endless.tianyan.item.components.item.game.eve.application.command.handler.GameEveItemCommandHandler;
import org.endless.tianyan.item.components.item.game.eve.application.command.transfer.GameEveItemCreateReqCTransfer;
import org.endless.tianyan.item.components.item.game.eve.application.command.transfer.GameEveItemFetchReqCTransfer;
import org.endless.tianyan.item.components.item.game.eve.application.command.transfer.GameEveItemFetchRespCTransfer;
import org.endless.tianyan.item.components.item.game.eve.application.query.handler.GameEveItemQueryHandler;
import org.endless.tianyan.item.components.item.game.eve.application.query.transfer.*;
import org.endless.tianyan.item.components.item.game.eve.facade.adapter.GameEveItemDrivingAdapter;

/**
 * SpringGameEveItemDrivingAdapter
 * <p>游戏EVE资源项领域主动适配器Spring实现类
 * <p>
 * create 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see GameEveItemDrivingAdapter
 * @since 0.0.1
 */
public class SpringGameEveItemDrivingAdapter implements GameEveItemDrivingAdapter {

    /**
     * 游戏EVE资源项领域命令处理器
     */
    private final GameEveItemCommandHandler gameEveItemCommandHandler;

    /**
     * 游戏EVE资源项领域查询处理器
     */
    private final GameEveItemQueryHandler gameEveItemQueryHandler;

    public SpringGameEveItemDrivingAdapter(GameEveItemCommandHandler gameEveItemCommandHandler, GameEveItemQueryHandler gameEveItemQueryHandler) {
        this.gameEveItemCommandHandler = gameEveItemCommandHandler;
        this.gameEveItemQueryHandler = gameEveItemQueryHandler;
    }

    @Override
    public void create(GameEveItemCreateReqCTransfer command) {
        gameEveItemCommandHandler.create(command);
    }

    @Override
    public GameEveItemFetchRespCTransfer fetch(GameEveItemFetchReqCTransfer command) {
        return gameEveItemCommandHandler.fetch(command);
    }

    @Override
    public GameEveItemFindItemIdRespQTransfer findItemIdByCode(GameEveItemFindByCodeReqQTransfer query) {
        return gameEveItemQueryHandler.findItemIdByCode(query);
    }

    @Override
    public GameEveItemFindItemIdsRespQTransfer findItemIdsByCodes(GameEveItemFindByCodesReqQTransfer query) {
        return gameEveItemQueryHandler.findItemIdsByCodes(query);
    }

    @Override
    public GameEveItemFindCodeRespQTransfer findCodeByItemId(GameEveItemFindByItemIdReqQTransfer query) {
        return gameEveItemQueryHandler.findCodeByItemId(query);
    }
}
