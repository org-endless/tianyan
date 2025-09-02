package org.endless.tianyan.item.components.item.game.eve.category.application.query.handler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.item.common.model.application.query.handler.TianyanItemQueryHandler;
import org.endless.tianyan.item.components.item.game.eve.category.application.query.transfer.FindByGameEveItemCategoryCodeQReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.category.application.query.transfer.FindItemCategoryIdQRespTransfer;
import org.endless.tianyan.item.components.item.game.eve.item.application.query.transfer.FindItemIdQRespTransfer;

/**
 * GameEveItemCategoryQueryHandler
 * <p>游戏EVE资源项分类领域查询处理器
 * <p>
 * itemCreate 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see TianyanItemQueryHandler
 * @since 0.0.1
 */
public interface GameEveItemCategoryQueryHandler extends TianyanItemQueryHandler {

    /**
     * 根据编码游戏EVE资源项分类查询资源项分类ID
     *
     * @param query 根据游戏EVE资源项编码查询请求传输对象
     * @return {@link FindItemIdQRespTransfer }
     */
    @Valid
    @NotNull(message = "资源项分类ID查询响应传输对象不能为空")
    FindItemCategoryIdQRespTransfer findItemCategoryIdByCode(
            @NotNull(message = "根据编码游戏EVE资源项分类查询请求传输对象不能为空")
            @Valid FindByGameEveItemCategoryCodeQReqTransfer query);
}
