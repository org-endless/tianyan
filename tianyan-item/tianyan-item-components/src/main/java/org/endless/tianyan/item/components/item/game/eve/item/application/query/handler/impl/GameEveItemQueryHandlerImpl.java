package org.endless.tianyan.item.components.item.game.eve.item.application.query.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.query.handler.QueryNotFoundException;
import org.endless.tianyan.item.components.item.game.eve.item.application.query.anticorruption.GameEveItemQueryRepository;
import org.endless.tianyan.item.components.item.game.eve.item.application.query.handler.GameEveItemQueryHandler;
import org.endless.tianyan.item.components.item.game.eve.item.application.query.transfer.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

/**
 * GameEveItemQueryHandlerImpl
 * <p>游戏EVE资源项领域查询处理器
 * <p>
 * itemCreate 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see GameEveItemQueryHandler
 * @since 0.0.1
 */
@Lazy
@Service
@Validated
public class GameEveItemQueryHandlerImpl implements GameEveItemQueryHandler {

    /**
     * 游戏EVE资源项聚合查询仓储接口
     */
    private final GameEveItemQueryRepository gameEveItemQueryRepository;

    public GameEveItemQueryHandlerImpl(GameEveItemQueryRepository gameEveItemQueryRepository) {
        this.gameEveItemQueryRepository = gameEveItemQueryRepository;
    }

    @Override
    @Log(message = "根据游戏EVE资源项编码查询资源项ID", value = "#query", level = LogLevel.TRACE)
    public FindItemIdQRespTransfer findItemIdByCode(FindByGameEveItemCodeQReqTransfer query) {
        return FindItemIdQRespTransfer.builder()
                .itemId(gameEveItemQueryRepository.findItemIdByCode(query.gameEveItemCode())
                        .orElseThrow(() -> new QueryNotFoundException("游戏EVE资源项不存在，编码:" + query.gameEveItemCode())))
                .build();
    }

    @Override
    @Log(message = "根据游戏EVE资源项编码列表查询资源项ID列表", value = "#query", level = LogLevel.TRACE)
    public FindItemIdsQRespTransfer findItemIdsByCodes(FindByGameEveItemCodesQReqTransfer query) {
        return FindItemIdsQRespTransfer.builder()
                .itemIds(Optional.ofNullable(gameEveItemQueryRepository.findItemIdsByCodes(query.gameEveItemCodes()))
                        .filter(l -> !CollectionUtils.isEmpty(l))
                        .orElseThrow(() -> new QueryNotFoundException("游戏EVE资源项不存在")))
                .build();
    }

    @Override
    @Log(message = "根据资源项ID查询游戏EVE资源项编码", value = "#query", level = LogLevel.TRACE)
    public FindGameEveItemCodeQRespTransfer findCodeByItemId(FindByItemIdQReqTransfer query) {
        return FindGameEveItemCodeQRespTransfer.builder()
                .gameEveItemCode(gameEveItemQueryRepository.findCodeByItemId(query.itemId())
                        .orElseThrow(() -> new QueryNotFoundException("游戏EVE资源项不存在，资源项ID: " + query.itemId())))
                .build();
    }
}
