package org.endless.tianyan.manufacturing.components.blueprint.game.eve.facade.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.tianyan.manufacturing.common.model.facade.rest.TianyanManufacturingRestController;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.command.handler.GameEveBlueprintCommandHandler;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.command.transfer.GameEveBlueprintCreateCReqTransfer;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.query.handler.GameEveBlueprintQueryHandler;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GameEveBlueprintRestController
 * <p>游戏EVE蓝图领域REST控制器
 * <p>
 * create 2025/07/24 09:18
 * <p>
 * update 2025/07/24 09:18
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/blueprint/game-eve-blueprint")
public class GameEveBlueprintRestController implements TianyanManufacturingRestController {

    /**
     * 游戏EVE蓝图领域命令处理器
     */
    private final GameEveBlueprintCommandHandler gameEveBlueprintCommandHandler;

    /**
     * 游戏EVE蓝图领域查询处理器
     */
    private final GameEveBlueprintQueryHandler gameEveBlueprintQueryHandler;

    public GameEveBlueprintRestController(GameEveBlueprintCommandHandler gameEveBlueprintCommandHandler, GameEveBlueprintQueryHandler gameEveBlueprintQueryHandler) {
        this.gameEveBlueprintCommandHandler = gameEveBlueprintCommandHandler;
        this.gameEveBlueprintQueryHandler = gameEveBlueprintQueryHandler;
    }


    @PostMapping("/command/create")
    @Log(message = "游戏EVE蓝图创建命令", value = "#command")
    public ResponseEntity<RestResponse<Void>> create(
            @NotNull(message = "游戏EVE蓝图创建命令请求传输对象不能为空")
            @Valid @RequestBody GameEveBlueprintCreateCReqTransfer command) {
        gameEveBlueprintCommandHandler.create(command);
        return response().success("游戏EVE蓝图创建创建成功");
    }

    @Override
    public String domainDescription() {
        return "游戏EVE蓝图领域";
    }
}
