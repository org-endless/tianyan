package org.endless.tianyan.item.components.item.game.eve.sidecar.rest;

import com.alibaba.fastjson2.JSONException;
import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.CommandReqTransferNullException;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.transfer.QueryReqTransferNullException;
import org.endless.ddd.simplified.starter.common.exception.model.sidecar.rest.RestErrorException;
import org.endless.ddd.simplified.starter.common.model.sidecar.rest.RestResponse;
import org.endless.tianyan.item.common.model.sidecar.rest.TianyanItemRestController;
import org.endless.tianyan.item.components.item.game.eve.application.command.transfer.GameEveItemCreateReqCTransfer;
import org.endless.tianyan.item.components.item.game.eve.application.query.transfer.GameEveItemFindByCodeReqQTransfer;
import org.endless.tianyan.item.components.item.game.eve.facade.adapter.GameEveItemDrivingAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * GameEveItemRestController
 * <p>游戏EVE资源项领域Rest控制器
 * <p>
 * create 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
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
     * 游戏EVE资源项领域主动适配器
     */
    private final GameEveItemDrivingAdapter gameEveItemDrivingAdapter;

    public GameEveItemRestController(GameEveItemDrivingAdapter gameEveItemDrivingAdapter) {
        this.gameEveItemDrivingAdapter = gameEveItemDrivingAdapter;
    }

    @PostMapping("/command/create")
    @Log(message = "游戏EVE资源项创建", value = "#command")
    public ResponseEntity<RestResponse> create(@RequestBody GameEveItemCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(GameEveItemCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("游戏EVE资源项创建参数不能为空"));
        try {
            gameEveItemDrivingAdapter.create(command);
            return response().success("游戏EVE资源项创建成功");
        } catch (JSONException | NullPointerException e) {
            throw new RestErrorException("游戏EVE资源项创建失败", e);
        }
    }

    @PostMapping("/query/find_item_id_by_code")
    @Log(message = "游戏EVE资源项根据编码查询资源项ID", value = "#query")
    public ResponseEntity<RestResponse> findItemIdByCode(@RequestBody GameEveItemFindByCodeReqQTransfer query) {
        Optional.ofNullable(query)
                .map(GameEveItemFindByCodeReqQTransfer::validate)
                .orElseThrow(() -> new QueryReqTransferNullException("游戏EVE资源项根据编码查询资源项ID参数不能为空"));
        try {
            return response().success("游戏EVE资源项根据编码查询资源项ID成功", gameEveItemDrivingAdapter.findItemIdByCode(query));
        } catch (JSONException | NullPointerException e) {
            throw new RestErrorException("游戏EVE资源项根据编码查询资源项ID失败", e);
        }
    }
}
