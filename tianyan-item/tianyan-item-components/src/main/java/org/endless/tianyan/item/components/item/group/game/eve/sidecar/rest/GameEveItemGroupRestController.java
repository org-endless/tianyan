package org.endless.tianyan.item.components.item.group.game.eve.sidecar.rest;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferNullException;
import org.endless.ddd.starter.common.exception.ddd.application.query.transfer.QueryReqTransferNullException;
import org.endless.tianyan.item.common.model.facade.rest.TianyanItemRestController;
import org.endless.tianyan.item.components.item.group.game.eve.application.command.transfer.GameEveItemGroupCreateReqCReqTransfer;
import org.endless.tianyan.item.components.item.group.game.eve.application.query.transfer.GameEveItemGroupFindByCodeReqQReqTransfer;
import org.endless.tianyan.item.components.item.group.game.eve.facade.adapter.GameEveItemGroupDrivingAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * GameEveItemGroupRestController
 * <p>游戏EVE资源项分组领域Rest控制器
 * <p>
 * create 2025/07/21 16:03
 * <p>
 * update 2025/07/21 16:03
 *
 * @author Deng Haozhi
 * @see TianyanItemRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/item/group/game/eve")
public class GameEveItemGroupRestController implements TianyanItemRestController {

    /**
     * 游戏EVE资源项分组领域主动适配器
     */
    private final GameEveItemGroupDrivingAdapter gameEveItemGroupDrivingAdapter;

    public GameEveItemGroupRestController(GameEveItemGroupDrivingAdapter gameEveItemGroupDrivingAdapter) {
        this.gameEveItemGroupDrivingAdapter = gameEveItemGroupDrivingAdapter;
    }

    @PostMapping("/command/create")
    @Log(message = "游戏EVE资源项分组创建", value = "#command")
    public ResponseEntity<RestResponse> create(@RequestBody GameEveItemGroupCreateReqCReqTransfer command) {
        Optional.ofNullable(command)
                .map(GameEveItemGroupCreateReqCReqTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("游戏EVE资源项分组创建参数不能为空"));
            gameEveItemGroupDrivingAdapter.create(command);
            return response().success("游戏EVE资源项分组创建成功");
    }

    @PostMapping("/query/find_item_group_id_by_code")
    @Log(message = "根据编码查询资源项分组ID", value = "#query")
    public ResponseEntity<RestResponse> findItemGroupIdByCode(@RequestBody GameEveItemGroupFindByCodeReqQReqTransfer query) {
        Optional.ofNullable(query)
                .map(GameEveItemGroupFindByCodeReqQReqTransfer::validate)
                .orElseThrow(() -> new QueryReqTransferNullException("根据编码查询资源项分组ID参数不能为空"));
            return response().success("根据编码查询资源项分组ID成功", gameEveItemGroupDrivingAdapter.findItemGroupIdByCode(query));
    }
}
