package org.endless.tianyan.item.components.item.game.eve.application.query.handler.impl;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.handler.QueryHandlerNotFoundException;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.transfer.QueryReqTransferNullException;
import org.endless.tianyan.item.components.item.game.eve.application.query.anticorruption.GameEveItemQueryRepository;
import org.endless.tianyan.item.components.item.game.eve.application.query.handler.GameEveItemQueryHandler;
import org.endless.tianyan.item.components.item.game.eve.application.query.transfer.GameEveItemFindByCodeReqQTransfer;
import org.endless.tianyan.item.components.item.game.eve.application.query.transfer.GameEveItemFindItemIdRespQTransfer;

import java.util.Optional;

/**
 * GameEveItemQueryHandlerImpl
 * <p>游戏EVE资源项领域查询处理器
 * <p>
 * create 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see GameEveItemQueryHandler
 * @since 0.0.1
 */
public class GameEveItemQueryHandlerImpl implements GameEveItemQueryHandler {

    /**
     * 游戏EVE资源项聚合查询仓储接口
     */
    private final GameEveItemQueryRepository gameEveItemQueryRepository;

    public GameEveItemQueryHandlerImpl(GameEveItemQueryRepository gameEveItemQueryRepository) {
        this.gameEveItemQueryRepository = gameEveItemQueryRepository;
    }

    @Override
    @Log(message = "游戏EVE资源项根据编码查询资源项ID", value = "#command", level = LogLevel.TRACE)
    public GameEveItemFindItemIdRespQTransfer findItemIdByCode(GameEveItemFindByCodeReqQTransfer query) {
        Optional.ofNullable(query)
                .map(GameEveItemFindByCodeReqQTransfer::validate)
                .orElseThrow(() -> new QueryReqTransferNullException("游戏EVE资源项根据编码查询资源项ID参数不能为空"));
        return GameEveItemFindItemIdRespQTransfer.builder()
                .itemId(gameEveItemQueryRepository.findItemIdByCode(query.getCode())
                        .orElseThrow(() -> new QueryHandlerNotFoundException("游戏EVE资源项不存在")))
                .build().validate();
    }
}
