package org.endless.tianyan.sales.components.market.game.eve.order.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.sales.components.market.game.eve.order.application.command.handler.GameEveMarketOrderCommandHandler;
import org.endless.tianyan.sales.components.market.game.eve.order.application.command.transfer.GameEveMarketOrderFetchCReqTransfer;
import org.endless.tianyan.sales.components.market.game.eve.order.application.command.transfer.GameEveMarketOrderGeneratePriceCReqTransfer;
import org.endless.tianyan.sales.components.market.game.eve.order.domain.anticorruption.GameEveMarketOrderDrivenAdapter;
import org.endless.tianyan.sales.components.market.game.eve.order.domain.anticorruption.GameEveMarketOrderRepository;
import org.endless.tianyan.sales.components.market.game.eve.order.domain.entity.GameEveMarketOrderAggregate;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * GameEveMarketOrderCommandHandlerImpl
 * <p>游戏EVE市场订单领域命令处理器
 * <p>
 * create 2025/07/25 11:19
 * <p>
 * update 2025/07/25 11:19
 *
 * @author Deng Haozhi
 * @see GameEveMarketOrderCommandHandler
 * @since 0.0.1
 */
@Lazy
@Service
@Validated
public class GameEveMarketOrderCommandHandlerImpl implements GameEveMarketOrderCommandHandler {

    /**
     * 游戏EVE市场订单聚合仓储接口
     */
    private final GameEveMarketOrderRepository gameEveMarketOrderRepository;

    /**
     * 游戏EVE市场订单被动适配器接口
     */
    private final GameEveMarketOrderDrivenAdapter gameEveMarketOrderDrivenAdapter;

    public GameEveMarketOrderCommandHandlerImpl(
            GameEveMarketOrderRepository gameEveMarketOrderRepository,
            GameEveMarketOrderDrivenAdapter gameEveMarketOrderDrivenAdapter) {
        this.gameEveMarketOrderRepository = gameEveMarketOrderRepository;
        this.gameEveMarketOrderDrivenAdapter = gameEveMarketOrderDrivenAdapter;
    }

    @Override
    @Transactional
    @Log(message = "游戏EVE市场订单获取命令", value = "#command", level = LogLevel.TRACE)
    public void fetch(GameEveMarketOrderFetchCReqTransfer command) {
        List<GameEveMarketOrderAggregate> aggregates = gameEveMarketOrderDrivenAdapter
                .fetch(command.gameEveItemCode(), command.createUserId());
        gameEveMarketOrderRepository.upsert(aggregates);
    }

    @Override
    @Log(message = "游戏EVE市场订单生成价格命令", value = "#command", level = LogLevel.TRACE)
    public void generatePrice(GameEveMarketOrderGeneratePriceCReqTransfer command) {
        gameEveMarketOrderDrivenAdapter.generatePrice(command.gameEveItemCode(), command.createUserId());
    }
}
