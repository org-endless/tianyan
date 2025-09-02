package org.endless.tianyan.metadata.components.metagroup.game.eve.application.command.handler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.metadata.common.model.application.command.handler.TianyanMetadataCommandHandler;
import org.endless.tianyan.metadata.components.metagroup.game.eve.application.command.transfer.GameEveMetagroupCreateCReqTransfer;
import org.endless.tianyan.metadata.components.metagroup.game.eve.domain.entity.GameEveMetagroupAggregate;

/**
 * GameEveMetagroupCommandHandler
 * <p>游戏EVE元分组领域命令处理器
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see TianyanMetadataCommandHandler<GameEveMetagroupAggregate>
 * @since 0.0.1
 */
public interface GameEveMetagroupCommandHandler extends TianyanMetadataCommandHandler<GameEveMetagroupAggregate> {

    /**
     * 游戏EVE元分组创建命令
     *
     * @param command 游戏EVE元分组创建命令请求传输对象
     */
    void create(
            @NotNull(message = "游戏EVE元分组创建命令请求传输对象不能为空")
            @Valid GameEveMetagroupCreateCReqTransfer command);

}
