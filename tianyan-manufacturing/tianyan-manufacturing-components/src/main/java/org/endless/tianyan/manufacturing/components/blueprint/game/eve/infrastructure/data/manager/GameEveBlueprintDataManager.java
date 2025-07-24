package org.endless.tianyan.manufacturing.components.blueprint.game.eve.infrastructure.data.manager;

import org.endless.tianyan.manufacturing.common.model.infrastructure.data.manager.*;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.query.anticorruption.*;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.domain.anticorruption.*;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.domain.entity.*;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.infrastructure.data.persistence.mapper.*;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.manager.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * GameEveBlueprintDataManager
 * <p>游戏EVE蓝图聚合数据管理器
 * <p>
 * create 2025/07/24 09:18
 * <p>
 * update 2025/07/24 09:18
 *
 * @author Deng Haozhi
 * @see GameEveBlueprintRepository
 * @see GameEveBlueprintQueryRepository
 * @see TianyanManufacturingAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class GameEveBlueprintDataManager implements GameEveBlueprintRepository, GameEveBlueprintQueryRepository, TianyanManufacturingAggregateDataManager<GameEveBlueprintRecord, GameEveBlueprintAggregate> {

    /**
     * 游戏EVE蓝图聚合 Mybatis-Plus 数据访问对象
     */
    private final GameEveBlueprintMapper gameEveBlueprintMapper;

    public GameEveBlueprintDataManager(GameEveBlueprintMapper gameEveBlueprintMapper) {
        this.gameEveBlueprintMapper = gameEveBlueprintMapper;
    }
}
