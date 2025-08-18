package org.endless.tianyan.item.components.item.game.eve.application.query.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.query.handler.QueryNotFoundException;
import org.endless.ddd.starter.common.exception.ddd.application.query.transfer.QueryReqTransferNullException;
import org.endless.tianyan.item.components.item.game.eve.application.query.anticorruption.GameEveItemQueryRepository;
import org.endless.tianyan.item.components.item.game.eve.application.query.handler.GameEveItemQueryHandler;
import org.endless.tianyan.item.components.item.game.eve.application.query.transfer.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
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
@Lazy
@Service
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
    public GameEveItemFindItemIdRespQReqTransfer findItemIdByCode(GameEveItemFindByCodeReqQReqTransfer query) {
        Optional.ofNullable(query)
                .map(GameEveItemFindByCodeReqQReqTransfer::validate)
                .orElseThrow(() -> new QueryReqTransferNullException("游戏EVE资源项根据编码查询资源项ID参数不能为空"));
        return GameEveItemFindItemIdRespQReqTransfer.builder()
                .itemId(gameEveItemQueryRepository.findItemIdByCode(query.getGameEveItemCode())
                        .orElseThrow(() -> new QueryNotFoundException("游戏EVE资源项不存在，编码:" + query.getGameEveItemCode())))
                .build().validate();
    }

    @Override
    @Log(message = "游戏EVE根据资源项编码列表查询资源项ID列表", value = "#query", level = LogLevel.TRACE)
    public GameEveItemFindItemIdsRespQReqTransfer findItemIdsByCodes(GameEveItemFindByCodesReqQReqTransfer query) {
        Optional.ofNullable(query)
                .map(GameEveItemFindByCodesReqQReqTransfer::validate)
                .orElseThrow(() -> new QueryReqTransferNullException("游戏EVE资源项根据资源项ID查询编码参数不能为空"));
        return GameEveItemFindItemIdsRespQReqTransfer.builder()
                .itemIds(Optional.ofNullable(gameEveItemQueryRepository.findItemIdsByCodes(query.getGameEveItemCodes()))
                        .filter(l -> !CollectionUtils.isEmpty(l))
                        .orElseThrow(() -> new QueryNotFoundException("游戏EVE资源项不存在")))
                .build().validate();
    }

    @Override
    @Log(message = "游戏EVE根据资源项资源项ID查询编码", value = "#query", level = LogLevel.TRACE)
    public GameEveItemFindCodeRespQReqTransfer findCodeByItemId(GameEveItemFindByItemIdReqQReqTransfer query) {
        return GameEveItemFindCodeRespQReqTransfer.builder()
                .gameEveItemCode(gameEveItemQueryRepository.findCodeByItemId(query.getItemId())
                        .orElseThrow(() -> new QueryNotFoundException("游戏EVE资源项不存在，资源项ID: " + query.getItemId())))
                .build().validate();
    }
}
