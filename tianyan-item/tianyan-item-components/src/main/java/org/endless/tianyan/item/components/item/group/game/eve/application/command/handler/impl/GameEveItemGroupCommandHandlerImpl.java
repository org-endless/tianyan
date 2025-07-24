package org.endless.tianyan.item.components.item.group.game.eve.application.command.handler.impl;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.item.components.item.group.game.eve.application.command.handler.GameEveItemGroupCommandHandler;
import org.endless.tianyan.item.components.item.group.game.eve.application.command.transfer.GameEveItemGroupCreateReqCTransfer;
import org.endless.tianyan.item.components.item.group.game.eve.domain.anticorruption.GameEveItemGroupRepository;
import org.endless.tianyan.item.components.item.group.game.eve.domain.entity.GameEveItemGroupAggregate;
import org.endless.tianyan.item.components.item.group.item.group.application.command.transfer.ItemGroupCreateReqCTransfer;
import org.endless.tianyan.item.components.item.group.item.group.facade.adapter.ItemGroupDrivingAdapter;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * GameEveItemGroupCommandHandlerImpl
 * <p>游戏EVE资源项分组领域命令处理器
 * <p>
 * create 2025/07/21 16:03
 * <p>
 * update 2025/07/21 16:03
 *
 * @author Deng Haozhi
 * @see GameEveItemGroupCommandHandler
 * @since 0.0.1
 */
public class GameEveItemGroupCommandHandlerImpl implements GameEveItemGroupCommandHandler {

    /**
     * 游戏EVE资源项分组聚合仓储接口
     */
    private final GameEveItemGroupRepository gameEveItemGroupRepository;

    /**
     * 资源项分组主动适配器接口
     */
    private final ItemGroupDrivingAdapter itemGroupDrivingAdapter;

    public GameEveItemGroupCommandHandlerImpl(GameEveItemGroupRepository gameEveItemGroupRepository, ItemGroupDrivingAdapter itemGroupDrivingAdapter) {
        this.gameEveItemGroupRepository = gameEveItemGroupRepository;
        this.itemGroupDrivingAdapter = itemGroupDrivingAdapter;
    }

    @Override
    @Transactional
    @Log(message = "游戏EVE资源项分组创建命令", value = "#command", level = LogLevel.TRACE)
    public void create(GameEveItemGroupCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(GameEveItemGroupCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("游戏EVE资源项分组创建命令参数不能为空"));
        String itemGroupId = itemGroupDrivingAdapter.create(ItemGroupCreateReqCTransfer.builder()
                        .fullNameZh(command.getFullNameZh())
                        .fullNameEn(command.getFullNameEn())
                        .createUserId(command.getCreateUserId())
                        .build().validate())
                .validate().getItemGroupId();
        GameEveItemGroupAggregate aggregate = GameEveItemGroupAggregate.create(GameEveItemGroupAggregate.builder()
                .itemGroupId(itemGroupId)
                .code(command.getCode())
                .itemCategoryId(command.getItemCategoryId())
                .isPublished(command.getIsPublished())
                .isUseBasePrice(command.getIsUseBasePrice())
                .createUserId(command.getCreateUserId()));
        gameEveItemGroupRepository.save(aggregate);
    }
}
