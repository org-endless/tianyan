package org.endless.tianyan.manufacturing.components.blueprint.blueprint.infrastructure.data.manager;

import org.endless.tianyan.manufacturing.common.model.infrastructure.data.manager.TianyanManufacturingEntityDataManager;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.query.anticorruption.BlueprintProductQueryRepository;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.entity.BlueprintProductEntity;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.infrastructure.data.persistence.mapper.BlueprintProductMapper;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.infrastructure.data.record.BlueprintProductRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * BlueprintProductDataManager
 * <p>蓝图产品实体数据管理器
 * <p>
 * create 2025/07/23 17:17
 * <p>
 * update 2025/07/23 17:17
 *
 * @author Deng Haozhi
 * @see BlueprintProductQueryRepository
 * @see TianyanManufacturingEntityDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class BlueprintProductDataManager implements BlueprintProductQueryRepository, TianyanManufacturingEntityDataManager<BlueprintProductRecord, BlueprintProductEntity> {

    /**
     * 蓝图产品实体 Mybatis-Plus 数据访问对象
     */
    private final BlueprintProductMapper blueprintProductMapper;

    public BlueprintProductDataManager(BlueprintProductMapper blueprintProductMapper) {
        this.blueprintProductMapper = blueprintProductMapper;
    }
}
