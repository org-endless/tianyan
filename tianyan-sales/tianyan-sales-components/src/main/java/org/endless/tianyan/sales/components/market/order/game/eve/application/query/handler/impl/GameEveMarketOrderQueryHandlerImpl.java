package org.endless.tianyan.sales.components.market.order.game.eve.application.query.handler.impl;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.tianyan.sales.components.market.order.game.eve.application.query.anticorruption.GameEveMarketOrderItemQueryDrivenAdapter;
import org.endless.tianyan.sales.components.market.order.game.eve.application.query.anticorruption.GameEveMarketOrderQueryRepository;
import org.endless.tianyan.sales.components.market.order.game.eve.application.query.handler.GameEveMarketOrderQueryHandler;
import org.endless.tianyan.sales.components.market.order.game.eve.application.query.transfer.GameEveMarketOrderFindItemIdsRespQTransfer;

/**
 * GameEveMarketOrderQueryHandlerImpl
 * <p>游戏EVE市场订单领域查询处理器
 * <p>
 * create 2025/07/25 11:19
 * <p>
 * update 2025/07/25 11:19
 *
 * @author Deng Haozhi
 * @see GameEveMarketOrderQueryHandler
 * @since 0.0.1
 */
public class GameEveMarketOrderQueryHandlerImpl implements GameEveMarketOrderQueryHandler {

    /**
     * 游戏EVE市场订单聚合查询仓储接口
     */
    private final GameEveMarketOrderQueryRepository gameEveMarketOrderQueryRepository;

    /**
     * 游戏EVE市场订单查询被动适配器接口
     */
    private final GameEveMarketOrderItemQueryDrivenAdapter gameEveMarketOrderItemQueryDrivenAdapter;

    public GameEveMarketOrderQueryHandlerImpl(
            GameEveMarketOrderQueryRepository gameEveMarketOrderQueryRepository,
            GameEveMarketOrderItemQueryDrivenAdapter gameEveMarketOrderItemQueryDrivenAdapter) {
        this.gameEveMarketOrderQueryRepository = gameEveMarketOrderQueryRepository;
        this.gameEveMarketOrderItemQueryDrivenAdapter = gameEveMarketOrderItemQueryDrivenAdapter;
    }

    @Override
    @Log(message = "游戏EVE市场订单资源项编码列表获取", level = LogLevel.TRACE)
    public GameEveMarketOrderFindItemIdsRespQTransfer fetchCodes() {
        return GameEveMarketOrderFindItemIdsRespQTransfer.builder()
                .itemIds(gameEveMarketOrderItemQueryDrivenAdapter.fetchCodes())
                .build().validate();
    }
}
