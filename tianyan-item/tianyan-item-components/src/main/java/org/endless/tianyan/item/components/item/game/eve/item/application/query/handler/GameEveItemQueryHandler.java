package org.endless.tianyan.item.components.item.game.eve.item.application.query.handler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.item.common.model.application.query.handler.TianyanItemQueryHandler;
import org.endless.tianyan.item.components.item.game.eve.item.application.query.transfer.*;

/**
 * GameEveItemQueryHandler
 * <p>游戏EVE资源项领域查询处理器
 * <p>
 * itemCreate 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see TianyanItemQueryHandler
 * @since 0.0.1
 */
public interface GameEveItemQueryHandler extends TianyanItemQueryHandler {

    /**
     * 根据游戏EVE资源项编码查询资源项ID
     *
     * @param query 根据游戏EVE资源项编码查询请求传输对象
     * @return {@link FindItemIdQRespTransfer }
     */
    @Valid
    @NotNull(message = "资源项ID查询响应传输对象不能为空")
    FindItemIdQRespTransfer findItemIdByCode(
            @NotNull(message = "根据游戏EVE资源项编码查询请求传输对象不能为空")
            @Valid FindByGameEveItemCodeQReqTransfer query
    );

    /**
     * 根据游戏EVE资源项编码列表查询资源项ID列表
     *
     * @param query 根据游戏EVE资源项编码列表查询请求传输对象
     * @return {@link FindItemIdsQRespTransfer }
     */
    @Valid
    @NotNull(message = "资源项ID列表查询响应传输对象不能为空")
    FindItemIdsQRespTransfer findItemIdsByCodes(
            @NotNull(message = "根据游戏EVE资源项编码列表查询请求传输对象不能为空")
            @Valid FindByGameEveItemCodesQReqTransfer query);

    /**
     * 根据资源项ID查询游戏EVE资源项编码
     *
     * @param query 根据资源项ID查询请求传输对象
     * @return {@link FindGameEveItemCodeQRespTransfer }
     */
    @Valid
    @NotNull(message = "游戏EVE资源项编码查询响应传输对象不能为空")
    FindGameEveItemCodeQRespTransfer findCodeByItemId(
            @NotNull(message = "根据资源项ID查询请求传输对象不能为空")
            @Valid FindByItemIdQReqTransfer query);
}
