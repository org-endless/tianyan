package org.endless.tianyan.item.components.item.game.eve.category.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.item.components.item.game.eve.category.application.command.handler.GameEveItemCategoryCommandHandler;
import org.endless.tianyan.item.components.item.game.eve.category.application.command.transfer.GameEveItemCategoryCreateCReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.category.domain.anticorruption.GameEveItemCategoryRepository;
import org.endless.tianyan.item.components.item.game.eve.category.domain.entity.GameEveItemCategoryAggregate;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * GameEveItemCategoryCommandHandlerImpl
 * <p>游戏EVE资源项分类领域命令处理器
 * <p>
 * itemCreate 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see GameEveItemCategoryCommandHandler
 * @since 0.0.1
 */
@Lazy
@Service
@Validated
public class GameEveItemCategoryCommandHandlerImpl implements GameEveItemCategoryCommandHandler {

    /**
     * 游戏EVE资源项分类聚合仓储接口
     */
    private final GameEveItemCategoryRepository gameEveItemCategoryRepository;

    public GameEveItemCategoryCommandHandlerImpl(GameEveItemCategoryRepository gameEveItemCategoryRepository) {
        this.gameEveItemCategoryRepository = gameEveItemCategoryRepository;
    }

    @Override
    @Transactional
    @Log(message = "游戏EVE资源项分类创建命令", value = "#command", level = LogLevel.TRACE)
    public void create(GameEveItemCategoryCreateCReqTransfer command) {
        GameEveItemCategoryAggregate aggregate = GameEveItemCategoryAggregate.create(GameEveItemCategoryAggregate.builder()
                .itemCategoryId(command.itemCategoryId())
                .code(command.gameEveItemCategoryCode())
                .isPublished(command.isPublished())
                .createUserId(command.createUserId()));
        gameEveItemCategoryRepository.save(aggregate);
    }
}
