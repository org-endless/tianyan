package org.endless.tianyan.metadata.components.data.game.eve.application.command.handler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.metadata.common.model.application.command.handler.TianyanMetadataCommandHandler;
import org.endless.tianyan.metadata.common.model.domain.entity.TianyanMetadataAggregate;
import org.endless.tianyan.metadata.components.data.game.eve.application.command.transfer.GameEveDataLoadReqCReqTransfer;

/**
 * GameEveDataCommandHandler
 * <p>游戏EVE数据领域命令处理器
 * <p>
 * create 2025/07/24 08:49
 * <p>
 * update 2025/07/24 08:49
 *
 * @author Deng Haozhi
 * @see TianyanMetadataCommandHandler<GameEveDataAggregate>
 * @since 0.0.1
 */
public interface GameEveDataCommandHandler extends TianyanMetadataCommandHandler<TianyanMetadataAggregate> {

    /**
     * 游戏EVE数据加载命令
     *
     * @param command 游戏EVE数据加载命令请求传输对象
     */
    void load(
            @NotNull(message = "游戏EVE数据加载命令请求传输对象不能为空")
            @Valid GameEveDataLoadReqCReqTransfer command);
}
