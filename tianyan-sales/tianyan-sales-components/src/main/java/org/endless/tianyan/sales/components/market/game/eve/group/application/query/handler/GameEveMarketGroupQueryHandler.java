package org.endless.tianyan.sales.components.market.game.eve.group.application.query.handler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.sales.common.model.application.query.handler.TianyanSalesQueryHandler;
import org.endless.tianyan.sales.components.market.game.eve.group.application.query.transfer.FindByGameEveMarketGroupCodeQReqTransfer;
import org.endless.tianyan.sales.components.market.game.eve.group.application.query.transfer.FindMarketGroupIdQRespTransfer;

/**
 * GameEveMarketGroupQueryHandler
 * <p>游戏EVE市场分组领域查询处理器
 * <p>
 * create 2025/07/24 17:37
 * <p>
 * update 2025/07/24 17:37
 *
 * @author Deng Haozhi
 * @see TianyanSalesQueryHandler
 * @since 0.0.1
 */
public interface GameEveMarketGroupQueryHandler extends TianyanSalesQueryHandler {

    /**
     * 根据游戏EVE市场分组编码查询市场分组ID
     *
     * @param query 根据游戏EVE市场分组编码查询请求传输对象
     * @return {@link FindMarketGroupIdQRespTransfer }
     */
    @Valid
    @NotNull(message = "市场分组ID查询响应传输对象")
    FindMarketGroupIdQRespTransfer findMarketGroupIdByCode(
            @NotNull(message = "根据游戏EVE市场分组编码查询请求传输对象")
            @Valid FindByGameEveMarketGroupCodeQReqTransfer query);
}
