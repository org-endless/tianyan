package org.endless.tianyan.manufacturing.components.blueprint.game.eve.sidecar.rest;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.manufacturing.common.model.sidecar.rest.TianyanManufacturingRestController;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.command.transfer.GameEveBlueprintCreateReqCTransfer;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.facade.adapter.GameEveBlueprintDrivingAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * GameEveBlueprintRestController
 * <p>游戏EVE蓝图领域Rest控制器
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
@RequestMapping("/blueprint/game/eve")
public class GameEveBlueprintRestController implements TianyanManufacturingRestController {

    /**
     * 游戏EVE蓝图领域主动适配器
     */
    private final GameEveBlueprintDrivingAdapter gameEveBlueprintDrivingAdapter;

    public GameEveBlueprintRestController(GameEveBlueprintDrivingAdapter gameEveBlueprintDrivingAdapter) {
        this.gameEveBlueprintDrivingAdapter = gameEveBlueprintDrivingAdapter;
    }

    @PostMapping("/command/create")
    @Log(message = "游戏EVE蓝图创建", value = "#command")
    public ResponseEntity<RestResponse> create(@RequestBody GameEveBlueprintCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(GameEveBlueprintCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("游戏EVE蓝图创建参数不能为空"));
        gameEveBlueprintDrivingAdapter.create(command);
        return response().success("游戏EVE蓝图创建创建成功");
    }
}
