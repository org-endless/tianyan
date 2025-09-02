package org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.command.handler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.manufacturing.common.model.application.command.handler.TianyanManufacturingCommandHandler;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.command.transfer.GameEveBlueprintCreateCReqTransfer;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.domain.entity.GameEveBlueprintAggregate;

/**
 * GameEveBlueprintCommandHandler
 * <p>游戏EVE蓝图领域命令处理器
 * <p>
 * create 2025/07/24 09:18
 * <p>
 * update 2025/07/24 09:18
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingCommandHandler<GameEveBlueprintAggregate>
 * @since 0.0.1
 */
public interface GameEveBlueprintCommandHandler extends TianyanManufacturingCommandHandler<GameEveBlueprintAggregate> {

    /**
     * 游戏EVE蓝图创建命令
     *
     * @param command 游戏EVE蓝图创建命令请求传输对象
     */
    void create(
            @NotNull(message = "游戏EVE蓝图创建命令请求传输对象不能为空")
            @Valid GameEveBlueprintCreateCReqTransfer command);

}
