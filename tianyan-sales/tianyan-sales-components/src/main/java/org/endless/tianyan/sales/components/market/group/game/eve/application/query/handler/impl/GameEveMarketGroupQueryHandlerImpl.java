package org.endless.tianyan.sales.components.market.group.game.eve.application.query.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.query.handler.QueryNotFoundException;
import org.endless.ddd.starter.common.exception.ddd.application.query.transfer.QueryReqTransferNullException;
import org.endless.tianyan.sales.components.market.group.game.eve.application.query.anticorruption.GameEveMarketGroupQueryRepository;
import org.endless.tianyan.sales.components.market.group.game.eve.application.query.handler.GameEveMarketGroupQueryHandler;
import org.endless.tianyan.sales.components.market.group.game.eve.application.query.transfer.GameEveMarketGroupFindByCodeReqQTransfer;
import org.endless.tianyan.sales.components.market.group.game.eve.application.query.transfer.GameEveMarketGroupFindIdRespQTransfer;

import java.util.Optional;

/**
 * GameEveMarketGroupQueryHandlerImpl
 * <p>游戏EVE市场分组领域查询处理器
 * <p>
 * create 2025/07/24 17:37
 * <p>
 * update 2025/07/24 17:37
 *
 * @author Deng Haozhi
 * @see GameEveMarketGroupQueryHandler
 * @since 0.0.1
 */
public class GameEveMarketGroupQueryHandlerImpl implements GameEveMarketGroupQueryHandler {

    /**
     * 游戏EVE市场分组聚合查询仓储接口
     */
    private final GameEveMarketGroupQueryRepository gameEveMarketGroupQueryRepository;

    public GameEveMarketGroupQueryHandlerImpl(GameEveMarketGroupQueryRepository gameEveMarketGroupQueryRepository) {
        this.gameEveMarketGroupQueryRepository = gameEveMarketGroupQueryRepository;
    }

    @Override
    @Log(message = "游戏EVE市场根据编码查询市场分组ID", value = "#query", level = LogLevel.TRACE)
    public GameEveMarketGroupFindIdRespQTransfer findMarketGroupIdByCode(GameEveMarketGroupFindByCodeReqQTransfer query) {
        Optional.ofNullable(query)
                .map(GameEveMarketGroupFindByCodeReqQTransfer::validate)
                .orElseThrow(() -> new QueryReqTransferNullException("游戏EVE市场根据编码查询市场分组ID参数不能为空"));
        return GameEveMarketGroupFindIdRespQTransfer.builder()
                .marketGroupId(gameEveMarketGroupQueryRepository.findMarketGroupIdByCode(query.getGameEveMarketGroupCode())
                        .orElseThrow(() -> new QueryNotFoundException("游戏EVE市场分组不存在")))
                .build().validate();
    }
}
