package org.endless.tianyan.metadata.components.metagroup.game.eve.application.query.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.query.handler.QueryNotFoundException;
import org.endless.tianyan.metadata.components.metagroup.game.eve.application.query.anticorruption.GameEveMetagroupQueryRepository;
import org.endless.tianyan.metadata.components.metagroup.game.eve.application.query.handler.GameEveMetagroupQueryHandler;
import org.endless.tianyan.metadata.components.metagroup.game.eve.application.query.transfer.FindByGameEveMetagroupCodeQReqTransfer;
import org.endless.tianyan.metadata.components.metagroup.game.eve.application.query.transfer.FindMetagroupIdQRespTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * GameEveMetagroupQueryHandlerImpl
 * <p>游戏EVE元分组领域查询处理器
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see GameEveMetagroupQueryHandler
 * @since 0.0.1
 */
@Lazy
@Service
@Validated
public class GameEveMetagroupQueryHandlerImpl implements GameEveMetagroupQueryHandler {

    /**
     * 游戏EVE元分组聚合查询仓储接口
     */
    private final GameEveMetagroupQueryRepository gameEveMetagroupQueryRepository;

    public GameEveMetagroupQueryHandlerImpl(GameEveMetagroupQueryRepository gameEveMetagroupQueryRepository) {
        this.gameEveMetagroupQueryRepository = gameEveMetagroupQueryRepository;
    }

    @Override
    @Log(message = "根据游戏EVE元分组编码查询元分组ID", value = "#command", level = LogLevel.TRACE)
    public FindMetagroupIdQRespTransfer findMetagroupIdByCode(FindByGameEveMetagroupCodeQReqTransfer query) {
        return FindMetagroupIdQRespTransfer.builder()
                .metagroupId(gameEveMetagroupQueryRepository.findMetagroupIdByCode(query.gameEveMetagroupCode())
                        .orElseThrow(() -> new QueryNotFoundException("元分组ID未找到")))
                .build().validate();
    }
}
