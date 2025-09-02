package org.endless.tianyan.item.components.item.game.eve.category.application.command.handler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.item.common.model.application.command.handler.TianyanItemCommandHandler;
import org.endless.tianyan.item.components.item.game.eve.category.application.command.transfer.GameEveItemCategoryCreateCReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.category.domain.entity.GameEveItemCategoryAggregate;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * GameEveItemCategoryCommandHandler
 * <p>游戏EVE资源项分类领域命令处理器
 * <p>
 * itemCreate 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see TianyanItemCommandHandler<GameEveItemCategoryAggregate>
 * @since 0.0.1
 */
public interface GameEveItemCategoryCommandHandler extends TianyanItemCommandHandler<GameEveItemCategoryAggregate> {

    /**
     * 游戏EVE资源项分类建命令
     *
     * @param command 游戏EVE资源项分类创建命令请求传输对象
     */
    void create(
            @NotNull(message = "游戏EVE资源项分类创建命令请求传输对象不能为空")
            @Valid @RequestParam("command") GameEveItemCategoryCreateCReqTransfer command);

}
