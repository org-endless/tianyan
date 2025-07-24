package org.endless.tianyan.sales.components.market.group.game.eve.sidecar.rest;

import com.alibaba.fastjson2.JSONException;
import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.CommandReqTransferNullException;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.transfer.QueryReqTransferNullException;
import org.endless.ddd.simplified.starter.common.exception.model.sidecar.rest.RestErrorException;
import org.endless.ddd.simplified.starter.common.model.sidecar.rest.RestResponse;
import org.endless.tianyan.sales.common.model.sidecar.rest.TianyanSalesRestController;
import org.endless.tianyan.sales.components.market.group.game.eve.application.command.transfer.GameEveMarketGroupCreateReqCTransfer;
import org.endless.tianyan.sales.components.market.group.game.eve.application.query.transfer.GameEveMarketGroupFindByCodeReqQTransfer;
import org.endless.tianyan.sales.components.market.group.game.eve.facade.adapter.GameEveMarketGroupDrivingAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * GameEveMarketGroupRestController
 * <p>游戏EVE市场分组领域Rest控制器
 * <p>
 * create 2025/07/24 17:37
 * <p>
 * update 2025/07/24 17:37
 *
 * @author Deng Haozhi
 * @see TianyanSalesRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/market/group/game/eve")
public class GameEveMarketGroupRestController implements TianyanSalesRestController {

    /**
     * 游戏EVE市场分组领域主动适配器
     */
    private final GameEveMarketGroupDrivingAdapter gameEveMarketGroupDrivingAdapter;

    public GameEveMarketGroupRestController(GameEveMarketGroupDrivingAdapter gameEveMarketGroupDrivingAdapter) {
        this.gameEveMarketGroupDrivingAdapter = gameEveMarketGroupDrivingAdapter;
    }

    @PostMapping("/command/create")
    @Log(message = "游戏EVE市场分组创建", value = "#command")
    public ResponseEntity<RestResponse> create(@RequestBody GameEveMarketGroupCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(GameEveMarketGroupCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("游戏EVE市场分组创建参数不能为空"));
        try {
            gameEveMarketGroupDrivingAdapter.create(command);
            return response().success("游戏EVE市场分组创建成功");
        } catch (JSONException | NullPointerException e) {
            throw new RestErrorException("游戏EVE市场分组创建失败", e);
        }
    }

    @PostMapping("/query/find_market_group_id_by_code")
    @Log(message = "游戏EVE市场根据编码查询市场分组ID", value = "#query")
    public ResponseEntity<RestResponse> findMarketGroupIdByCode(@RequestBody GameEveMarketGroupFindByCodeReqQTransfer query) {
        Optional.ofNullable(query)
                .map(GameEveMarketGroupFindByCodeReqQTransfer::validate)
                .orElseThrow(() -> new QueryReqTransferNullException("游戏EVE市场根据编码查询市场分组ID参数不能为空"));
        try {
            return response().success("游戏EVE市场根据编码查询市场分组ID成功", gameEveMarketGroupDrivingAdapter.findMarketGroupIdByCode(query));
        } catch (JSONException | NullPointerException e) {
            throw new RestErrorException("游戏EVE市场根据编码查询市场分组ID失败", e);
        }
    }
}
