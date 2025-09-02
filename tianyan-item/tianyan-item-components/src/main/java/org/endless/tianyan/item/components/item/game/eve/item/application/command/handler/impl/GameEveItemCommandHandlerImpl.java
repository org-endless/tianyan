package org.endless.tianyan.item.components.item.game.eve.item.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.command.handler.CommandFailedException;
import org.endless.tianyan.item.components.item.game.eve.item.application.command.handler.GameEveItemCommandHandler;
import org.endless.tianyan.item.components.item.game.eve.item.application.command.transfer.GameEveItemCreateCReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.item.application.command.transfer.GameEveItemFetchCReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.item.application.command.transfer.GameEveItemFetchCRespTransfer;
import org.endless.tianyan.item.components.item.game.eve.item.domain.anticorruption.GameEveItemDrivenAdapter;
import org.endless.tianyan.item.components.item.game.eve.item.domain.anticorruption.GameEveItemRepository;
import org.endless.tianyan.item.components.item.game.eve.item.domain.entity.GameEveItemAggregate;
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

    /**
     * 游戏EVE资源项被动适配器接口
     */
    private final GameEveItemDrivenAdapter gameEveItemDrivenAdapter;

    public GameEveItemCommandHandlerImpl(GameEveItemRepository gameEveItemRepository, GameEveItemDrivenAdapter gameEveItemDrivenAdapter) {
        this.gameEveItemRepository = gameEveItemRepository;
        this.gameEveItemDrivenAdapter = gameEveItemDrivenAdapter;
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

    @Override
    @Transactional
    @Log(message = "游戏EVE资源项获取命令", value = "#command", level = LogLevel.TRACE)
    public GameEveItemFetchCRespTransfer fetch(GameEveItemFetchCReqTransfer command) {
        String itemId = gameEveItemRepository.findItemIdByCode(command.gameEveItemCode())
                .orElseGet(() -> {
                    GameEveItemAggregate newAggregate = gameEveItemDrivenAdapter.fetch(command.gameEveItemCode(), command.createUserId())
                            .orElseThrow(() -> new CommandFailedException("游戏EVE资源项创建失败"));
                    gameEveItemRepository.save(newAggregate);
                    return newAggregate.getGameEveItemId();
                });
        return GameEveItemFetchCRespTransfer.builder()
                .itemId(itemId)
                .build();
    }
}
