package org.endless.tianyan.sales.components.market.order.game.eve.application.command.handler.impl;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.handler.CommandHandlerNotFoundException;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.sales.components.market.order.game.eve.application.command.handler.GameEveMarketOrderCommandHandler;
import org.endless.tianyan.sales.components.market.order.game.eve.application.command.transfer.GameEveMarketOrderFetchReqCTransfer;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.anticorruption.GameEveMarketOrderDrivenAdapter;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.anticorruption.GameEveMarketOrderItemDrivenAdapter;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.anticorruption.GameEveMarketOrderRepository;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.entity.GameEveMarketOrderAggregate;
import org.endless.tianyan.sales.components.market.order.market.order.application.query.transfer.MarketOrderFindByItemIdReqQTransfer;
import org.endless.tianyan.sales.components.market.order.market.order.facade.adapter.MarketOrderDrivingAdapter;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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
     * 市场订单主动适配器接口
     */
    private final MarketOrderDrivingAdapter marketOrderDrivingAdapter;

    /**
     * 游戏EVE市场订单被动适配器接口
     */
    private final GameEveMarketOrderDrivenAdapter gameEveMarketOrderDrivenAdapter;

    /**
     * 游戏EVE市场订单资源项被动适配器接口
     */
    private final GameEveMarketOrderItemDrivenAdapter gameEveMarketOrderItemDrivenAdapter;

    public GameEveMarketOrderCommandHandlerImpl(
            GameEveMarketOrderRepository gameEveMarketOrderRepository,
            MarketOrderDrivingAdapter marketOrderDrivingAdapter,
            GameEveMarketOrderDrivenAdapter gameEveMarketOrderDrivenAdapter,
            GameEveMarketOrderItemDrivenAdapter gameEveMarketOrderItemDrivenAdapter) {
        this.gameEveMarketOrderRepository = gameEveMarketOrderRepository;
        this.marketOrderDrivingAdapter = marketOrderDrivingAdapter;
        this.gameEveMarketOrderDrivenAdapter = gameEveMarketOrderDrivenAdapter;
        this.gameEveMarketOrderItemDrivenAdapter = gameEveMarketOrderItemDrivenAdapter;
    }

    @Override
    @Transactional
    @Log(message = "游戏EVE市场订单获取命令", value = "#command", level = LogLevel.TRACE)
    public void fetch(GameEveMarketOrderFetchReqCTransfer command) {
        Optional.ofNullable(command)
                .map(GameEveMarketOrderFetchReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("游戏EVE市场订单获取命令参数不能为空"));
        String gameEveItemCode = gameEveMarketOrderItemDrivenAdapter.findGameEveItemCodeByItemId(command.getItemId())
                .orElseThrow(() -> new CommandHandlerNotFoundException("游戏EVE资源项编码不存在，资源项ID: " + command.getItemId()));
        List<String> marketOrderIds = marketOrderDrivingAdapter.findIdsByItemId(MarketOrderFindByItemIdReqQTransfer.builder()
                .itemId(command.getItemId())
                .build().validate()).getMarketOrderIds();
        List<GameEveMarketOrderAggregate> existedAggregates = new ArrayList<>();
        if (!CollectionUtils.isEmpty(marketOrderIds)) {
            existedAggregates = gameEveMarketOrderRepository.findAllByMarketOrderIds(marketOrderIds);
        }
        List<GameEveMarketOrderAggregate> aggregates = gameEveMarketOrderDrivenAdapter
                .fetch(existedAggregates, command.getItemId(), gameEveItemCode, command.getCreateUserId());
        gameEveMarketOrderRepository.upsert(aggregates);
    }
}
