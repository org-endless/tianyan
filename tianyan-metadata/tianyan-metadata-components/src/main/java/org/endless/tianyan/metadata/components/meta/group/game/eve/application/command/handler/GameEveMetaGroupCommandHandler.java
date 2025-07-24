package org.endless.tianyan.metadata.components.meta.group.game.eve.application.command.handler;

import org.endless.tianyan.metadata.common.model.application.command.handler.TianyanMetadataCommandHandler;
import org.endless.tianyan.metadata.components.meta.group.game.eve.application.command.transfer.GameEveMetaGroupCreateReqCTransfer;
import org.endless.tianyan.metadata.components.meta.group.game.eve.domain.entity.GameEveMetaGroupAggregate;

/**
 * GameEveMetaGroupCommandHandler
 * <p>游戏EVE元分组领域命令处理器
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see TianyanMetadataCommandHandler<GameEveMetaGroupAggregate>
 * @since 0.0.1
 */
public interface GameEveMetaGroupCommandHandler extends TianyanMetadataCommandHandler<GameEveMetaGroupAggregate> {

    void create(GameEveMetaGroupCreateReqCTransfer command);

}
