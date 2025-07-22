package org.endless.tianyan.sales.components.market.group.infrastructure.data.manager;

import org.endless.tianyan.sales.common.model.infrastructure.data.manager.TianyanSalesAggregateDataManager;
import org.endless.tianyan.sales.components.market.group.application.query.anticorruption.MarketGroupQueryRepository;
import org.endless.tianyan.sales.components.market.group.domain.anticorruption.MarketGroupRepository;
import org.endless.tianyan.sales.components.market.group.domain.entity.MarketGroupAggregate;
import org.endless.tianyan.sales.components.market.group.infrastructure.data.persistence.mapper.MarketGroupMapper;
import org.endless.tianyan.sales.components.market.group.infrastructure.data.record.MarketGroupRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * MarketGroupDataManager
 * <p>市场分组聚合数据管理器
 * <p>
 * create 2025/07/22 09:08
 * <p>
 * update 2025/07/22 09:08
 *
 * @author Deng Haozhi
 * @see MarketGroupRepository
 * @see MarketGroupQueryRepository
 * @see TianyanSalesAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class MarketGroupDataManager implements MarketGroupRepository, MarketGroupQueryRepository, TianyanSalesAggregateDataManager<MarketGroupRecord, MarketGroupAggregate> {

    /**
     * 市场分组聚合 Mybatis-Plus 数据访问对象
     */
    private final MarketGroupMapper marketGroupMapper;

    public MarketGroupDataManager(MarketGroupMapper marketGroupMapper) {
        this.marketGroupMapper = marketGroupMapper;
    }

    @Override
    public MarketGroupAggregate save(MarketGroupAggregate marketGroupAggregate) {
        return null;
    }

    @Override
    public void remove(MarketGroupAggregate marketGroupAggregate) {

    }

    @Override
    public MarketGroupAggregate modify(MarketGroupAggregate marketGroupAggregate) {
        return null;
    }

    @Override
    public Optional<MarketGroupAggregate> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<MarketGroupAggregate> findByIdForUpdate(String s) {
        return Optional.empty();
    }
}
