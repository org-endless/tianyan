package org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.data.manager;

import org.endless.tianyan.sales.common.model.infrastructure.data.manager.TianyanSalesAggregateDataManager;
import org.endless.tianyan.sales.components.market.order.game.eve.application.query.anticorruption.GameEveMarketOrderQueryRepository;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.anticorruption.GameEveMarketOrderRepository;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.entity.GameEveMarketOrderAggregate;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.data.persistence.mapper.GameEveMarketOrderMapper;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.data.record.GameEveMarketOrderRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * GameEveMarketOrderDataManager
 * <p>游戏EVE市场订单聚合数据管理器
 * <p>
 * create 2025/07/25 11:19
 * <p>
 * update 2025/07/25 11:19
 *
 * @author Deng Haozhi
 * @see GameEveMarketOrderRepository
 * @see GameEveMarketOrderQueryRepository
 * @see TianyanSalesAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class GameEveMarketOrderDataManager implements GameEveMarketOrderRepository, GameEveMarketOrderQueryRepository, TianyanSalesAggregateDataManager<GameEveMarketOrderRecord, GameEveMarketOrderAggregate> {

    /**
     * 游戏EVE市场订单聚合 Mybatis-Plus 数据访问对象
     */
    private final GameEveMarketOrderMapper gameEveMarketOrderMapper;

    public GameEveMarketOrderDataManager(GameEveMarketOrderMapper gameEveMarketOrderMapper) {
        this.gameEveMarketOrderMapper = gameEveMarketOrderMapper;
    }

    @Override
    public GameEveMarketOrderAggregate save(GameEveMarketOrderAggregate gameEveMarketOrderAggregate) {
        return null;
    }

    @Override
    public void remove(GameEveMarketOrderAggregate gameEveMarketOrderAggregate) {

    }

    @Override
    public GameEveMarketOrderAggregate modify(GameEveMarketOrderAggregate gameEveMarketOrderAggregate) {
        return null;
    }

    @Override
    public Optional<GameEveMarketOrderAggregate> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<GameEveMarketOrderAggregate> findByIdForUpdate(String s) {
        return Optional.empty();
    }
}
