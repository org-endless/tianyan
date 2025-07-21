package org.endless.tianyan.item.components.item.game.eve.sidecar.rest;

import org.endless.tianyan.item.common.model.sidecar.rest.*;
import org.endless.tianyan.item.components.item.game.eve.facade.adapter.*;
import org.endless.ddd.simplified.starter.common.exception.model.sidecar.rest.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GameEveItemRestController
 * <p>游戏EVE物品领域Rest控制器
 * <p>
 * create 2025/07/19 09:28
 * <p>
 * update 2025/07/19 09:28
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
     * 游戏EVE物品领域主动适配器
     */
    private final GameEveItemDrivingAdapter gameEveItemDrivingAdapter;

    public GameEveItemRestController(GameEveItemDrivingAdapter gameEveItemDrivingAdapter) {
        this.gameEveItemDrivingAdapter = gameEveItemDrivingAdapter;
    }
}
