package org.endless.tianyan.item.components.item.game.eve.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.item.components.item.game.eve.application.command.handler.GameEveItemCommandHandler;
import org.endless.tianyan.item.components.item.game.eve.application.command.transfer.GameEveItemCreateCReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.domain.anticorruption.GameEveItemRepository;
import org.endless.tianyan.item.components.item.game.eve.domain.entity.GameEveItemAggregate;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * GameEveItemCommandHandlerImpl
 * <p>游戏EVE资源项领域命令处理器
 * <p>
 * itemCreate 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see GameEveItemCommandHandler
 * @since 0.0.1
 */
@Lazy
@Service
@Validated
public class GameEveItemCommandHandlerImpl implements GameEveItemCommandHandler {

    /**
     * 游戏EVE资源项聚合仓储接口
     */
    private final GameEveItemRepository gameEveItemRepository;

    public GameEveItemCommandHandlerImpl(GameEveItemRepository gameEveItemRepository) {
        this.gameEveItemRepository = gameEveItemRepository;
    }

    @Override
    @Transactional
    @Log(message = "游戏EVE资源项创建命令", value = "#command", level = LogLevel.TRACE)
    public void create(GameEveItemCreateCReqTransfer command) {
        GameEveItemAggregate aggregate = GameEveItemAggregate.create(GameEveItemAggregate.builder()
                .itemId(command.itemId())
                .code(command.gameEveItemCode())
                .isPublished(command.isPublished())
                .createUserId(command.createUserId()));
        gameEveItemRepository.save(aggregate);
    }
}
