package org.endless.tianyan.item.components.item.group.game.eve.application.query.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.query.handler.QueryNotFoundException;
import org.endless.ddd.starter.common.exception.ddd.application.query.transfer.QueryReqTransferNullException;
import org.endless.tianyan.item.components.item.group.game.eve.application.query.anticorruption.GameEveItemGroupQueryRepository;
import org.endless.tianyan.item.components.item.group.game.eve.application.query.handler.GameEveItemGroupQueryHandler;
import org.endless.tianyan.item.components.item.group.game.eve.application.query.transfer.GameEveItemGroupFindByCodeReqQReqTransfer;
import org.endless.tianyan.item.components.item.group.game.eve.application.query.transfer.GameEveItemGroupFindIdRespQReqTransfer;

import java.util.Optional;

/**
 * GameEveItemGroupQueryHandlerImpl
 * <p>游戏EVE资源项分组领域查询处理器
 * <p>
 * create 2025/07/21 16:03
 * <p>
 * update 2025/07/21 16:03
 *
 * @author Deng Haozhi
 * @see GameEveItemGroupQueryHandler
 * @since 0.0.1
 */
public class GameEveItemGroupQueryHandlerImpl implements GameEveItemGroupQueryHandler {

    /**
     * 游戏EVE资源项分组聚合查询仓储接口
     */
    private final GameEveItemGroupQueryRepository gameEveItemGroupQueryRepository;

    public GameEveItemGroupQueryHandlerImpl(GameEveItemGroupQueryRepository gameEveItemGroupQueryRepository) {
        this.gameEveItemGroupQueryRepository = gameEveItemGroupQueryRepository;
    }

    @Override
    @Log(message = "根据编码查询资源项分组ID", value = "#command", level = LogLevel.TRACE)
    public GameEveItemGroupFindIdRespQReqTransfer findItemGroupIdByCode(GameEveItemGroupFindByCodeReqQReqTransfer query) {
        Optional.ofNullable(query)
                .map(GameEveItemGroupFindByCodeReqQReqTransfer::validate)
                .orElseThrow(() -> new QueryReqTransferNullException("根据编码查询资源项分组ID参数不能为空"));
        return GameEveItemGroupFindIdRespQReqTransfer.builder()
                .itemGroupId(gameEveItemGroupQueryRepository.findItemGroupIdByCode(query.getGameEveItemGroupCode())
                        .orElseThrow(() -> new QueryNotFoundException("资源项分组不存在")))
                .build().validate();
    }
}
