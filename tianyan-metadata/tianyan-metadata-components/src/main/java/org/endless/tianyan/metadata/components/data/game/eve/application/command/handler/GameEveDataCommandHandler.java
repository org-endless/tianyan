package org.endless.tianyan.metadata.components.data.game.eve.application.command.handler;

import org.endless.tianyan.metadata.common.model.application.command.handler.TianyanMetadataCommandHandler;
import org.endless.tianyan.metadata.common.model.domain.entity.TianyanMetadataAggregate;
import org.endless.tianyan.metadata.components.data.game.eve.application.command.transfer.GameEveDataLoadReqCTransfer;

/**
 * GameEveDataCommandHandler
 * <p>游戏EVE数据领域命令处理器
 * <p>
 * create 2025/07/20 21:24
 * <p>
 * update 2025/07/20 21:24
 *
 * @author Deng Haozhi
 * @see TianyanMetadataCommandHandler<GameEveDataAggregate>
 * @since 0.0.1
 */
public interface GameEveDataCommandHandler extends TianyanMetadataCommandHandler<TianyanMetadataAggregate> {

    void load(GameEveDataLoadReqCTransfer command);

}
