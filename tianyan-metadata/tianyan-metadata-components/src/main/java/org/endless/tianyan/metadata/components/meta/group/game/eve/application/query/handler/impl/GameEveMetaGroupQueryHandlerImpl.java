package org.endless.tianyan.metadata.components.meta.group.game.eve.application.query.handler.impl;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.handler.QueryHandlerNotFoundException;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.transfer.QueryReqTransferNullException;
import org.endless.tianyan.metadata.components.meta.group.game.eve.application.query.anticorruption.GameEveMetaGroupQueryRepository;
import org.endless.tianyan.metadata.components.meta.group.game.eve.application.query.handler.GameEveMetaGroupQueryHandler;
import org.endless.tianyan.metadata.components.meta.group.game.eve.application.query.transfer.GameEveMetaGroupFindByCodeReqQTransfer;
import org.endless.tianyan.metadata.components.meta.group.game.eve.application.query.transfer.GameEveMetaGroupFindMetaGroupIdRespQTransfer;

import java.util.Optional;

/**
 * GameEveMetaGroupQueryHandlerImpl
 * <p>游戏EVE元分组领域查询处理器
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see GameEveMetaGroupQueryHandler
 * @since 0.0.1
 */
public class GameEveMetaGroupQueryHandlerImpl implements GameEveMetaGroupQueryHandler {

    /**
     * 游戏EVE元分组聚合查询仓储接口
     */
    private final GameEveMetaGroupQueryRepository gameEveMetaGroupQueryRepository;

    public GameEveMetaGroupQueryHandlerImpl(GameEveMetaGroupQueryRepository gameEveMetaGroupQueryRepository) {
        this.gameEveMetaGroupQueryRepository = gameEveMetaGroupQueryRepository;
    }

    @Override
    @Log(message = "游戏EVE元分组根据编码查询元分组ID", value = "#command", level = LogLevel.TRACE)
    public GameEveMetaGroupFindMetaGroupIdRespQTransfer findMetaGroupIdByCode(GameEveMetaGroupFindByCodeReqQTransfer query) {
        Optional.ofNullable(query)
                .map(GameEveMetaGroupFindByCodeReqQTransfer::validate)
                .orElseThrow(() -> new QueryReqTransferNullException("游戏EVE元分组根据编码查询元分组ID参数不能为空"));
        return GameEveMetaGroupFindMetaGroupIdRespQTransfer.builder()
                .metaGroupId(gameEveMetaGroupQueryRepository.findMetaGroupIdByCode(query.getCode())
                        .orElseThrow(() -> new QueryHandlerNotFoundException("元分组ID未找到")))
                .build().validate();
    }
}
