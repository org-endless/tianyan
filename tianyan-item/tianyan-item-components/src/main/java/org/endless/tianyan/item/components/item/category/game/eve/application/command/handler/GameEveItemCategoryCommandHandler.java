package org.endless.tianyan.item.components.item.category.game.eve.application.command.handler;

import org.endless.tianyan.item.common.model.application.command.handler.TianyanItemCommandHandler;
import org.endless.tianyan.item.components.item.category.game.eve.application.command.transfer.GameEveItemCategoryCreateReqCTransfer;
import org.endless.tianyan.item.components.item.category.game.eve.domain.entity.GameEveItemCategoryAggregate;

/**
 * GameEveItemCategoryCommandHandler
 * <p>游戏EVE资源项分类领域命令处理器
 * <p>
 * create 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see TianyanItemCommandHandler<GameEveItemCategoryAggregate>
 * @since 0.0.1
 */
public interface GameEveItemCategoryCommandHandler extends TianyanItemCommandHandler<GameEveItemCategoryAggregate> {

    void create(GameEveItemCategoryCreateReqCTransfer command);

}
