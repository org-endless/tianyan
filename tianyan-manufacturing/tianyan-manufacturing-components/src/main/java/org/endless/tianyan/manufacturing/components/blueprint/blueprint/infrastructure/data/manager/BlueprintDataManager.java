package org.endless.tianyan.manufacturing.components.blueprint.blueprint.infrastructure.data.manager;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.manager.DataManagerRequestNullException;
import org.endless.tianyan.manufacturing.common.model.infrastructure.data.manager.TianyanManufacturingAggregateDataManager;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.query.anticorruption.BlueprintQueryRepository;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.anticorruption.BlueprintRepository;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.entity.BlueprintAggregate;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.infrastructure.data.persistence.mapper.BlueprintMapper;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.infrastructure.data.persistence.mapper.BlueprintMaterialMapper;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.infrastructure.data.persistence.mapper.BlueprintProductMapper;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.infrastructure.data.persistence.mapper.BlueprintSkillMapper;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.infrastructure.data.record.BlueprintRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Optional;

/**
 * BlueprintDataManager
 * <p>蓝图聚合数据管理器
 * <p>
 * create 2025/07/23 17:17
 * <p>
 * update 2025/07/23 17:17
 *
 * @author Deng Haozhi
 * @see BlueprintRepository
 * @see BlueprintQueryRepository
 * @see TianyanManufacturingAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class BlueprintDataManager implements BlueprintRepository, BlueprintQueryRepository, TianyanManufacturingAggregateDataManager<BlueprintRecord, BlueprintAggregate> {

    /**
     * 蓝图聚合 Mybatis-Plus 数据访问对象
     */
    private final BlueprintMapper blueprintMapper;

    /**
     * 蓝图物料实体 Mybatis-Plus 数据访问对象
     */
    private final BlueprintMaterialMapper blueprintMaterialMapper;

    /**
     * 蓝图产品实体 Mybatis-Plus 数据访问对象
     */
    private final BlueprintProductMapper blueprintProductMapper;

    /**
     * 蓝图技能实体 Mybatis-Plus 数据访问对象
     */
    private final BlueprintSkillMapper blueprintSkillMapper;

    public BlueprintDataManager(BlueprintMapper blueprintMapper, BlueprintMaterialMapper blueprintMaterialMapper, BlueprintProductMapper blueprintProductMapper, BlueprintSkillMapper blueprintSkillMapper) {
        this.blueprintMapper = blueprintMapper;
        this.blueprintMaterialMapper = blueprintMaterialMapper;
        this.blueprintProductMapper = blueprintProductMapper;
        this.blueprintSkillMapper = blueprintSkillMapper;
    }

    @Override
    @Log(message = "保存蓝图聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public BlueprintAggregate save(BlueprintAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .map(BlueprintAggregate::validate)
                .orElseThrow(() -> new DataManagerRequestNullException("保存蓝图聚合数据不能为空"));
        BlueprintRecord record = BlueprintRecord.from(aggregate);
        blueprintMapper.save(BlueprintRecord.from(aggregate));
        Optional.ofNullable(record.getMaterials())
                .filter(l -> !CollectionUtils.isEmpty(l))
                .ifPresent(blueprintMaterialMapper::save);
        Optional.ofNullable(record.getProducts())
                .filter(l -> !CollectionUtils.isEmpty(l))
                .ifPresent(blueprintProductMapper::save);
        Optional.ofNullable(record.getSkills())
                .filter(l -> !CollectionUtils.isEmpty(l))
                .ifPresent(blueprintSkillMapper::save);
        return aggregate;
    }

    @Override
    public void remove(BlueprintAggregate aggregate) {

    }

    @Override
    public BlueprintAggregate modify(BlueprintAggregate aggregate) {
        return null;
    }

    @Override
    public Optional<BlueprintAggregate> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<BlueprintAggregate> findByIdForUpdate(String s) {
        return Optional.empty();
    }
}
