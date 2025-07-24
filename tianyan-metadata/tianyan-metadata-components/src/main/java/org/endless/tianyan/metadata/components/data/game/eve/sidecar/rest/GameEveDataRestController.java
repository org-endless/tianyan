package org.endless.tianyan.metadata.components.data.game.eve.sidecar.rest;

import org.endless.tianyan.metadata.common.model.sidecar.rest.*;
import org.endless.tianyan.metadata.components.data.game.eve.facade.adapter.*;
import org.endless.ddd.simplified.starter.common.exception.model.sidecar.rest.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GameEveDataRestController
 * <p>游戏EVE数据领域Rest控制器
 * <p>
 * create 2025/07/24 08:49
 * <p>
 * update 2025/07/24 08:49
 *
 * @author Deng Haozhi
 * @see TianyanMetadataRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/data/game/eve")
public class GameEveDataRestController implements TianyanMetadataRestController {

    /**
     * 游戏EVE数据领域主动适配器
     */
    private final GameEveDataDrivingAdapter gameEveDataDrivingAdapter;

    public GameEveDataRestController(GameEveDataDrivingAdapter gameEveDataDrivingAdapter) {
        this.gameEveDataDrivingAdapter = gameEveDataDrivingAdapter;
    }
}
