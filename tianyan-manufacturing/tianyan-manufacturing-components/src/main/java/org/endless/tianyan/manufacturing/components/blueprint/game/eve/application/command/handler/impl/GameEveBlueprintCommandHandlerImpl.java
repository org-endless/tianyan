package org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.command.handler.impl;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.transfer.BlueprintCreateReqCTransfer;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.transfer.BlueprintMaterialReqCTransfer;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.transfer.BlueprintProductReqCTransfer;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.transfer.BlueprintSkillReqCTransfer;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.facade.adapter.BlueprintDrivingAdapter;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.command.handler.GameEveBlueprintCommandHandler;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.command.transfer.GameEveBlueprintCreateReqCTransfer;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.domain.anticorruption.GameEveBlueprintRepository;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.domain.entity.GameEveBlueprintAggregate;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.domain.type.GameEveBlueprintTypeEnum;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Optional;

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
public class GameEveBlueprintCommandHandlerImpl implements GameEveBlueprintCommandHandler {

    /**
     * 游戏EVE蓝图聚合仓储接口
     */
    private final GameEveBlueprintRepository gameEveBlueprintRepository;

    /**
     * 蓝图主动适配器接口
     */
    private final BlueprintDrivingAdapter blueprintDrivingAdapter;

    public GameEveBlueprintCommandHandlerImpl(GameEveBlueprintRepository gameEveBlueprintRepository, BlueprintDrivingAdapter blueprintDrivingAdapter) {
        this.gameEveBlueprintRepository = gameEveBlueprintRepository;
        this.blueprintDrivingAdapter = blueprintDrivingAdapter;
    }

    @Override
    @Transactional
    @Log(message = "游戏EVE蓝图创建命令", value = "#command", level = LogLevel.TRACE)
    public void create(GameEveBlueprintCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(GameEveBlueprintCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("游戏EVE蓝图创建命令参数不能为空"));
        String blueprintId = blueprintDrivingAdapter.create(BlueprintCreateReqCTransfer.builder()
                        .itemId(command.getItemId())
                        .type(command.getType())
                        .materials(CollectionUtils.isEmpty(command.getMaterials()) ? null : command.getMaterials().stream()
                                .map(material -> BlueprintMaterialReqCTransfer.builder()
                                        .itemId(material.getItemId())
                                        .quantity(material.getQuantity())
                                        .build().validate())
                                .toList())
                        .createUserId(command.getCreateUserId())
                        .products(CollectionUtils.isEmpty(command.getProducts()) ? null : command.getProducts().stream()
                                .map(product -> BlueprintProductReqCTransfer.builder()
                                        .itemId(product.getItemId())
                                        .quantity(product.getQuantity())
                                        .build().validate())
                                .toList())
                        .skills(CollectionUtils.isEmpty(command.getSkills()) ? null : command.getSkills().stream()
                                .map(skill -> BlueprintSkillReqCTransfer.builder()
                                        .itemId(skill.getItemId())
                                        .level(skill.getLevel())
                                        .build().validate())
                                .toList())
                        .cycle(command.getCycle())
                        .createUserId(command.getCreateUserId())
                        .build().validate())
                .validate().getBlueprintId();
        GameEveBlueprintAggregate aggregate = GameEveBlueprintAggregate.create(GameEveBlueprintAggregate.builder()
                .blueprintId(blueprintId)
                .code(command.getCode())
                .type(GameEveBlueprintTypeEnum.fromCode(command.getType()))
                .maxProductionLimit(command.getMaxProductionLimit())
                .createUserId(command.getCreateUserId()));
        gameEveBlueprintRepository.save(aggregate);
    }
}
