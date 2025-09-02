package org.endless.tianyan.item.components.item.game.eve.item.application.command.handler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.item.common.model.application.command.handler.TianyanItemCommandHandler;
import org.endless.tianyan.item.components.item.game.eve.item.application.command.transfer.GameEveItemCreateCReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.item.application.command.transfer.GameEveItemFetchCReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.item.application.command.transfer.GameEveItemFetchCRespTransfer;
import org.endless.tianyan.item.components.item.game.eve.item.domain.entity.GameEveItemAggregate;

/**
 * GameEveItemCommandHandler
 * <p>游戏EVE资源项领域命令处理器
 * <p>
 * itemCreate 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see TianyanItemCommandHandler<GameEveItemAggregate>
 * @since 0.0.1
 */
public interface GameEveItemCommandHandler extends TianyanItemCommandHandler<GameEveItemAggregate> {

    /**
     * 游戏EVE资源项创建命令
     *
     * @param command 游戏EVE资源项创建命令请求传输对象
     */
    void create(
            @NotNull(message = "游戏EVE资源项创建命令请求传输对象不能为空")
            @Valid GameEveItemCreateCReqTransfer command
    );

    /**
     * 游戏EVE资源项创建命令
     *
     * @param command 游戏EVE资源项获取命令请求传输对象
     */
    @Valid
    @NotNull(message = "游戏EVE资源项获取命令响应传输对象不能为空")
    GameEveItemFetchCRespTransfer fetch(
            @NotNull(message = "游戏EVE资源项获取命令请求传输对象不能为空")
            @Valid GameEveItemFetchCReqTransfer command
    );

}
