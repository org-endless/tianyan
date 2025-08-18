package org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferNullException;
import org.endless.ddd.starter.common.utils.model.decimal.DecimalTools;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.handler.BlueprintCommandHandler;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.transfer.BlueprintCreateReqCTransfer;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.transfer.BlueprintCreateRespCTransfer;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.anticorruption.BlueprintRepository;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.entity.BlueprintAggregate;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.entity.BlueprintMaterialEntity;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.entity.BlueprintProductEntity;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.entity.BlueprintSkillEntity;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.type.BlueprintTypeEnum;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * BlueprintCommandHandlerImpl
 * <p>蓝图领域命令处理器
 * <p>
 * create 2025/07/23 17:17
 * <p>
 * update 2025/07/23 17:17
 *
 * @author Deng Haozhi
 * @see BlueprintCommandHandler
 * @since 0.0.1
 */
public class BlueprintCommandHandlerImpl implements BlueprintCommandHandler {

    /**
     * 蓝图聚合仓储接口
     */
    private final BlueprintRepository blueprintRepository;

    public BlueprintCommandHandlerImpl(BlueprintRepository blueprintRepository) {
        this.blueprintRepository = blueprintRepository;
    }

    @Override
    @Transactional
    @Log(message = "蓝图创建命令", value = "#command", level = LogLevel.TRACE)
    public BlueprintCreateRespCTransfer create(BlueprintCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(BlueprintCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("蓝图创建命令参数不能为空"));
        BlueprintAggregate aggregate = BlueprintAggregate.create(BlueprintAggregate.builder()
                .itemId(command.getItemId())
                .type(BlueprintTypeEnum.fromCode(command.getType()))
                .materials(command.getMaterials() == null ? null : command.getMaterials().stream()
                        .map(material -> BlueprintMaterialEntity.create(BlueprintMaterialEntity.builder()
                                .itemId(material.getItemId())
                                .quantity(material.getQuantity())
                                .createUserId(command.getCreateUserId())))
                        .toList())
                .products(command.getProducts() == null ? null : command.getProducts().stream()
                        .map(material -> BlueprintProductEntity.create(BlueprintProductEntity.builder()
                                .itemId(material.getItemId())
                                .quantity(material.getQuantity())
                                .successRate(material.getSuccessRate() == null ? new BigDecimal("1.00000") : DecimalTools.format5Bit(material.getSuccessRate()))
                                .createUserId(command.getCreateUserId())))
                        .toList())
                .skills(command.getSkills() == null ? null : command.getSkills().stream()
                        .map(material -> BlueprintSkillEntity.create(BlueprintSkillEntity.builder()
                                .itemId(material.getItemId())
                                .level(material.getLevel())
                                .createUserId(command.getCreateUserId())))
                        .toList())
                .cycle(command.getCycle())
                .createUserId(command.getCreateUserId()));
        blueprintRepository.save(aggregate);
        return BlueprintCreateRespCTransfer.builder()
                .blueprintId(aggregate.getBlueprintId())
                .build().validate();
    }
}
