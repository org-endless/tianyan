package org.endless.tianyan.manufacturing.components.blueprint.game.eve.infrastructure.data.manager;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.manufacturing.common.model.infrastructure.data.manager.TianyanManufacturingAggregateDataManager;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.query.anticorruption.GameEveBlueprintQueryRepository;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.domain.anticorruption.GameEveBlueprintRepository;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.domain.entity.GameEveBlueprintAggregate;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.infrastructure.data.persistence.mapper.GameEveBlueprintMapper;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.infrastructure.data.record.GameEveBlueprintRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

/**
 * GameEveBlueprintDataManager
 * <p>游戏EVE蓝图聚合根数据管理器
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
@Validated
@Component
public class GameEveBlueprintDataManager implements GameEveBlueprintRepository, GameEveBlueprintQueryRepository, TianyanManufacturingAggregateDataManager<GameEveBlueprintRecord, GameEveBlueprintAggregate> {

    /**
     * 游戏EVE蓝图聚合 Mybatis-Plus 数据访问对象
     */
    private final GameEveBlueprintMapper gameEveBlueprintMapper;

    public GameEveBlueprintDataManager(GameEveBlueprintMapper gameEveBlueprintMapper) {
        this.gameEveBlueprintMapper = gameEveBlueprintMapper;
    }

    @Override
    @Log(message = "保存游戏EVE蓝图聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void save(GameEveBlueprintAggregate aggregate) {
        gameEveBlueprintMapper.save(GameEveBlueprintRecord.from(aggregate));
    }

    @Override
    @Log(message = "删除游戏EVE蓝图聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void remove(GameEveBlueprintAggregate aggregate) {
        gameEveBlueprintMapper.remove(GameEveBlueprintRecord.from(aggregate));
    }

    @Override
    @Log(message = "修改游戏EVE蓝图聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void modify(GameEveBlueprintAggregate aggregate) {
        gameEveBlueprintMapper.modify(GameEveBlueprintRecord.from(aggregate));
    }

    @Override
    @Log(message = "根据ID查询游戏EVE蓝图聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public Optional<GameEveBlueprintAggregate> findById(String gameEveBlueprintId) {
        return gameEveBlueprintMapper.findById(gameEveBlueprintId).map(GameEveBlueprintRecord::to);
    }

    @Override
    public Optional<GameEveBlueprintAggregate> findByIdForUpdate(String gameEveBlueprintId) {
        return Optional.empty();
    }
}
