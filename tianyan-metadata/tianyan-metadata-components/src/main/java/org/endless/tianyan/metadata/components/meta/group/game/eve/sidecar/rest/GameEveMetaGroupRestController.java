package org.endless.tianyan.metadata.components.meta.group.game.eve.sidecar.rest;

import org.endless.tianyan.metadata.common.model.sidecar.rest.*;
import org.endless.tianyan.metadata.components.meta.group.game.eve.facade.adapter.*;
import org.endless.ddd.simplified.starter.common.exception.model.sidecar.rest.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GameEveMetaGroupRestController
 * <p>游戏EVE元分组领域Rest控制器
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see TianyanMetadataRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/meta/group/game/eve")
public class GameEveMetaGroupRestController implements TianyanMetadataRestController {

    /**
     * 游戏EVE元分组领域主动适配器
     */
    private final GameEveMetaGroupDrivingAdapter gameEveMetaGroupDrivingAdapter;

    public GameEveMetaGroupRestController(GameEveMetaGroupDrivingAdapter gameEveMetaGroupDrivingAdapter) {
        this.gameEveMetaGroupDrivingAdapter = gameEveMetaGroupDrivingAdapter;
    }
}
