package org.endless.tianyan.manufacturing.components.blueprint.blueprint.infrastructure.data.manager;

import org.endless.tianyan.manufacturing.common.model.infrastructure.data.manager.*;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.query.anticorruption.*;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.anticorruption.*;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.entity.*;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.infrastructure.data.persistence.mapper.*;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.manager.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
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
}
