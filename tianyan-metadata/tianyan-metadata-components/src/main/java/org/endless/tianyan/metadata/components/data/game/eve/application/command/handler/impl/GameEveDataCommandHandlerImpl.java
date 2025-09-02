package org.endless.tianyan.metadata.components.data.game.eve.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.metadata.components.data.game.eve.application.command.handler.GameEveDataCommandHandler;
import org.endless.tianyan.metadata.components.data.game.eve.application.command.transfer.GameEveDataLoadReqCReqTransfer;
import org.endless.tianyan.metadata.components.data.game.eve.domain.anticorruption.GameEveDataLoadDrivenAdapter;
import org.endless.tianyan.metadata.components.data.game.eve.domain.type.GameEveDataTypeEnum;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * GameEveDataCommandHandlerImpl
 * <p>游戏EVE数据领域命令处理器
 * <p>
 * create 2025/07/24 08:49
 * <p>
 * update 2025/07/24 08:49
 *
 * @author Deng Haozhi
 * @see GameEveDataCommandHandler
 * @since 0.0.1
 */
@Lazy
@Service
@Validated
public class GameEveDataCommandHandlerImpl implements GameEveDataCommandHandler {

    /**
     * 游戏EVE数据加载被动适配器接口
     */
    private final GameEveDataLoadDrivenAdapter gameEveDataLoadDrivenAdapter;

    public GameEveDataCommandHandlerImpl(GameEveDataLoadDrivenAdapter gameEveDataLoadDrivenAdapter) {
        this.gameEveDataLoadDrivenAdapter = gameEveDataLoadDrivenAdapter;
    }

    @Override
    @Transactional
    @Log(message = "游戏EVE数据加载命令", value = "#command", level = LogLevel.TRACE)
    public void load(GameEveDataLoadReqCReqTransfer command) {
        gameEveDataLoadDrivenAdapter.load(GameEveDataTypeEnum.fromCode(command.gameEveDataType()));
    }
}
