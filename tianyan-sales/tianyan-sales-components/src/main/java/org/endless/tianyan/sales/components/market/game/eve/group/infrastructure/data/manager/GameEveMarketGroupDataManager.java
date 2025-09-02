package org.endless.tianyan.sales.components.market.game.eve.group.infrastructure.data.manager;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
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
 * <p>游戏EVE市场分组聚合根数据管理器
 * <p>
 * create 2025/07/24 17:37
 * <p>
 * update 2025/07/24 17:37
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
    @Log(message = "保存游戏EVE市场分组聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void save(GameEveMarketGroupAggregate aggregate) {
        gameEveMarketGroupMapper.save(GameEveMarketGroupRecord.from(aggregate));
    }

    @Override
    public void remove(GameEveMarketGroupAggregate aggregate) {

    }

    @Override
    public void modify(GameEveMarketGroupAggregate aggregate) {
    }

    @Override
    public Optional<GameEveMarketGroupAggregate> findById(String gameEveMarketGroupId) {
        return Optional.empty();
    }

    @Override
    public Optional<GameEveMarketGroupAggregate> findByIdForUpdate(String gameEveMarketGroupId) {
        return Optional.empty();
    }

    @Override
    @Log(message = "根据游戏EVE市场分组编码查询市场分组ID数据", value = "#gameEveMarketGroupCode", level = LogLevel.TRACE)
    public Optional<String> findMarketGroupIdByCode(String gameEveMarketGroupCode) {
        return gameEveMarketGroupMapper.findMarketGroupIdByCode(gameEveMarketGroupCode);
    }
}
