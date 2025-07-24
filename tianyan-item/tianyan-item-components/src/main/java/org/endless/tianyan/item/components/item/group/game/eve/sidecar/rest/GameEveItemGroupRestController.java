package org.endless.tianyan.item.components.item.group.game.eve.sidecar.rest;

import com.alibaba.fastjson2.JSONException;
import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.CommandReqTransferNullException;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.transfer.QueryReqTransferNullException;
import org.endless.ddd.simplified.starter.common.exception.model.sidecar.rest.RestErrorException;
import org.endless.ddd.simplified.starter.common.model.sidecar.rest.RestResponse;
import org.endless.tianyan.item.common.model.sidecar.rest.TianyanItemRestController;
import org.endless.tianyan.item.components.item.group.game.eve.application.command.transfer.GameEveItemGroupCreateReqCTransfer;
import org.endless.tianyan.item.components.item.group.game.eve.application.query.transfer.GameEveItemGroupFindByCodeReqQTransfer;
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
    public ResponseEntity<RestResponse> create(@RequestBody GameEveItemGroupCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(GameEveItemGroupCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("游戏EVE资源项分组创建参数不能为空"));
        try {
            gameEveItemGroupDrivingAdapter.create(command);
            return response().success("游戏EVE资源项分组创建成功");
        } catch (JSONException | NullPointerException e) {
            throw new RestErrorException("游戏EVE资源项分组创建失败", e);
        }
    }

    @PostMapping("/query/find_item_group_id_by_code")
    @Log(message = "根据编码查询资源项分组ID", value = "#query")
    public ResponseEntity<RestResponse> findItemGroupIdByCode(@RequestBody GameEveItemGroupFindByCodeReqQTransfer query) {
        Optional.ofNullable(query)
                .map(GameEveItemGroupFindByCodeReqQTransfer::validate)
                .orElseThrow(() -> new QueryReqTransferNullException("根据编码查询资源项分组ID参数不能为空"));
        try {
            return response().success("根据编码查询资源项分组ID成功", gameEveItemGroupDrivingAdapter.findItemGroupIdByCode(query));
        } catch (JSONException | NullPointerException e) {
            throw new RestErrorException("根据编码查询资源项分组ID失败", e);
        }
    }
}
