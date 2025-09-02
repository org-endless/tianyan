package org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.command.handler.GameEveBlueprintCommandHandler;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.command.transfer.GameEveBlueprintCreateCReqTransfer;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.domain.anticorruption.GameEveBlueprintRepository;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.domain.entity.GameEveBlueprintAggregate;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * GameEveBlueprintCommandHandlerImpl
 * <p>游戏EVE蓝图领域命令处理器
 * <p>
 * create 2025/07/24 09:18
 * <p>
 * update 2025/07/24 09:18
 *
 * @author Deng Haozhi
 * @see GameEveBlueprintCommandHandler
 * @since 0.0.1
 */
@Lazy
@Service
@Validated
public class GameEveBlueprintCommandHandlerImpl implements GameEveBlueprintCommandHandler {

    /**
     * 游戏EVE蓝图聚合仓储接口
     */
    private final GameEveBlueprintRepository gameEveBlueprintRepository;

    public GameEveBlueprintCommandHandlerImpl(GameEveBlueprintRepository gameEveBlueprintRepository) {
        this.gameEveBlueprintRepository = gameEveBlueprintRepository;
    }

    @Override
    @Transactional
    @Log(message = "游戏EVE蓝图创建命令", value = "#command", level = LogLevel.TRACE)
    public void create(GameEveBlueprintCreateCReqTransfer command) {
        GameEveBlueprintAggregate aggregate = GameEveBlueprintAggregate.create(GameEveBlueprintAggregate.builder()
                .blueprintId(command.blueprintId())
                .code(command.gameEveBlueprintItemCode())
                .maxProductionLimit(command.maxProductionLimit())
                .createUserId(command.createUserId()));
        gameEveBlueprintRepository.save(aggregate);
    }
}
