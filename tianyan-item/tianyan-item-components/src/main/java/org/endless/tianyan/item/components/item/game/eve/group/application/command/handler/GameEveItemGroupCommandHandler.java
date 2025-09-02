package org.endless.tianyan.item.components.item.game.eve.group.application.command.handler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.item.common.model.application.command.handler.TianyanItemCommandHandler;
import org.endless.tianyan.item.components.item.game.eve.group.application.command.transfer.GameEveItemGroupCreateCReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.group.domain.entity.GameEveItemGroupAggregate;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * GameEveItemGroupCommandHandler
 * <p>游戏EVE资源项分组领域命令处理器
 * <p>
 * itemCreate 2025/07/21 16:03
 * <p>
 * update 2025/07/21 16:03
 *
 * @author Deng Haozhi
 * @see TianyanItemCommandHandler<GameEveItemGroupAggregate>
 * @since 0.0.1
 */
public interface GameEveItemGroupCommandHandler extends TianyanItemCommandHandler<GameEveItemGroupAggregate> {

    /**
     * 游戏EVE资源项分组建命令
     *
     * @param command 游戏EVE资源项分组创建命令请求传输对象
     */
    void create(
            @NotNull(message = "游戏EVE资源项分组创建命令请求传输对象不能为空")
            @Valid @RequestParam("command") GameEveItemGroupCreateCReqTransfer command);

}
