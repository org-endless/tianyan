package org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.data.manager;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.manager.DataManagerRequestNullException;
import org.endless.tianyan.sales.common.model.infrastructure.data.manager.TianyanSalesAggregateDataManager;
import org.endless.tianyan.sales.components.market.order.game.eve.application.query.anticorruption.GameEveMarketOrderQueryRepository;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.anticorruption.GameEveMarketOrderRepository;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.entity.GameEveMarketOrderAggregate;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.data.persistence.mapper.GameEveMarketOrderMapper;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.data.record.GameEveMarketOrderRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
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
    public GameEveMarketOrderAggregate save(GameEveMarketOrderAggregate aggregate) {
        return null;
    }

    @Override
    public void remove(GameEveMarketOrderAggregate aggregate) {

    }

    @Override
    public GameEveMarketOrderAggregate modify(GameEveMarketOrderAggregate aggregate) {
        return null;
    }

    @Override
    @Log(message = "保存或修改市场订单聚合数据列表", value = "#aggregate", level = LogLevel.TRACE)
    public void upsert(List<GameEveMarketOrderAggregate> aggregates) {
        Optional.ofNullable(aggregates)
                .filter(l -> !CollectionUtils.isEmpty(l))
                .orElseThrow(() -> new DataManagerRequestNullException("保存或修改市场订单聚合数据列表不能为空"));
        gameEveMarketOrderMapper.upsert(aggregates.stream().map(GameEveMarketOrderRecord::from).toList());
    }

    @Override
    public Optional<GameEveMarketOrderAggregate> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<GameEveMarketOrderAggregate> findByIdForUpdate(String s) {
        return Optional.empty();
    }

    @Override
    @Log(message = "根据市场订单ID列表查询游戏EVE市场订单聚合数据列表", value = "#aggregate", level = LogLevel.TRACE)
    public List<GameEveMarketOrderAggregate> findAllByMarketOrderIds(List<String> marketOrderIds) {
        Optional.ofNullable(marketOrderIds)
                .filter(l -> !CollectionUtils.isEmpty(l))
                .orElseThrow(() -> new DataManagerRequestNullException("根据市场订单ID列表查询游戏EVE市场订单聚合数据列表不能为空"));
        return gameEveMarketOrderMapper.findAllByMarketOrderIds(marketOrderIds)
                .stream().map(GameEveMarketOrderRecord::to).toList();
    }

}
