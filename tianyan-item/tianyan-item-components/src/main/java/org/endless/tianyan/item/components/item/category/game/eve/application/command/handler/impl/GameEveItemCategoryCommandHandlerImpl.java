package org.endless.tianyan.item.components.item.category.game.eve.application.command.handler.impl;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.item.components.item.category.game.eve.application.command.handler.GameEveItemCategoryCommandHandler;
import org.endless.tianyan.item.components.item.category.game.eve.application.command.transfer.GameEveItemCategoryCreateReqCTransfer;
import org.endless.tianyan.item.components.item.category.game.eve.domain.anticorruption.GameEveItemCategoryRepository;
import org.endless.tianyan.item.components.item.category.game.eve.domain.entity.GameEveItemCategoryAggregate;
import org.endless.tianyan.item.components.item.category.item.category.application.command.transfer.ItemCategoryCreateReqCTransfer;
import org.endless.tianyan.item.components.item.category.item.category.facade.adapter.ItemCategoryDrivingAdapter;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * GameEveItemCategoryCommandHandlerImpl
 * <p>游戏EVE资源项分类领域命令处理器
 * <p>
 * create 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see GameEveItemCategoryCommandHandler
 * @since 0.0.1
 */
public class GameEveItemCategoryCommandHandlerImpl implements GameEveItemCategoryCommandHandler {

    /**
     * 游戏EVE资源项分类聚合仓储接口
     */
    private final GameEveItemCategoryRepository gameEveItemCategoryRepository;

    /**
     * 资源项分类主动适配器接口
     */
    private final ItemCategoryDrivingAdapter itemCategoryDrivingAdapter;

    public GameEveItemCategoryCommandHandlerImpl(GameEveItemCategoryRepository gameEveItemCategoryRepository, ItemCategoryDrivingAdapter itemCategoryDrivingAdapter) {
        this.gameEveItemCategoryRepository = gameEveItemCategoryRepository;
        this.itemCategoryDrivingAdapter = itemCategoryDrivingAdapter;
    }

    @Override
    @Transactional
    @Log(message = "游戏EVE资源项分类创建命令", value = "#command", level = LogLevel.TRACE)
    public void create(GameEveItemCategoryCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(GameEveItemCategoryCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("游戏EVE资源项分类创建命令参数不能为空"));
        String itemCategoryId = itemCategoryDrivingAdapter.create(ItemCategoryCreateReqCTransfer.builder()
                        .nameZh(command.getNameZh())
                        .nameEn(command.getNameEn())
                        .createUserId(command.getCreateUserId())
                        .build().validate())
                .validate().getItemCategoryId();
        GameEveItemCategoryAggregate aggregate = GameEveItemCategoryAggregate.create(GameEveItemCategoryAggregate.builder()
                .itemCategoryId(itemCategoryId)
                .code(command.getCode())
                .isPublished(command.getIsPublished())
                .createUserId(command.getCreateUserId()));
        gameEveItemCategoryRepository.save(aggregate);
    }
}
