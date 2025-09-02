package org.endless.tianyan.item.components.item.game.eve.group.application.query.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.query.handler.QueryNotFoundException;
import org.endless.tianyan.item.components.item.game.eve.group.application.query.anticorruption.GameEveItemGroupQueryRepository;
import org.endless.tianyan.item.components.item.game.eve.group.application.query.handler.GameEveItemGroupQueryHandler;
import org.endless.tianyan.item.components.item.game.eve.group.application.query.transfer.FindByGameEveItemGroupCodeQReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.group.application.query.transfer.FindItemGroupIdQRespTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * GameEveItemGroupQueryHandlerImpl
 * <p>游戏EVE资源项分组领域查询处理器
 * <p>
 * itemCreate 2025/07/21 16:03
 * <p>
 * update 2025/07/21 16:03
 *
 * @author Deng Haozhi
 * @see GameEveItemGroupQueryHandler
 * @since 0.0.1
 */
@Lazy
@Service
@Validated
public class GameEveItemGroupQueryHandlerImpl implements GameEveItemGroupQueryHandler {

    /**
     * 游戏EVE资源项分组聚合查询仓储接口
     */
    private final GameEveItemGroupQueryRepository gameEveItemGroupQueryRepository;

    public GameEveItemGroupQueryHandlerImpl(GameEveItemGroupQueryRepository gameEveItemGroupQueryRepository) {
        this.gameEveItemGroupQueryRepository = gameEveItemGroupQueryRepository;
    }

    @Override
    @Log(message = "根据游戏EVE资源项分组编码查询资源项分组ID", value = "#query", level = LogLevel.TRACE)
    public FindItemGroupIdQRespTransfer findItemGroupIdByCode(FindByGameEveItemGroupCodeQReqTransfer query) {
        return FindItemGroupIdQRespTransfer.builder()
                .itemGroupId(gameEveItemGroupQueryRepository.findItemGroupIdByCode(query.gameEveItemGroupCode())
                        .orElseThrow(() -> new QueryNotFoundException("资源项分组不存在")))
                .build();
    }
}
