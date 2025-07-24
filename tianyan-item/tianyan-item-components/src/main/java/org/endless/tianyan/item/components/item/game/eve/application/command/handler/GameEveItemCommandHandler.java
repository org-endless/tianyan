package org.endless.tianyan.item.components.item.game.eve.application.command.handler;

import org.endless.tianyan.item.common.model.application.command.handler.TianyanItemCommandHandler;
import org.endless.tianyan.item.components.item.game.eve.application.command.transfer.GameEveItemCreateReqCTransfer;
import org.endless.tianyan.item.components.item.game.eve.domain.entity.GameEveItemAggregate;

/**
 * GameEveItemCommandHandler
 * <p>游戏EVE资源项领域命令处理器
 * <p>
 * create 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see TianyanItemCommandHandler<GameEveItemAggregate>
 * @since 0.0.1
 */
public interface GameEveItemCommandHandler extends TianyanItemCommandHandler<GameEveItemAggregate> {

    void create(GameEveItemCreateReqCTransfer command);

}
