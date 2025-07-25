package org.endless.tianyan.sales.components.market.order.game.eve.application.command.handler.impl;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.sales.components.market.order.game.eve.application.command.handler.GameEveMarketOrderCommandHandler;
import org.endless.tianyan.sales.components.market.order.game.eve.application.command.transfer.GameEveMarketOrderFetchReqCTransfer;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.anticorruption.GameEveMarketOrderDrivenAdapter;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.anticorruption.GameEveMarketOrderRepository;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.entity.GameEveMarketOrderAggregate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
public class GameEveMarketOrderCommandHandlerImpl implements GameEveMarketOrderCommandHandler {

    /**
     * 游戏EVE市场订单聚合仓储接口
     */
    private final GameEveMarketOrderRepository gameEveMarketOrderRepository;

    /**
     * 游戏EVE市场订单被动适配器接口
     */
    private final GameEveMarketOrderDrivenAdapter gameEveMarketOrderDrivenAdapter;

    public GameEveMarketOrderCommandHandlerImpl(GameEveMarketOrderRepository gameEveMarketOrderRepository, GameEveMarketOrderDrivenAdapter gameEveMarketOrderDrivenAdapter) {
        this.gameEveMarketOrderRepository = gameEveMarketOrderRepository;
        this.gameEveMarketOrderDrivenAdapter = gameEveMarketOrderDrivenAdapter;
    }

    @Override
    @Transactional
    @Log(message = "游戏EVE市场订单获取命令", value = "#command", level = LogLevel.TRACE)
    public void fetch(GameEveMarketOrderFetchReqCTransfer command) {
        Optional.ofNullable(command)
                .map(GameEveMarketOrderFetchReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("游戏EVE市场订单获取命令参数不能为空"));
        List<GameEveMarketOrderAggregate> aggregates = gameEveMarketOrderDrivenAdapter
                .fetch(gameEveMarketOrderRepository.findAllByCode(command.getGameEveItemCode()), command.getGameEveItemCode(), command.getCreateUserId());
        gameEveMarketOrderRepository.upsert(aggregates);
    }
}
