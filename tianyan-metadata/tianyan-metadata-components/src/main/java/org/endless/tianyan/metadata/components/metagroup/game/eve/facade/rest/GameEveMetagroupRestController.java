package org.endless.tianyan.metadata.components.metagroup.game.eve.facade.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.tianyan.metadata.common.model.facade.rest.TianyanMetadataRestController;
import org.endless.tianyan.metadata.components.metagroup.game.eve.application.command.handler.GameEveMetagroupCommandHandler;
import org.endless.tianyan.metadata.components.metagroup.game.eve.application.command.transfer.GameEveMetagroupCreateCReqTransfer;
import org.endless.tianyan.metadata.components.metagroup.game.eve.application.query.handler.GameEveMetagroupQueryHandler;
import org.endless.tianyan.metadata.components.metagroup.game.eve.application.query.transfer.FindByGameEveMetagroupCodeQReqTransfer;
import org.endless.tianyan.metadata.components.metagroup.game.eve.application.query.transfer.FindMetagroupIdQRespTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GameEveMetagroupRestController
 * <p>游戏EVE元分组领域REST控制器
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see TianyanMetadataRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/metagroup/game-eve-metagroup")
public class GameEveMetagroupRestController implements TianyanMetadataRestController {

    /**
     * 游戏EVE元分组领域命令处理器
     */
    private final GameEveMetagroupCommandHandler gameEveMetagroupCommandHandler;

    /**
     * 游戏EVE元分组领域查询处理器
     */
    private final GameEveMetagroupQueryHandler gameEveMetagroupQueryHandler;

    public GameEveMetagroupRestController(GameEveMetagroupCommandHandler gameEveMetagroupCommandHandler, GameEveMetagroupQueryHandler gameEveMetagroupQueryHandler) {
        this.gameEveMetagroupCommandHandler = gameEveMetagroupCommandHandler;
        this.gameEveMetagroupQueryHandler = gameEveMetagroupQueryHandler;
    }

    @PostMapping("/command/create")
    @Log(message = "游戏EVE元分组创建命令", value = "#command")
    public ResponseEntity<RestResponse<Void>> create(
            @NotNull(message = "游戏EVE元分组创建命令请求传输对象不能为空")
            @Valid @RequestBody GameEveMetagroupCreateCReqTransfer command) {
        gameEveMetagroupCommandHandler.create(command);
        return response().success("元分组创建成功");
    }

    @PostMapping("/query/find-metagroup-id-by-code")
    @Log(message = "根据游戏EVE元分组编码查询元分组ID", value = "#command")
    public ResponseEntity<RestResponse<FindMetagroupIdQRespTransfer>> findMetagroupIdByCode(
            @NotNull(message = "根据游戏EVE元分组编码查询请求传输对象不能为空")
            @Valid @RequestBody FindByGameEveMetagroupCodeQReqTransfer query) {
        return response(gameEveMetagroupQueryHandler.findMetagroupIdByCode(query))
                .success("根据游戏EVE元分组编码查询元分组ID成功");
    }

    @Override
    public String domainDescription() {
        return "游戏EVE元分组领域";
    }
}
