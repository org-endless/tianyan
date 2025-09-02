package org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.utils.model.decimal.DecimalTools;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.handler.BlueprintCommandHandler;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.transfer.BlueprintCreateReqCReqTransfer;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.transfer.BlueprintCreateRespCReqTransfer;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.anticorruption.BlueprintRepository;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.entity.BlueprintAggregate;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.entity.BlueprintMaterialEntity;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.entity.BlueprintProductEntity;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.entity.BlueprintSkillEntity;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.type.BlueprintTypeEnum;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

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
@Lazy
@Service
@Validated
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
    public BlueprintCreateRespCReqTransfer create(BlueprintCreateReqCReqTransfer command) {
        BlueprintAggregate aggregate = BlueprintAggregate.create(BlueprintAggregate.builder()
                .itemId(command.itemId())
                .type(BlueprintTypeEnum.fromCode(command.type()))
                .materials(command.materials() == null ? null : command.materials().stream()
                        .map(material -> BlueprintMaterialEntity.create(BlueprintMaterialEntity.builder()
                                .itemId(material.getItemId())
                                .quantity(material.getQuantity())
                                .createUserId(command.createUserId())))
                        .toList())
                .products(command.products() == null ? null : command.products().stream()
                        .map(material -> BlueprintProductEntity.create(BlueprintProductEntity.builder()
                                .itemId(material.getItemId())
                                .quantity(material.getQuantity())
                                .successRate(material.getSuccessRate() == null ? new BigDecimal("1.00000") : DecimalTools.format5Bit(material.getSuccessRate()))
                                .createUserId(command.createUserId())))
                        .toList())
                .skills(command.skills() == null ? null : command.skills().stream()
                        .map(material -> BlueprintSkillEntity.create(BlueprintSkillEntity.builder()
                                .itemId(material.getItemId())
                                .level(material.getLevel())
                                .createUserId(command.createUserId())))
                        .toList())
                .cycle(command.cycle())
                .createUserId(command.createUserId()));
        blueprintRepository.save(aggregate);
        return BlueprintCreateRespCReqTransfer.builder()
                .blueprintId(aggregate.getBlueprintId())
                .build().validate();
    }
}
