package org.endless.tianyan.manufacturing.components.blueprint.blueprint.infrastructure.data.manager;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.manager.DataManagerSaveFailedException;
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
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

/**
 * BlueprintDataManager
 * <p>蓝图聚合根数据管理器
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
@Validated
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
    @Log(message = "保存蓝图聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void save(BlueprintAggregate aggregate) {
        BlueprintRecord dataRecord = BlueprintRecord.from(aggregate);
        blueprintMapper.save(BlueprintRecord.from(aggregate));
        if (!CollectionUtils.isEmpty(dataRecord.getMaterials())) {
            blueprintMaterialMapper.save(dataRecord.getMaterials());
        }
        if (!CollectionUtils.isEmpty(dataRecord.getProducts())) {
            blueprintProductMapper.save(dataRecord.getProducts());
        } else {
            throw new DataManagerSaveFailedException("蓝图产品列表不能为空");
        }
        if (!CollectionUtils.isEmpty(dataRecord.getSkills())) {
            blueprintSkillMapper.save(dataRecord.getSkills());
        }
    }

    @Override
    public void remove(BlueprintAggregate aggregate) {

    }

    @Override
    public void modify(BlueprintAggregate aggregate) {
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
