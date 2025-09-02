package org.endless.tianyan.metadata.components.data.game.eve.facade.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.tianyan.metadata.common.model.facade.rest.TianyanMetadataRestController;
import org.endless.tianyan.metadata.components.data.game.eve.application.command.handler.GameEveDataCommandHandler;
import org.endless.tianyan.metadata.components.data.game.eve.application.command.transfer.GameEveDataLoadReqCReqTransfer;
import org.endless.tianyan.metadata.components.data.game.eve.application.query.handler.GameEveDataQueryHandler;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GameEveDataRestController
 * <p>游戏EVE数据领域REST控制器
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
     * 游戏EVE数据领域命令处理器
     */
    private final GameEveDataCommandHandler gameEveDataCommandHandler;

    /**
     * 游戏EVE数据领域查询处理器
     */
    private final GameEveDataQueryHandler gameEveDataQueryHandler;

    public GameEveDataRestController(GameEveDataCommandHandler gameEveDataCommandHandler, GameEveDataQueryHandler gameEveDataQueryHandler) {
        this.gameEveDataCommandHandler = gameEveDataCommandHandler;
        this.gameEveDataQueryHandler = gameEveDataQueryHandler;
    }


    @PostMapping("/command/load")
    @Log(message = "游戏EVE数据加载", value = "#command")
    public ResponseEntity<RestResponse<Void>> load(
            @NotNull(message = "游戏EVE数据加载请求体不能为空")
            @Valid @RequestBody GameEveDataLoadReqCReqTransfer command) {
        gameEveDataCommandHandler.load(command);
        return response().success("游戏EVE数据加载成功");
    }

    @Override
    public String domainDescription() {
        return "游戏EVE数据领域";
    }
}
