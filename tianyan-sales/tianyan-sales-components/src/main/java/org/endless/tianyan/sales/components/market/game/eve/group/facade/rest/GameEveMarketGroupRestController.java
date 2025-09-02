package org.endless.tianyan.sales.components.market.game.eve.group.facade.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.tianyan.sales.common.model.facade.rest.TianyanSalesRestController;
import org.endless.tianyan.sales.components.market.game.eve.group.application.command.handler.GameEveMarketGroupCommandHandler;
import org.endless.tianyan.sales.components.market.game.eve.group.application.command.transfer.GameEveMarketGroupCreateCReqTransfer;
import org.endless.tianyan.sales.components.market.game.eve.group.application.query.handler.GameEveMarketGroupQueryHandler;
import org.endless.tianyan.sales.components.market.game.eve.group.application.query.transfer.FindByGameEveMarketGroupCodeQReqTransfer;
import org.endless.tianyan.sales.components.market.game.eve.group.application.query.transfer.FindMarketGroupIdQRespTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GameEveMarketGroupRestController
 * <p>游戏EVE市场分组领域REST控制器
 * <p>
 * create 2025/07/24 17:37
 * <p>
 * update 2025/07/24 17:37
 *
 * @author Deng Haozhi
 * @see TianyanSalesRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/market/game-eve-market-group")
public class GameEveMarketGroupRestController implements TianyanSalesRestController {

    /**
     * 游戏EVE市场分组领域命令处理器
     */
    private final GameEveMarketGroupCommandHandler gameEveMarketGroupCommandHandler;

    /**
     * 游戏EVE市场分组领域查询处理器
     */
    private final GameEveMarketGroupQueryHandler gameEveMarketGroupQueryHandler;

    public GameEveMarketGroupRestController(GameEveMarketGroupCommandHandler gameEveMarketGroupCommandHandler, GameEveMarketGroupQueryHandler gameEveMarketGroupQueryHandler) {
        this.gameEveMarketGroupCommandHandler = gameEveMarketGroupCommandHandler;
        this.gameEveMarketGroupQueryHandler = gameEveMarketGroupQueryHandler;
    }

    @PostMapping("/command/create")
    @Log(message = "游戏EVE市场分组创建命令", value = "#command")
    public ResponseEntity<RestResponse<Void>> create(
            @NotNull(message = "游戏EVE市场分组创建命令请求传输对象不能为空")
            @Valid @RequestBody GameEveMarketGroupCreateCReqTransfer command) {
        gameEveMarketGroupCommandHandler.create(command);
        return response().success("游戏EVE市场分组创建成功");
    }

    @PostMapping("/query/find-market-group-id-by-code")
    @Log(message = "游戏EVE市场根据编码查询市场分组ID", value = "#query")
    public ResponseEntity<RestResponse<FindMarketGroupIdQRespTransfer>> findMarketGroupIdByCode(
            @NotNull(message = "游戏EVE市场根据编码查询市场分组ID请求传输对象不能为空")
            @Valid @RequestBody FindByGameEveMarketGroupCodeQReqTransfer query) {
        return response(gameEveMarketGroupQueryHandler.findMarketGroupIdByCode(query))
                .success("游戏EVE市场根据编码查询市场分组ID成功");
    }

    @Override
    public String domainDescription() {
        return "游戏EVE市场分组领域";
    }
}
