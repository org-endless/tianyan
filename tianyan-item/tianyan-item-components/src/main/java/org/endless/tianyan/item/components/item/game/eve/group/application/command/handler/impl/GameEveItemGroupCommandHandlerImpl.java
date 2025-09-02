package org.endless.tianyan.item.components.item.game.eve.group.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.item.components.item.game.eve.group.application.command.handler.GameEveItemGroupCommandHandler;
import org.endless.tianyan.item.components.item.game.eve.group.application.command.transfer.GameEveItemGroupCreateCReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.group.domain.anticorruption.GameEveItemGroupRepository;
import org.endless.tianyan.item.components.item.game.eve.group.domain.entity.GameEveItemGroupAggregate;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * GameEveItemGroupCommandHandlerImpl
 * <p>游戏EVE资源项分组领域命令处理器
 * <p>
 * itemCreate 2025/07/21 16:03
 * <p>
 * update 2025/07/21 16:03
 *
 * @author Deng Haozhi
 * @see GameEveItemGroupCommandHandler
 * @since 0.0.1
 */
@Lazy
@Service
@Validated
public class GameEveItemGroupCommandHandlerImpl implements GameEveItemGroupCommandHandler {

    /**
     * 游戏EVE资源项分组聚合仓储接口
     */
    private final GameEveItemGroupRepository gameEveItemGroupRepository;

    public GameEveItemGroupCommandHandlerImpl(GameEveItemGroupRepository gameEveItemGroupRepository) {
        this.gameEveItemGroupRepository = gameEveItemGroupRepository;
    }

    @Override
    @Transactional
    @Log(message = "游戏EVE资源项分组创建命令", value = "#command", level = LogLevel.TRACE)
    public void create(GameEveItemGroupCreateCReqTransfer command) {
        GameEveItemGroupAggregate aggregate = GameEveItemGroupAggregate.create(GameEveItemGroupAggregate.builder()
                .itemGroupId(command.itemGroupId())
                .code(command.gameEveItemGroupCode())
                .isPublished(command.isPublished())
                .isUseBasePrice(command.isUseBasePrice())
                .createUserId(command.createUserId()));
        gameEveItemGroupRepository.save(aggregate);
    }
}
