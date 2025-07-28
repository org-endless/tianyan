package org.endless.tianyan.item.components.item.game.eve.application.query.handler.impl;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.handler.QueryHandlerNotFoundException;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.transfer.QueryReqTransferNullException;
import org.endless.tianyan.item.components.item.game.eve.application.query.anticorruption.GameEveItemQueryRepository;
import org.endless.tianyan.item.components.item.game.eve.application.query.handler.GameEveItemQueryHandler;
import org.endless.tianyan.item.components.item.game.eve.application.query.transfer.*;
import org.springframework.util.CollectionUtils;

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
    @Log(message = "游戏EVE根据资源项编码查询资源项ID", value = "#query", level = LogLevel.TRACE)
    public GameEveItemFindItemIdRespQTransfer findItemIdByCode(GameEveItemFindByCodeReqQTransfer query) {
        Optional.ofNullable(query)
                .map(GameEveItemFindByCodeReqQTransfer::validate)
                .orElseThrow(() -> new QueryReqTransferNullException("游戏EVE资源项根据编码查询资源项ID参数不能为空"));
        return GameEveItemFindItemIdRespQTransfer.builder()
                .itemId(gameEveItemQueryRepository.findItemIdByCode(query.getGameEveItemCode())
                        .orElseThrow(() -> new QueryHandlerNotFoundException("游戏EVE资源项不存在，编码:" + query.getGameEveItemCode())))
                .build().validate();
    }

    @Override
    @Log(message = "游戏EVE根据资源项编码列表查询资源项ID列表", value = "#query", level = LogLevel.TRACE)
    public GameEveItemFindItemIdsRespQTransfer findItemIdsByCodes(GameEveItemFindByCodesReqQTransfer query) {
        Optional.ofNullable(query)
                .map(GameEveItemFindByCodesReqQTransfer::validate)
                .orElseThrow(() -> new QueryReqTransferNullException("游戏EVE资源项根据资源项ID查询编码参数不能为空"));
        return GameEveItemFindItemIdsRespQTransfer.builder()
                .itemIds(Optional.ofNullable(gameEveItemQueryRepository.findItemIdsByCodes(query.getGameEveItemCodes()))
                        .filter(l -> !CollectionUtils.isEmpty(l))
                        .orElseThrow(() -> new QueryHandlerNotFoundException("游戏EVE资源项不存在")))
                .build().validate();
    }

    @Override
    @Log(message = "游戏EVE根据资源项资源项ID查询编码", value = "#query", level = LogLevel.TRACE)
    public GameEveItemFindCodeRespQTransfer findCodeByItemId(GameEveItemFindByItemIdReqQTransfer query) {
        return GameEveItemFindCodeRespQTransfer.builder()
                .gameEveItemCode(gameEveItemQueryRepository.findCodeByItemId(query.getItemId())
                        .orElseThrow(() -> new QueryHandlerNotFoundException("游戏EVE资源项不存在，资源项ID: " + query.getItemId())))
                .build().validate();
    }
}
