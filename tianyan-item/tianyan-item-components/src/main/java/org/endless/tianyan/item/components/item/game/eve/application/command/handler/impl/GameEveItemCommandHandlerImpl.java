package org.endless.tianyan.item.components.item.game.eve.application.command.handler.impl;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.handler.CommandHandlerNotFoundException;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.item.components.item.game.eve.application.command.handler.GameEveItemCommandHandler;
import org.endless.tianyan.item.components.item.game.eve.application.command.transfer.GameEveItemCreateReqCTransfer;
import org.endless.tianyan.item.components.item.game.eve.application.command.transfer.GameEveItemFetchReqCTransfer;
import org.endless.tianyan.item.components.item.game.eve.application.command.transfer.GameEveItemFetchRespCTransfer;
import org.endless.tianyan.item.components.item.game.eve.domain.anticorruption.GameEveItemDrivenAdapter;
import org.endless.tianyan.item.components.item.game.eve.domain.anticorruption.GameEveItemRepository;
import org.endless.tianyan.item.components.item.game.eve.domain.entity.GameEveItemAggregate;
import org.endless.tianyan.item.components.item.item.application.command.transfer.ItemCreateReqCTransfer;
import org.endless.tianyan.item.components.item.item.facade.adapter.ItemDrivingAdapter;
import org.springframework.transaction.annotation.Transactional;

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
public class GameEveItemCommandHandlerImpl implements GameEveItemCommandHandler {

    /**
     * 游戏EVE资源项聚合仓储接口
     */
    private final GameEveItemRepository gameEveItemRepository;

    /**
     * 资源项主动适配器接口
     */
    private final ItemDrivingAdapter itemDrivingAdapter;

    /**
     * 游戏EVE资源项被动适配器接口
     */
    private final GameEveItemDrivenAdapter gameEveItemDrivenAdapter;

    public GameEveItemCommandHandlerImpl(GameEveItemRepository gameEveItemRepository, ItemDrivingAdapter itemDrivingAdapter, GameEveItemDrivenAdapter gameEveItemDrivenAdapter) {
        this.gameEveItemRepository = gameEveItemRepository;
        this.itemDrivingAdapter = itemDrivingAdapter;
        this.gameEveItemDrivenAdapter = gameEveItemDrivenAdapter;
    }

    @Override
    @Transactional
    @Log(message = "游戏EVE资源项创建命令", value = "#command", level = LogLevel.TRACE)
    public void create(GameEveItemCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(GameEveItemCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("游戏EVE资源项创建参数不能为空"));
        String itemId = itemDrivingAdapter.create(ItemCreateReqCTransfer.builder()
                        .metaGroupId(command.getMetaGroupId())
                        .itemGroupId(command.getItemGroupId())
                        .marketGroupId(command.getMarketGroupId())
                        .fullNameZh(command.getFullNameZh())
                        .fullNameEn(command.getFullNameEn())
                        .description(command.getDescription())
                        .createUserId(command.getCreateUserId())
                        .build().validate())
                .validate().getItemId();
        GameEveItemAggregate aggregate = GameEveItemAggregate.create(GameEveItemAggregate.builder()
                .itemId(itemId)
                .code(command.getGameEveItemCode())
                .isPublished(command.getIsPublished())
                .createUserId(command.getCreateUserId()));
        gameEveItemRepository.save(aggregate);
    }

    @Override
    @Transactional
    @Log(message = "游戏EVE资源项获取命令", value = "#command", level = LogLevel.TRACE)
    public GameEveItemFetchRespCTransfer fetch(GameEveItemFetchReqCTransfer command) {
        Optional.ofNullable(command)
                .map(GameEveItemFetchReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("游戏EVE资源项获取参数不能为空"));
        Optional<String> itemId = gameEveItemRepository.findItemIdByCode(command.getGameEveItemCode());
        if (itemId.isPresent()) {
            return GameEveItemFetchRespCTransfer.builder()
                    .itemId(itemId.get())
                    .build().validate();
        } else {
            GameEveItemAggregate aggregate = gameEveItemDrivenAdapter.fetch(command.getGameEveItemCode(), command.getCreateUserId())
                    .orElseThrow(() -> new CommandHandlerNotFoundException("游戏EVE资源项不存在"));
            gameEveItemRepository.save(aggregate.validate());
            return GameEveItemFetchRespCTransfer.builder()
                    .itemId(aggregate.getItemId())
                    .build().validate();
        }
    }
}
