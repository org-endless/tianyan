package org.endless.tianyan.sales.components.market.game.eve.group.infrastructure.data.manager;

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
    public GameEveMarketGroupAggregate save(GameEveMarketGroupAggregate gameEveMarketGroupAggregate) {
        return null;
    }

    @Override
    public void remove(GameEveMarketGroupAggregate gameEveMarketGroupAggregate) {

    }

    @Override
    public GameEveMarketGroupAggregate modify(GameEveMarketGroupAggregate gameEveMarketGroupAggregate) {
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
}
