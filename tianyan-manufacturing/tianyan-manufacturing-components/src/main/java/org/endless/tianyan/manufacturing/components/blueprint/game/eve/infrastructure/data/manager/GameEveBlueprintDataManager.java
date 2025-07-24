package org.endless.tianyan.manufacturing.components.blueprint.game.eve.infrastructure.data.manager;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.manager.DataManagerRequestNullException;
import org.endless.tianyan.manufacturing.common.model.infrastructure.data.manager.TianyanManufacturingAggregateDataManager;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.query.anticorruption.GameEveBlueprintQueryRepository;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.domain.anticorruption.GameEveBlueprintRepository;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.domain.entity.GameEveBlueprintAggregate;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.infrastructure.data.persistence.mapper.GameEveBlueprintMapper;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.infrastructure.data.record.GameEveBlueprintRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

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

    @Override
    @Log(message = "保存游戏EVE蓝图聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public GameEveBlueprintAggregate save(GameEveBlueprintAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .map(GameEveBlueprintAggregate::validate)
                .orElseThrow(() -> new DataManagerRequestNullException("保存游戏EVE资源项聚合数据不能为空"));
        gameEveBlueprintMapper.save(GameEveBlueprintRecord.from(aggregate));
        return aggregate;
    }

    @Override
    public void remove(GameEveBlueprintAggregate aggregate) {

    }

    @Override
    public GameEveBlueprintAggregate modify(GameEveBlueprintAggregate aggregate) {
        return null;
    }

    @Override
    public Optional<GameEveBlueprintAggregate> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<GameEveBlueprintAggregate> findByIdForUpdate(String s) {
        return Optional.empty();
    }
}
