package org.endless.tianyan.sales.components.market.game.eve.order.facade.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.tianyan.sales.common.model.facade.rest.TianyanSalesRestController;
import org.endless.tianyan.sales.components.market.game.eve.order.application.command.handler.GameEveMarketOrderCommandHandler;
import org.endless.tianyan.sales.components.market.game.eve.order.application.command.transfer.GameEveMarketOrderFetchCReqTransfer;
import org.endless.tianyan.sales.components.market.game.eve.order.application.command.transfer.GameEveMarketOrderGeneratePriceCReqTransfer;
import org.endless.tianyan.sales.components.market.game.eve.order.application.query.handler.GameEveMarketOrderQueryHandler;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GameEveMarketOrderRestController
 * <p>游戏EVE市场订单领域REST控制器
 * <p>
 * create 2025/07/25 11:19
 * <p>
 * update 2025/07/25 11:19
 *
 * @author Deng Haozhi
 * @see TianyanSalesRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/market/game-eve-market-order")
public class GameEveMarketOrderRestController implements TianyanSalesRestController {

    /**
     * 游戏EVE市场订单领域命令处理器
     */
    private final GameEveMarketOrderCommandHandler gameEveMarketOrderCommandHandler;

    /**
     * 游戏EVE市场订单领域查询处理器
     */
    private final GameEveMarketOrderQueryHandler gameEveMarketOrderQueryHandler;

    public GameEveMarketOrderRestController(GameEveMarketOrderCommandHandler gameEveMarketOrderCommandHandler, GameEveMarketOrderQueryHandler gameEveMarketOrderQueryHandler) {
        this.gameEveMarketOrderCommandHandler = gameEveMarketOrderCommandHandler;
        this.gameEveMarketOrderQueryHandler = gameEveMarketOrderQueryHandler;
    }


    @PostMapping("/command/fetch")
    @Log(message = "游戏EVE市场订单获取命令", value = "#command")
    public ResponseEntity<RestResponse<Void>> fetch(
            @NotNull(message = "游戏EVE市场订单获取命令请求传输对象不能为空")
            @Valid @RequestBody GameEveMarketOrderFetchCReqTransfer command) {
        gameEveMarketOrderCommandHandler.fetch(command);
        return response().success("游戏EVE市场订单获取成功");
    }

    @PostMapping("/command/generate-price")
    @Log(message = "游戏EVE市场订单生成价格命令", value = "#command")
    public ResponseEntity<RestResponse<Void>> generatePrice(
            @NotNull(message = "游戏EVE市场订单生成价格命令请求传输对象不能为空")
            @Valid @RequestBody GameEveMarketOrderGeneratePriceCReqTransfer command) {
        gameEveMarketOrderCommandHandler.generatePrice(command);
        return response().success("游戏EVE市场订单生成价格成功");
    }

    @Override
    public String domainDescription() {
        return "游戏EVE市场订单领域";
    }
}
