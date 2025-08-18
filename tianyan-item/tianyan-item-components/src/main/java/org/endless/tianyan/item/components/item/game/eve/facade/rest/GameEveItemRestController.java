package org.endless.tianyan.item.components.item.game.eve.facade.rest;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferNullException;
import org.endless.ddd.starter.common.exception.ddd.application.query.transfer.QueryReqTransferNullException;
import org.endless.tianyan.item.common.model.facade.rest.TianyanItemRestController;
import org.endless.tianyan.item.components.item.game.eve.application.command.handler.GameEveItemCommandHandler;
import org.endless.tianyan.item.components.item.game.eve.application.command.transfer.GameEveItemCreateReqCReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.application.command.transfer.GameEveItemFetchReqCReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.application.query.handler.GameEveItemQueryHandler;
import org.endless.tianyan.item.components.item.game.eve.application.query.transfer.GameEveItemFindByCodeReqQReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.application.query.transfer.GameEveItemFindByCodesReqQReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.application.query.transfer.GameEveItemFindByItemIdReqQReqTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * GameEveItemRestController
 * <p>游戏EVE资源项领域Rest控制器
 * <p>
 * create 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see TianyanItemRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/item/game/eve")
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
    @Log(message = "游戏EVE资源项创建", value = "#command")
    public ResponseEntity<RestResponse> create(@RequestBody GameEveItemCreateReqCReqTransfer command) {
        Optional.ofNullable(command)
                .map(GameEveItemCreateReqCReqTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("游戏EVE资源项创建参数不能为空"));
        gameEveItemCommandHandler.create(command);
        return response().success("游戏EVE资源项创建成功");
    }

    @PostMapping("/command/fetch")
    @Log(message = "游戏EVE资源项获取", value = "#command")
    public ResponseEntity<RestResponse> fetch(@RequestBody GameEveItemFetchReqCReqTransfer command) {
        Optional.ofNullable(command)
                .map(GameEveItemFetchReqCReqTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("游戏EVE资源项获取参数不能为空"));
        return response().success("游戏EVE资源项获取成功", gameEveItemCommandHandler.fetch(command));
    }

    @PostMapping("/query/find_item_id_by_code")
    @Log(message = "游戏EVE根据资源项编码查询资源项ID", value = "#query")
    public ResponseEntity<RestResponse> findItemIdByCode(@RequestBody GameEveItemFindByCodeReqQReqTransfer query) {
        Optional.ofNullable(query)
                .map(GameEveItemFindByCodeReqQReqTransfer::validate)
                .orElseThrow(() -> new QueryReqTransferNullException("游戏EVE根据资源项编码查询资源项ID参数不能为空"));
        return response().success("游戏EVE根据资源项编码查询资源项ID成功", gameEveItemQueryHandler.findItemIdByCode(query));
    }

    @PostMapping("/query/find_item_ids_by_codes")
    @Log(message = "游戏EVE根据资源项编码列表查询资源项ID列表", value = "#query")
    public ResponseEntity<RestResponse> findItemIdsByCodes(@RequestBody GameEveItemFindByCodesReqQReqTransfer query) {
        Optional.ofNullable(query)
                .map(GameEveItemFindByCodesReqQReqTransfer::validate)
                .orElseThrow(() -> new QueryReqTransferNullException("游戏EVE根据资源项编码列表查询资源项ID列表参数不能为空"));
        return response().success("游戏EVE根据资源项编码列表查询资源项ID列表成功", gameEveItemQueryHandler.findItemIdsByCodes(query));
    }

    @PostMapping("/query/find_code_by_item_id")
    @Log(message = "游戏EVE根据资源项资源项ID查询编码", value = "#query")
    public ResponseEntity<RestResponse> findCodeByItemId(@RequestBody GameEveItemFindByItemIdReqQReqTransfer query) {
        Optional.ofNullable(query)
                .map(GameEveItemFindByItemIdReqQReqTransfer::validate)
                .orElseThrow(() -> new QueryReqTransferNullException("游戏EVE根据资源项资源项ID查询编码参数不能为空"));
        return response().success("游戏EVE根据资源项资源项ID查询编码成功", gameEveItemQueryHandler.findCodeByItemId(query));
    }
}
