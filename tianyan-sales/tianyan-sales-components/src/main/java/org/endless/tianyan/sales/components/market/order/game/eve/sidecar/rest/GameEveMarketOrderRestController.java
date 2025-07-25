package org.endless.tianyan.sales.components.market.order.game.eve.sidecar.rest;

import org.endless.tianyan.sales.common.model.sidecar.rest.*;
import org.endless.tianyan.sales.components.market.order.game.eve.facade.adapter.*;
import org.endless.ddd.simplified.starter.common.exception.model.sidecar.rest.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
