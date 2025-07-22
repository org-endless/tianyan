package org.endless.tianyan.sales.components.market.game.eve.group.sidecar.rest;

import org.endless.tianyan.sales.common.model.sidecar.rest.*;
import org.endless.tianyan.sales.components.market.game.eve.group.facade.adapter.*;
import org.endless.ddd.simplified.starter.common.exception.model.sidecar.rest.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GameEveMarketGroupRestController
 * <p>游戏EVE市场分组领域Rest控制器
 * <p>
 * create 2025/07/22 09:09
 * <p>
 * update 2025/07/22 09:09
 *
 * @author Deng Haozhi
 * @see TianyanSalesRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/market/game/eve/group")
public class GameEveMarketGroupRestController implements TianyanSalesRestController {

    /**
     * 游戏EVE市场分组领域主动适配器
     */
    private final GameEveMarketGroupDrivingAdapter gameEveMarketGroupDrivingAdapter;

    public GameEveMarketGroupRestController(GameEveMarketGroupDrivingAdapter gameEveMarketGroupDrivingAdapter) {
        this.gameEveMarketGroupDrivingAdapter = gameEveMarketGroupDrivingAdapter;
    }
}
