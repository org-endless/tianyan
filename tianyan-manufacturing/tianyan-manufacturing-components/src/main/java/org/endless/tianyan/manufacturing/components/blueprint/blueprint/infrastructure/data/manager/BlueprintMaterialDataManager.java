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
 * BlueprintMaterialDataManager
 * <p>蓝图物料实体数据管理器
 * <p>
 * create 2025/07/23 17:17
 * <p>
 * update 2025/07/23 17:17
 *
 * @author Deng Haozhi
 * @see BlueprintMaterialQueryRepository
 * @see TianyanManufacturingEntityDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class BlueprintMaterialDataManager implements BlueprintMaterialQueryRepository, TianyanManufacturingEntityDataManager<BlueprintMaterialRecord, BlueprintMaterialEntity> {

    /**
     * 蓝图物料实体 Mybatis-Plus 数据访问对象
     */
    private final BlueprintMaterialMapper blueprintMaterialMapper;

    public BlueprintMaterialDataManager(BlueprintMaterialMapper blueprintMaterialMapper) {
        this.blueprintMaterialMapper = blueprintMaterialMapper;
    }
}
