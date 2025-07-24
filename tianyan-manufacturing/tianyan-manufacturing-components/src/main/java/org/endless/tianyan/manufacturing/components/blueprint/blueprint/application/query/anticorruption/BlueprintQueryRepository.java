package org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.query.anticorruption;

import org.endless.tianyan.manufacturing.common.model.application.query.anticorruption.*;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.anticorruption.*;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.entity.*;

/**
 * BlueprintQueryRepository
 * <p>蓝图聚合查询仓储接口
 * <p>
 * create 2025/07/23 17:17
 * <p>
 * update 2025/07/23 17:17
 *
 * @author Deng Haozhi
 * @see BlueprintRepository
 * @see TianyanManufacturingQueryRepository
 * @since 0.0.1
 */
public interface BlueprintQueryRepository extends BlueprintRepository, TianyanManufacturingQueryRepository<BlueprintAggregate> {
}
