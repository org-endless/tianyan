package org.endless.tianyan.sales.components.market.group.game.eve.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.command.handler.CommandNotFoundException;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.sales.components.market.group.game.eve.application.command.handler.GameEveMarketGroupCommandHandler;
import org.endless.tianyan.sales.components.market.group.game.eve.application.command.transfer.GameEveMarketGroupCreateReqCTransfer;
import org.endless.tianyan.sales.components.market.group.game.eve.domain.anticorruption.GameEveMarketGroupRepository;
import org.endless.tianyan.sales.components.market.group.game.eve.domain.entity.GameEveMarketGroupAggregate;
import org.endless.tianyan.sales.components.market.group.market.group.application.command.transfer.MarketGroupCreateReqCTransfer;
import org.endless.tianyan.sales.components.market.group.market.group.application.query.transfer.MarketGroupFindByIdReqQTransfer;
import org.endless.tianyan.sales.components.market.group.market.group.facade.adapter.MarketGroupDrivingAdapter;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * GameEveMarketGroupCommandHandlerImpl
 * <p>游戏EVE市场分组领域命令处理器
 * <p>
 * create 2025/07/24 17:37
 * <p>
 * update 2025/07/24 17:37
 *
 * @author Deng Haozhi
 * @see GameEveMarketGroupCommandHandler
 * @since 0.0.1
 */
public class GameEveMarketGroupCommandHandlerImpl implements GameEveMarketGroupCommandHandler {

    /**
     * 游戏EVE市场分组聚合仓储接口
     */
    private final GameEveMarketGroupRepository gameEveMarketGroupRepository;

    /**
     * 市场分组主动适配器接口
     */
    private final MarketGroupDrivingAdapter marketGroupDrivingAdapter;

    public GameEveMarketGroupCommandHandlerImpl(GameEveMarketGroupRepository gameEveMarketGroupRepository, MarketGroupDrivingAdapter marketGroupDrivingAdapter) {
        this.gameEveMarketGroupRepository = gameEveMarketGroupRepository;
        this.marketGroupDrivingAdapter = marketGroupDrivingAdapter;
    }

    @Override
    @Transactional
    @Log(message = "游戏EVE市场分组创建命令", value = "#command", level = LogLevel.TRACE)
    public void create(GameEveMarketGroupCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(GameEveMarketGroupCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("游戏EVE市场分组命令参数不能为空"));
        String parentId = command.getParentCode() == null ? null : gameEveMarketGroupRepository.findMarketGroupIdByCode(command.getParentCode())
                .orElseThrow(() -> new CommandNotFoundException("游戏EVE市场分组的父分组不存在"));
        if (parentId != null) {
            marketGroupDrivingAdapter.existsById(MarketGroupFindByIdReqQTransfer.builder()
                    .marketGroupId(parentId).build().validate());
        }
        String marketGroupId = marketGroupDrivingAdapter.create(MarketGroupCreateReqCTransfer.builder()
                .fullNameZh(command.getFullNameZh())
                .fullNameEn(command.getFullNameEn())
                .parentId(command.getParentCode())
                .createUserId(command.getCreateUserId())
                .build().validate()).validate().getMarketGroupId();
        GameEveMarketGroupAggregate aggregate = GameEveMarketGroupAggregate.create(GameEveMarketGroupAggregate.builder()
                .marketGroupId(marketGroupId)
                .code(command.getCode())
                .createUserId(command.getCreateUserId()));
        gameEveMarketGroupRepository.save(aggregate);
    }
}
