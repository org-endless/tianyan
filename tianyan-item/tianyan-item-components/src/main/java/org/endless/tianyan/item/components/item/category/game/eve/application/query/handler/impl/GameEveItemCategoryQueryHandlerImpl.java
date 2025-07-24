package org.endless.tianyan.item.components.item.category.game.eve.application.query.handler.impl;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.CommandReqTransferNullException;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.handler.QueryHandlerNotFoundException;
import org.endless.tianyan.item.components.item.category.game.eve.application.query.anticorruption.GameEveItemCategoryQueryRepository;
import org.endless.tianyan.item.components.item.category.game.eve.application.query.handler.GameEveItemCategoryQueryHandler;
import org.endless.tianyan.item.components.item.category.game.eve.application.query.transfer.GameEveItemCategoryFindByCodeReqQTransfer;
import org.endless.tianyan.item.components.item.category.game.eve.application.query.transfer.GameEveItemCategoryFindIdRespQTransfer;

import java.util.Optional;

/**
 * GameEveItemCategoryQueryHandlerImpl
 * <p>游戏EVE资源项分类领域查询处理器
 * <p>
 * create 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see GameEveItemCategoryQueryHandler
 * @since 0.0.1
 */
public class GameEveItemCategoryQueryHandlerImpl implements GameEveItemCategoryQueryHandler {

    /**
     * 游戏EVE资源项分类聚合查询仓储接口
     */
    private final GameEveItemCategoryQueryRepository gameEveItemCategoryQueryRepository;

    public GameEveItemCategoryQueryHandlerImpl(GameEveItemCategoryQueryRepository gameEveItemCategoryQueryRepository) {
        this.gameEveItemCategoryQueryRepository = gameEveItemCategoryQueryRepository;
    }

    @Override
    @Log(message = "游戏EVE资源项分类根据编码查询ID", value = "#command", level = LogLevel.TRACE)
    public GameEveItemCategoryFindIdRespQTransfer findItemCategoryIdByCode(GameEveItemCategoryFindByCodeReqQTransfer query) {
        Optional.ofNullable(query)
                .map(GameEveItemCategoryFindByCodeReqQTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("游戏EVE资源项分类根据编码查询ID参数不能为空"));
        return GameEveItemCategoryFindIdRespQTransfer.builder()
                .itemCategoryId(gameEveItemCategoryQueryRepository.findItemCategoryIdByCode(query.getCode())
                        .orElseThrow(() -> new QueryHandlerNotFoundException("游戏EVE资源项分类不存在")))
                .build().validate();
    }
}
