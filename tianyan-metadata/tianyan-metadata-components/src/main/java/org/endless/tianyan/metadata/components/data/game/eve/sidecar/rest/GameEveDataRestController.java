package org.endless.tianyan.metadata.components.data.game.eve.sidecar.rest;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.metadata.common.model.sidecar.rest.TianyanMetadataRestController;
import org.endless.tianyan.metadata.components.data.game.eve.application.command.transfer.GameEveDataLoadReqCTransfer;
import org.endless.tianyan.metadata.components.data.game.eve.facade.adapter.GameEveDataDrivingAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * GameEveDataRestController
 * <p>游戏EVE数据领域Rest控制器
 * <p>
 * create 2025/07/24 08:49
 * <p>
 * update 2025/07/24 08:49
 *
 * @author Deng Haozhi
 * @see TianyanMetadataRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/data/game/eve")
public class GameEveDataRestController implements TianyanMetadataRestController {

    /**
     * 游戏EVE数据领域主动适配器
     */
    private final GameEveDataDrivingAdapter gameEveDataDrivingAdapter;

    public GameEveDataRestController(GameEveDataDrivingAdapter gameEveDataDrivingAdapter) {
        this.gameEveDataDrivingAdapter = gameEveDataDrivingAdapter;
    }

    @PostMapping("/command/load")
    @Log(message = "游戏EVE数据加载", value = "#command")
    public ResponseEntity<RestResponse> load(@RequestBody GameEveDataLoadReqCTransfer command) {
        Optional.ofNullable(command)
                .map(GameEveDataLoadReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("游戏EVE数据加载参数不能为空"));
        gameEveDataDrivingAdapter.load(command);
        return response().success("游戏EVE数据加载成功");
    }
}
