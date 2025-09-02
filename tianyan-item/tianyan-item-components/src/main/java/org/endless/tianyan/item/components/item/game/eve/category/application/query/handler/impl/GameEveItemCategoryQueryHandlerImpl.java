package org.endless.tianyan.item.components.item.game.eve.category.application.query.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.query.handler.QueryNotFoundException;
import org.endless.tianyan.item.components.item.game.eve.category.application.query.anticorruption.GameEveItemCategoryQueryRepository;
import org.endless.tianyan.item.components.item.game.eve.category.application.query.handler.GameEveItemCategoryQueryHandler;
import org.endless.tianyan.item.components.item.game.eve.category.application.query.transfer.FindByGameEveItemCategoryCodeQReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.category.application.query.transfer.FindItemCategoryIdQRespTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * GameEveItemCategoryQueryHandlerImpl
 * <p>游戏EVE资源项分类领域查询处理器
 * <p>
 * itemCreate 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see GameEveItemCategoryQueryHandler
 * @since 0.0.1
 */
@Lazy
@Service
@Validated
public class GameEveItemCategoryQueryHandlerImpl implements GameEveItemCategoryQueryHandler {

    /**
     * 游戏EVE资源项分类聚合查询仓储接口
     */
    private final GameEveItemCategoryQueryRepository gameEveItemCategoryQueryRepository;

    public GameEveItemCategoryQueryHandlerImpl(GameEveItemCategoryQueryRepository gameEveItemCategoryQueryRepository) {
        this.gameEveItemCategoryQueryRepository = gameEveItemCategoryQueryRepository;
    }

    @Override
    @Log(message = "游戏EVE资源项分类根据编码查询ID", value = "#query", level = LogLevel.TRACE)
    public FindItemCategoryIdQRespTransfer findItemCategoryIdByCode(FindByGameEveItemCategoryCodeQReqTransfer query) {
        return FindItemCategoryIdQRespTransfer.builder()
                .itemCategoryId(gameEveItemCategoryQueryRepository.findItemCategoryIdByCode(query.gameEveItemCategoryCode())
                        .orElseThrow(() -> new QueryNotFoundException("游戏EVE资源项分类不存在")))
                .build();
    }
}
