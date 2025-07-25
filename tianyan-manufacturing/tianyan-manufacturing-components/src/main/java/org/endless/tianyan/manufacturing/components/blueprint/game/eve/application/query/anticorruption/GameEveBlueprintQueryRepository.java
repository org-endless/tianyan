package org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.query.anticorruption;

import org.endless.tianyan.manufacturing.common.model.application.query.anticorruption.TianyanManufacturingQueryRepository;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.domain.anticorruption.GameEveBlueprintRepository;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.domain.entity.GameEveBlueprintAggregate;

/**
 * GameEveBlueprintQueryRepository
 * <p>游戏EVE蓝图聚合查询仓储接口
 * <p>
 * create 2025/07/24 09:18
 * <p>
 * update 2025/07/24 09:18
 *
 * @author Deng Haozhi
 * @see GameEveBlueprintRepository
 * @see TianyanManufacturingQueryRepository
 * @since 0.0.1
 */
public interface GameEveBlueprintQueryRepository extends GameEveBlueprintRepository, TianyanManufacturingQueryRepository<GameEveBlueprintAggregate> {

}
