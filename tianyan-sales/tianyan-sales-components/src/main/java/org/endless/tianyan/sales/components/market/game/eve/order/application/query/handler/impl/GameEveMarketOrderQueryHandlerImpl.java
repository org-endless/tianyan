package org.endless.tianyan.sales.components.market.game.eve.order.application.query.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.sales.components.market.game.eve.order.application.query.anticorruption.GameEveMarketOrderItemQueryDrivenAdapter;
import org.endless.tianyan.sales.components.market.game.eve.order.application.query.anticorruption.GameEveMarketOrderQueryRepository;
import org.endless.tianyan.sales.components.market.game.eve.order.application.query.handler.GameEveMarketOrderQueryHandler;
import org.endless.tianyan.sales.components.market.game.eve.order.application.query.transfer.FindItemIdsRespQReqTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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
@Lazy
@Service
@Validated
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
    public FindItemIdsRespQReqTransfer fetchCodes() {
        return FindItemIdsRespQReqTransfer.builder()
                .itemIds(gameEveMarketOrderItemQueryDrivenAdapter.fetchCodes())
                .build().validate();
    }
}
