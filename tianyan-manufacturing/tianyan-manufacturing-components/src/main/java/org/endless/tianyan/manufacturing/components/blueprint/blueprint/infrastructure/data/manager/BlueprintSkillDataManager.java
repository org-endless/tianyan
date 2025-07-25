package org.endless.tianyan.manufacturing.components.blueprint.blueprint.infrastructure.data.manager;

import org.endless.tianyan.manufacturing.common.model.infrastructure.data.manager.TianyanManufacturingEntityDataManager;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.query.anticorruption.BlueprintSkillQueryRepository;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.entity.BlueprintSkillEntity;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.infrastructure.data.persistence.mapper.BlueprintSkillMapper;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.infrastructure.data.record.BlueprintSkillRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * BlueprintSkillDataManager
 * <p>蓝图技能实体数据管理器
 * <p>
 * create 2025/07/23 17:17
 * <p>
 * update 2025/07/23 17:17
 *
 * @author Deng Haozhi
 * @see BlueprintSkillQueryRepository
 * @see TianyanManufacturingEntityDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class BlueprintSkillDataManager implements BlueprintSkillQueryRepository, TianyanManufacturingEntityDataManager<BlueprintSkillRecord, BlueprintSkillEntity> {

    /**
     * 蓝图技能实体 Mybatis-Plus 数据访问对象
     */
    private final BlueprintSkillMapper blueprintSkillMapper;

    public BlueprintSkillDataManager(BlueprintSkillMapper blueprintSkillMapper) {
        this.blueprintSkillMapper = blueprintSkillMapper;
    }
}
