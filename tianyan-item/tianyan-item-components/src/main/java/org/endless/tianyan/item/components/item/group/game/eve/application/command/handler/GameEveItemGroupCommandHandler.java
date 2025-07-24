package org.endless.tianyan.item.components.item.group.game.eve.application.command.handler;

import org.endless.tianyan.item.common.model.application.command.handler.TianyanItemCommandHandler;
import org.endless.tianyan.item.components.item.group.game.eve.application.command.transfer.GameEveItemGroupCreateReqCTransfer;
import org.endless.tianyan.item.components.item.group.game.eve.domain.entity.GameEveItemGroupAggregate;

/**
 * GameEveItemGroupCommandHandler
 * <p>游戏EVE资源项分组领域命令处理器
 * <p>
 * create 2025/07/21 16:03
 * <p>
 * update 2025/07/21 16:03
 *
 * @author Deng Haozhi
 * @see TianyanItemCommandHandler<GameEveItemGroupAggregate>
 * @since 0.0.1
 */
public interface GameEveItemGroupCommandHandler extends TianyanItemCommandHandler<GameEveItemGroupAggregate> {

    void create(GameEveItemGroupCreateReqCTransfer command);

}
