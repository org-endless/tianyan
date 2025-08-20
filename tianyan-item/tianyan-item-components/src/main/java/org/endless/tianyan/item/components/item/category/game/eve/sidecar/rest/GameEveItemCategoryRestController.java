package org.endless.tianyan.item.components.item.category.game.eve.sidecar.rest;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.item.common.model.facade.rest.TianyanItemRestController;
import org.endless.tianyan.item.components.item.category.game.eve.application.command.transfer.GameEveItemCategoryCreateReqCReqTransfer;
import org.endless.tianyan.item.components.item.category.game.eve.application.query.transfer.GameEveItemCategoryFindByCodeReqQReqTransfer;
import org.endless.tianyan.item.components.item.category.game.eve.facade.adapter.GameEveItemCategoryDrivingAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * GameEveItemCategoryRestController
 * <p>游戏EVE资源项分类领域Rest控制器
 * <p>
 * itemCreate 2025/07/21 15:05
 * <p>
 * update 2025/07/21 15:05
 *
 * @author Deng Haozhi
 * @see TianyanItemRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/item/category/game/eve")
public class GameEveItemCategoryRestController implements TianyanItemRestController {

    /**
     * 游戏EVE资源项分类领域主动适配器
     */
    private final GameEveItemCategoryDrivingAdapter gameEveItemCategoryDrivingAdapter;

    public GameEveItemCategoryRestController(GameEveItemCategoryDrivingAdapter gameEveItemCategoryDrivingAdapter) {
        this.gameEveItemCategoryDrivingAdapter = gameEveItemCategoryDrivingAdapter;
    }

    @PostMapping("/command/create")
    @Log(message = "游戏EVE资源项分类创建", value = "#command")
    public ResponseEntity<RestResponse> create(@RequestBody GameEveItemCategoryCreateReqCReqTransfer command) {
        Optional.ofNullable(command)
                .map(GameEveItemCategoryCreateReqCReqTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("游戏EVE资源项分类创建参数不能为空"));
            gameEveItemCategoryDrivingAdapter.create(command);
            return response().success("游戏EVE资源项分类创建成功");
    }

    @PostMapping("/query/find_item_category_id_by_code")
    @Log(message = "游戏EVE资源项分类根据编码查询ID", value = "#command")
    public ResponseEntity<RestResponse> findItemCategoryIdByCode(@RequestBody GameEveItemCategoryFindByCodeReqQReqTransfer query) {
        Optional.ofNullable(query)
                .map(GameEveItemCategoryFindByCodeReqQReqTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("游戏EVE资源项分类根据编码查询ID参数不能为空"));
            return response().success("游戏EVE资源项分类根据编码查询ID成功", gameEveItemCategoryDrivingAdapter.findItemCategoryIdByCode(query));
    }
}
