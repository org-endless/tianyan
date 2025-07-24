package org.endless.tianyan.sales.components.market.game.eve.group.infrastructure.data.manager;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.manager.DataManagerRequestNullException;
import org.endless.tianyan.sales.common.model.infrastructure.data.manager.TianyanSalesAggregateDataManager;
import org.endless.tianyan.sales.components.market.game.eve.group.application.query.anticorruption.GameEveMarketGroupQueryRepository;
import org.endless.tianyan.sales.components.market.game.eve.group.domain.anticorruption.GameEveMarketGroupRepository;
import org.endless.tianyan.sales.components.market.game.eve.group.domain.entity.GameEveMarketGroupAggregate;
import org.endless.tianyan.sales.components.market.game.eve.group.infrastructure.data.persistence.mapper.GameEveMarketGroupMapper;
import org.endless.tianyan.sales.components.market.game.eve.group.infrastructure.data.record.GameEveMarketGroupRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * GameEveMarketGroupDataManager
 * <p>游戏EVE市场分组聚合数据管理器
 * <p>
 * create 2025/07/22 09:09
 * <p>
 * update 2025/07/22 09:09
 *
 * @author Deng Haozhi
 * @see GameEveMarketGroupRepository
 * @see GameEveMarketGroupQueryRepository
 * @see TianyanSalesAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class GameEveMarketGroupDataManager implements GameEveMarketGroupRepository, GameEveMarketGroupQueryRepository, TianyanSalesAggregateDataManager<GameEveMarketGroupRecord, GameEveMarketGroupAggregate> {

    /**
     * 游戏EVE市场分组聚合 Mybatis-Plus 数据访问对象
     */
    private final GameEveMarketGroupMapper gameEveMarketGroupMapper;

    public GameEveMarketGroupDataManager(GameEveMarketGroupMapper gameEveMarketGroupMapper) {
        this.gameEveMarketGroupMapper = gameEveMarketGroupMapper;
    }

    @Override
    @Log(message = "保存游戏EVE市场分组聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public GameEveMarketGroupAggregate save(GameEveMarketGroupAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .map(GameEveMarketGroupAggregate::validate)
                .orElseThrow(() -> new DataManagerRequestNullException("保存游戏EVE市场分组聚合数据不能为空"));
        gameEveMarketGroupMapper.save(GameEveMarketGroupRecord.from(aggregate));
        return aggregate;
    }

    @Override
    public void remove(GameEveMarketGroupAggregate aggregate) {

    }

    @Override
    public GameEveMarketGroupAggregate modify(GameEveMarketGroupAggregate aggregate) {
        return null;
    }

    @Override
    public Optional<GameEveMarketGroupAggregate> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<GameEveMarketGroupAggregate> findByIdForUpdate(String s) {
        return Optional.empty();
    }

    @Override
    @Log(message = "游戏EVE市场分组根据编码查询市场分组ID", value = "#code", level = LogLevel.TRACE)
    public Optional<String> findMarketGroupIdByCode(String code) {
        return gameEveMarketGroupMapper.findMarketGroupIdByCode(code);
    }
}
