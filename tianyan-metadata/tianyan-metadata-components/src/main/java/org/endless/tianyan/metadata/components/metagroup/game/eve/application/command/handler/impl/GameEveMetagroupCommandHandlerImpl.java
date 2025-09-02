package org.endless.tianyan.metadata.components.metagroup.game.eve.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.metadata.components.metagroup.game.eve.application.command.handler.GameEveMetagroupCommandHandler;
import org.endless.tianyan.metadata.components.metagroup.game.eve.application.command.transfer.GameEveMetagroupCreateCReqTransfer;
import org.endless.tianyan.metadata.components.metagroup.game.eve.domain.anticorruption.GameEveMetagroupRepository;
import org.endless.tianyan.metadata.components.metagroup.game.eve.domain.entity.GameEveMetagroupAggregate;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * GameEveMetagroupCommandHandlerImpl
 * <p>游戏EVE元分组领域命令处理器
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see GameEveMetagroupCommandHandler
 * @since 0.0.1
 */
@Lazy
@Service
@Validated
public class GameEveMetagroupCommandHandlerImpl implements GameEveMetagroupCommandHandler {

    /**
     * 游戏EVE元分组聚合仓储接口
     */
    private final GameEveMetagroupRepository gameEveMetagroupRepository;

    public GameEveMetagroupCommandHandlerImpl(GameEveMetagroupRepository gameEveMetagroupRepository) {
        this.gameEveMetagroupRepository = gameEveMetagroupRepository;
    }

    @Override
    @Log(message = "游戏EVE元分组创建命令", value = "#command", level = LogLevel.TRACE)
    public void create(GameEveMetagroupCreateCReqTransfer command) {
        GameEveMetagroupAggregate aggregate = GameEveMetagroupAggregate.create(GameEveMetagroupAggregate.builder()
                .metagroupId(command.metagroupId())
                .code(command.gameEveMetagroupCode())
                .createUserId(command.createUserId()));
        gameEveMetagroupRepository.save(aggregate);
    }
}
