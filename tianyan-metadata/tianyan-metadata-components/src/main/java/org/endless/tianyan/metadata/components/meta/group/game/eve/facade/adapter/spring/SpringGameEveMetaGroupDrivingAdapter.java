package org.endless.tianyan.metadata.components.meta.group.game.eve.facade.adapter.spring;

import org.endless.tianyan.metadata.components.meta.group.game.eve.application.command.handler.GameEveMetaGroupCommandHandler;
import org.endless.tianyan.metadata.components.meta.group.game.eve.application.command.transfer.GameEveMetaGroupCreateReqCTransfer;
import org.endless.tianyan.metadata.components.meta.group.game.eve.application.query.handler.GameEveMetaGroupQueryHandler;
import org.endless.tianyan.metadata.components.meta.group.game.eve.application.query.transfer.GameEveMetaGroupFindByCodeReqQTransfer;
import org.endless.tianyan.metadata.components.meta.group.game.eve.application.query.transfer.GameEveMetaGroupFindMetaGroupIdRespQTransfer;
import org.endless.tianyan.metadata.components.meta.group.game.eve.facade.adapter.GameEveMetaGroupDrivingAdapter;

/**
 * SpringGameEveMetaGroupDrivingAdapter
 * <p>游戏EVE元分组领域主动适配器Spring实现类
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see GameEveMetaGroupDrivingAdapter
 * @since 0.0.1
 */
public class SpringGameEveMetaGroupDrivingAdapter implements GameEveMetaGroupDrivingAdapter {

    /**
     * 游戏EVE元分组领域命令处理器
     */
    private final GameEveMetaGroupCommandHandler gameEveMetaGroupCommandHandler;

    /**
     * 游戏EVE元分组领域查询处理器
     */
    private final GameEveMetaGroupQueryHandler gameEveMetaGroupQueryHandler;

    public SpringGameEveMetaGroupDrivingAdapter(GameEveMetaGroupCommandHandler gameEveMetaGroupCommandHandler, GameEveMetaGroupQueryHandler gameEveMetaGroupQueryHandler) {
        this.gameEveMetaGroupCommandHandler = gameEveMetaGroupCommandHandler;
        this.gameEveMetaGroupQueryHandler = gameEveMetaGroupQueryHandler;
    }

    @Override
    public void create(GameEveMetaGroupCreateReqCTransfer command) {
        gameEveMetaGroupCommandHandler.create(command);
    }

    @Override
    public GameEveMetaGroupFindMetaGroupIdRespQTransfer findMetaGroupIdByCode(GameEveMetaGroupFindByCodeReqQTransfer query) {
        return gameEveMetaGroupQueryHandler.findMetaGroupIdByCode(query);
    }
}
