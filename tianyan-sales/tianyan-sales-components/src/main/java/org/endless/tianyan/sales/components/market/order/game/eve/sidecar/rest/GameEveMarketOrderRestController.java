package org.endless.tianyan.sales.components.market.order.game.eve.sidecar.rest;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.sales.common.model.sidecar.rest.TianyanSalesRestController;
import org.endless.tianyan.sales.components.market.order.game.eve.application.command.transfer.GameEveMarketOrderFetchReqCTransfer;
import org.endless.tianyan.sales.components.market.order.game.eve.facade.adapter.GameEveMarketOrderDrivingAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * GameEveMarketOrderRestController
 * <p>游戏EVE市场订单领域Rest控制器
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
@RequestMapping("/market/order/game/eve")
public class GameEveMarketOrderRestController implements TianyanSalesRestController {

    /**
     * 游戏EVE市场订单领域主动适配器
     */
    private final GameEveMarketOrderDrivingAdapter gameEveMarketOrderDrivingAdapter;

    public GameEveMarketOrderRestController(GameEveMarketOrderDrivingAdapter gameEveMarketOrderDrivingAdapter) {
        this.gameEveMarketOrderDrivingAdapter = gameEveMarketOrderDrivingAdapter;
    }

    @PostMapping("/command/fetch")
    @Log(message = "游戏EVE市场订单获取", value = "#command")
    public ResponseEntity<RestResponse> fetch(@RequestBody GameEveMarketOrderFetchReqCTransfer command) {
        Optional.ofNullable(command)
                .map(GameEveMarketOrderFetchReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("游戏EVE市场订单获取参数不能为空"));
        gameEveMarketOrderDrivingAdapter.fetch(command);
        return response().success("游戏EVE市场订单获取成功");
    }
}
