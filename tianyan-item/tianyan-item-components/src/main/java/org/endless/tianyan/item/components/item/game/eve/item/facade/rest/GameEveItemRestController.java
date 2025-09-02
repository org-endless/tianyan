package org.endless.tianyan.item.components.item.game.eve.item.facade.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.tianyan.item.common.model.facade.rest.TianyanItemRestController;
import org.endless.tianyan.item.components.item.game.eve.item.application.command.handler.GameEveItemCommandHandler;
import org.endless.tianyan.item.components.item.game.eve.item.application.command.transfer.GameEveItemCreateCReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.item.application.command.transfer.GameEveItemFetchCReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.item.application.command.transfer.GameEveItemFetchCRespTransfer;
import org.endless.tianyan.item.components.item.game.eve.item.application.query.handler.GameEveItemQueryHandler;
import org.endless.tianyan.item.components.item.game.eve.item.application.query.transfer.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GameEveItemRestController
 * <p>游戏EVE资源项领域REST控制器
 * <p>
 * itemCreate 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see TianyanItemRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/item/game-eve-item")
public class GameEveItemRestController implements TianyanItemRestController {

    /**
     * 游戏EVE资源项领域命令处理器
     */
    private final GameEveItemCommandHandler gameEveItemCommandHandler;

    /**
     * 游戏EVE资源项领域查询处理器
     */
    private final GameEveItemQueryHandler gameEveItemQueryHandler;

    public GameEveItemRestController(GameEveItemCommandHandler gameEveItemCommandHandler, GameEveItemQueryHandler gameEveItemQueryHandler) {
        this.gameEveItemCommandHandler = gameEveItemCommandHandler;
        this.gameEveItemQueryHandler = gameEveItemQueryHandler;
    }

    @PostMapping("/command/create")
    @Log(message = "游戏EVE资源项创建命令", value = "#command")
    public ResponseEntity<RestResponse<Void>> create(
            @NotNull(message = "游戏EVE资源项创建命令请求传输对象不能为空")
            @Valid @RequestBody GameEveItemCreateCReqTransfer command) {
        gameEveItemCommandHandler.create(command);
        return response().success("游戏EVE资源项创建成功");
    }

    @PostMapping("/command/fetch")
    @Log(message = "游戏EVE资源项获取命令", value = "#command")
    public ResponseEntity<RestResponse<GameEveItemFetchCRespTransfer>> fetch(
            @NotNull(message = "游戏EVE资源项获取命令请求传输对象不能为空")
            @Valid @RequestBody GameEveItemFetchCReqTransfer command) {
        return response(gameEveItemCommandHandler.fetch(command)).success("游戏EVE资源项获取成功");
    }

    @PostMapping("/query/find-item-id-by-code")
    @Log(message = "根据游戏EVE资源项编码查询资源项ID", value = "#query")
    public ResponseEntity<RestResponse<FindItemIdQRespTransfer>> findItemIdByCode(
            @NotNull(message = "根据游戏EVE资源项编码查询资源项ID请求体不能为空")
            @Valid @RequestBody FindByGameEveItemCodeQReqTransfer query) {
        return response(gameEveItemQueryHandler.findItemIdByCode(query))
                .success("根据游戏EVE资源项编码查询资源项ID成功");
    }

    @PostMapping("/query/find-item-ids-by-codes")
    @Log(message = "根据游戏EVE资源项编码列表查询资源项ID列表", value = "#query")
    public ResponseEntity<RestResponse<FindItemIdsQRespTransfer>> findItemIdsByCodes(
            @NotNull(message = "根据游戏EVE资源项编码列表查询资源项ID列表请求体不能为空")
            @Valid @RequestBody FindByGameEveItemCodesQReqTransfer query) {
        return response(gameEveItemQueryHandler.findItemIdsByCodes(query))
                .success("根据游戏EVE资源项编码列表查询资源项ID列表成功");
    }

    @PostMapping("/query/find-code-by-item-id")
    @Log(message = "根据资源项ID查询游戏EVE资源项编码", value = "#query")
    public ResponseEntity<RestResponse<FindGameEveItemCodeQRespTransfer>> findCodeByItemId(
            @NotNull(message = "根据资源项ID查询游戏EVE资源项编码请求体不能为空")
            @Valid @RequestBody FindByItemIdQReqTransfer query) {
        return response(gameEveItemQueryHandler.findCodeByItemId(query))
                .success("根据资源项ID查询游戏EVE资源项编码成功");
    }

    @Override
    public String domainDescription() {
        return "游戏EVE资源项领域";
    }
}
