package org.endless.tianyan.sales.components.market.game.eve.group.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.sales.components.market.game.eve.group.application.command.handler.GameEveMarketGroupCommandHandler;
import org.endless.tianyan.sales.components.market.game.eve.group.application.command.transfer.GameEveMarketGroupCreateCReqTransfer;
import org.endless.tianyan.sales.components.market.game.eve.group.domain.anticorruption.GameEveMarketGroupRepository;
import org.endless.tianyan.sales.components.market.game.eve.group.domain.entity.GameEveMarketGroupAggregate;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

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
@Lazy
@Service
@Validated
public class GameEveMarketGroupCommandHandlerImpl implements GameEveMarketGroupCommandHandler {

    /**
     * 游戏EVE市场分组聚合仓储接口
     */
    private final GameEveMarketGroupRepository gameEveMarketGroupRepository;


    public GameEveMarketGroupCommandHandlerImpl(GameEveMarketGroupRepository gameEveMarketGroupRepository) {
        this.gameEveMarketGroupRepository = gameEveMarketGroupRepository;
    }

    @Override
    @Transactional
    @Log(message = "游戏EVE市场分组创建命令", value = "#command", level = LogLevel.TRACE)
    public void create(GameEveMarketGroupCreateCReqTransfer command) {
        GameEveMarketGroupAggregate aggregate = GameEveMarketGroupAggregate.create(GameEveMarketGroupAggregate.builder()
                .marketGroupId(command.marketGroupId())
                .code(command.gameEveMarketGroupCode())
                .createUserId(command.createUserId()));
        gameEveMarketGroupRepository.save(aggregate);
    }
}
