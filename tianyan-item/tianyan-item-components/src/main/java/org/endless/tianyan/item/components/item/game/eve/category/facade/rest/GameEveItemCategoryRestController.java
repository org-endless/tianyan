package org.endless.tianyan.item.components.item.game.eve.category.facade.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.tianyan.item.common.model.facade.rest.TianyanItemRestController;
import org.endless.tianyan.item.components.item.game.eve.category.application.command.handler.GameEveItemCategoryCommandHandler;
import org.endless.tianyan.item.components.item.game.eve.category.application.command.transfer.GameEveItemCategoryCreateCReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.category.application.query.handler.GameEveItemCategoryQueryHandler;
import org.endless.tianyan.item.components.item.game.eve.category.application.query.transfer.FindByGameEveItemCategoryCodeQReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.category.application.query.transfer.FindItemCategoryIdQRespTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GameEveItemCategoryRestController
 * <p>游戏EVE资源项分类领域REST控制器
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
@RequestMapping("/item/game-eve-item-category")
public class GameEveItemCategoryRestController implements TianyanItemRestController {

    /**
     * 游戏EVE资源项分类领域命令处理器
     */
    private final GameEveItemCategoryCommandHandler gameEveItemCategoryCommandHandler;

    /**
     * 游戏EVE资源项分类领域查询处理器
     */
    private final GameEveItemCategoryQueryHandler gameEveItemCategoryQueryHandler;

    public GameEveItemCategoryRestController(GameEveItemCategoryCommandHandler gameEveItemCategoryCommandHandler, GameEveItemCategoryQueryHandler gameEveItemCategoryQueryHandler) {
        this.gameEveItemCategoryCommandHandler = gameEveItemCategoryCommandHandler;
        this.gameEveItemCategoryQueryHandler = gameEveItemCategoryQueryHandler;
    }

    @PostMapping("/command/create")
    @Log(message = "游戏EVE资源项分类创建命令", value = "#command")
    public ResponseEntity<RestResponse<Void>> create(
            @NotNull(message = "游戏EVE资源项分类创建命令请求传输对象不能为空")
            @Valid @RequestBody GameEveItemCategoryCreateCReqTransfer command) {
        gameEveItemCategoryCommandHandler.create(command);
        return response().success("游戏EVE资源项分类创建成功");
    }

    @PostMapping("/query/find-item-category-id-by-code")
    @Log(message = "根据编码游戏EVE资源项分类查询资源项分类ID", value = "#command")
    public ResponseEntity<RestResponse<FindItemCategoryIdQRespTransfer>> findItemCategoryIdByCode(
            @NotNull(message = "根据编码游戏EVE资源项分类查询请求传输对象不能为空")
            @Valid @RequestBody FindByGameEveItemCategoryCodeQReqTransfer query) {
        return response(gameEveItemCategoryQueryHandler.findItemCategoryIdByCode(query))
                .success("根据编码游戏EVE资源项分类查询资源项分类ID成功");
    }

    @Override
    public String domainDescription() {
        return "游戏EVE资源项分类领域";
    }
}
