package org.endless.tianyan.item.components.item.game.eve.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.command.handler.CommandNotFoundException;
import org.endless.tianyan.item.components.item.game.eve.application.command.handler.GameEveItemCommandHandler;
import org.endless.tianyan.item.components.item.game.eve.application.command.transfer.GameEveItemCreateReqCReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.application.command.transfer.GameEveItemFetchReqCReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.application.command.transfer.GameEveItemFetchRespCReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.domain.anticorruption.GameEveItemDrivenAdapter;
import org.endless.tianyan.item.components.item.game.eve.domain.anticorruption.GameEveItemRepository;
import org.endless.tianyan.item.components.item.game.eve.domain.entity.GameEveItemAggregate;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

/**
 * GameEveItemCommandHandlerImpl
 * <p>游戏EVE资源项领域命令处理器
 * <p>
 * create 2025/07/23 01:04
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
    public void create(GameEveItemCreateReqCReqTransfer command) {
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
    public GameEveItemFetchRespCReqTransfer fetch(GameEveItemFetchReqCReqTransfer command) {
        Optional<String> itemId = gameEveItemRepository.findItemIdByCode(command.gameEveItemCode());
        if (itemId.isPresent()) {
            return GameEveItemFetchRespCReqTransfer.builder()
                    .itemId(itemId.get())
                    .build().validate();
        } else {
            GameEveItemAggregate aggregate = gameEveItemDrivenAdapter.fetch(command.gameEveItemCode(), command.createUserId())
                    .orElseThrow(() -> new CommandNotFoundException("游戏EVE资源项不存在"));
            gameEveItemRepository.save(aggregate.validate());
            return GameEveItemFetchRespCReqTransfer.builder()
                    .itemId(aggregate.getItemId())
                    .build().validate();
        }
    }
}
