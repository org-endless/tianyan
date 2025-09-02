package org.endless.tianyan.item.components.item.game.eve.group.facade.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.tianyan.item.common.model.facade.rest.TianyanItemRestController;
import org.endless.tianyan.item.components.item.game.eve.group.application.command.handler.GameEveItemGroupCommandHandler;
import org.endless.tianyan.item.components.item.game.eve.group.application.command.transfer.GameEveItemGroupCreateCReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.group.application.query.handler.GameEveItemGroupQueryHandler;
import org.endless.tianyan.item.components.item.game.eve.group.application.query.transfer.FindByGameEveItemGroupCodeQReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.group.application.query.transfer.FindItemGroupIdQRespTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GameEveItemGroupRestController
 * <p>游戏EVE资源项分组领域REST控制器
 * <p>
 * itemCreate 2025/07/21 16:03
 * <p>
 * update 2025/07/21 16:03
 *
 * @author Deng Haozhi
 * @see TianyanItemRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/item/game-eve-item-group")
public class GameEveItemGroupRestController implements TianyanItemRestController {

    /**
     * 游戏EVE资源项分组领域命令处理器
     */
    private final GameEveItemGroupCommandHandler gameEveItemGroupCommandHandler;

    /**
     * 游戏EVE资源项分组领域查询处理器
     */
    private final GameEveItemGroupQueryHandler gameEveItemGroupQueryHandler;

    public GameEveItemGroupRestController(GameEveItemGroupCommandHandler gameEveItemGroupCommandHandler, GameEveItemGroupQueryHandler gameEveItemGroupQueryHandler) {
        this.gameEveItemGroupCommandHandler = gameEveItemGroupCommandHandler;
        this.gameEveItemGroupQueryHandler = gameEveItemGroupQueryHandler;
    }

    @PostMapping("/command/create")
    @Log(message = "游戏EVE资源项分组创建", value = "#command")
    public ResponseEntity<RestResponse<Void>> create(
            @NotNull(message = "游戏EVE资源项分组创建命令请求传输对象不能为空")
            @Valid @RequestBody GameEveItemGroupCreateCReqTransfer command) {
        gameEveItemGroupCommandHandler.create(command);
        return response().success("游戏EVE资源项分组创建成功");
    }

    @PostMapping("/query/find-item-group-id-by-code")
    @Log(message = "根据游戏EVE资源项分组编码查询资源项分组ID", value = "#query")
    public ResponseEntity<RestResponse<FindItemGroupIdQRespTransfer>> findItemGroupIdByCode(
            @NotNull(message = "根据游戏EVE资源项分组编码查询请求传输对象不能为空")
            @Valid @RequestBody FindByGameEveItemGroupCodeQReqTransfer query) {
        return response(gameEveItemGroupQueryHandler.findItemGroupIdByCode(query)).
                success("根据游戏EVE资源项分组编码查询资源项分组ID成功");
    }

    @Override
    public String domainDescription() {
        return "游戏EVE资源项分组";
    }
}
