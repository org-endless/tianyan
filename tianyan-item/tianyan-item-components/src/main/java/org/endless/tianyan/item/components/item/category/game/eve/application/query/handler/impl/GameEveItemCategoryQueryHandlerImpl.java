package org.endless.tianyan.item.components.item.category.game.eve.application.query.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferNullException;
import org.endless.ddd.starter.common.exception.ddd.application.query.handler.QueryNotFoundException;
import org.endless.tianyan.item.components.item.category.game.eve.application.query.anticorruption.GameEveItemCategoryQueryRepository;
import org.endless.tianyan.item.components.item.category.game.eve.application.query.handler.GameEveItemCategoryQueryHandler;
import org.endless.tianyan.item.components.item.category.game.eve.application.query.transfer.GameEveItemCategoryFindByCodeReqQReqTransfer;
import org.endless.tianyan.item.components.item.category.game.eve.application.query.transfer.GameEveItemCategoryFindIdRespQReqTransfer;

import java.util.Optional;

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
    public GameEveItemCategoryFindIdRespQReqTransfer findItemCategoryIdByCode(GameEveItemCategoryFindByCodeReqQReqTransfer query) {
        Optional.ofNullable(query)
                .map(GameEveItemCategoryFindByCodeReqQReqTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("游戏EVE资源项分类根据编码查询ID参数不能为空"));
        return GameEveItemCategoryFindIdRespQReqTransfer.builder()
                .itemCategoryId(gameEveItemCategoryQueryRepository.findItemCategoryIdByCode(query.getGameEveItemCategoryCode())
                        .orElseThrow(() -> new QueryNotFoundException("游戏EVE资源项分类不存在")))
                .build().validate();
    }
}
