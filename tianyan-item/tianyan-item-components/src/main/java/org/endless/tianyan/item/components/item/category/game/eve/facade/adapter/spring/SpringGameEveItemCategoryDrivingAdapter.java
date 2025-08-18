package org.endless.tianyan.item.components.item.category.game.eve.facade.adapter.spring;

import org.endless.tianyan.item.components.item.category.game.eve.application.command.handler.GameEveItemCategoryCommandHandler;
import org.endless.tianyan.item.components.item.category.game.eve.application.command.transfer.GameEveItemCategoryCreateReqCReqTransfer;
import org.endless.tianyan.item.components.item.category.game.eve.application.query.handler.GameEveItemCategoryQueryHandler;
import org.endless.tianyan.item.components.item.category.game.eve.application.query.transfer.GameEveItemCategoryFindByCodeReqQReqTransfer;
import org.endless.tianyan.item.components.item.category.game.eve.application.query.transfer.GameEveItemCategoryFindIdRespQReqTransfer;
import org.endless.tianyan.item.components.item.category.game.eve.facade.adapter.GameEveItemCategoryDrivingAdapter;

/**
 * SpringGameEveItemCategoryDrivingAdapter
 * <p>游戏EVE资源项分类领域主动适配器Spring实现类
 * <p>
 * create 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see GameEveItemCategoryDrivingAdapter
 * @since 0.0.1
 */
public class SpringGameEveItemCategoryDrivingAdapter implements GameEveItemCategoryDrivingAdapter {

    /**
     * 游戏EVE资源项分类领域命令处理器
     */
    private final GameEveItemCategoryCommandHandler gameEveItemCategoryCommandHandler;

    /**
     * 游戏EVE资源项分类领域查询处理器
     */
    private final GameEveItemCategoryQueryHandler gameEveItemCategoryQueryHandler;

    public SpringGameEveItemCategoryDrivingAdapter(GameEveItemCategoryCommandHandler gameEveItemCategoryCommandHandler, GameEveItemCategoryQueryHandler gameEveItemCategoryQueryHandler) {
        this.gameEveItemCategoryCommandHandler = gameEveItemCategoryCommandHandler;
        this.gameEveItemCategoryQueryHandler = gameEveItemCategoryQueryHandler;
    }

    @Override
    public void create(GameEveItemCategoryCreateReqCReqTransfer command) {
        gameEveItemCategoryCommandHandler.create(command);
    }

    @Override
    public GameEveItemCategoryFindIdRespQReqTransfer findItemCategoryIdByCode(GameEveItemCategoryFindByCodeReqQReqTransfer query) {
        return gameEveItemCategoryQueryHandler.findItemCategoryIdByCode(query);
    }
}
