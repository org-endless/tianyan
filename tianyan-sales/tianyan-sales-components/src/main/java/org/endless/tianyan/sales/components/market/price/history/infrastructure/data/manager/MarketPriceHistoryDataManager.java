package org.endless.tianyan.sales.components.market.price.history.infrastructure.data.manager;

import org.endless.tianyan.sales.common.model.infrastructure.data.manager.TianyanSalesAggregateDataManager;
import org.endless.tianyan.sales.components.market.price.history.application.query.anticorruption.MarketPriceHistoryQueryRepository;
import org.endless.tianyan.sales.components.market.price.history.domain.anticorruption.MarketPriceHistoryRepository;
import org.endless.tianyan.sales.components.market.price.history.domain.entity.MarketPriceHistoryAggregate;
import org.endless.tianyan.sales.components.market.price.history.infrastructure.data.persistence.mapper.MarketPriceHistoryMapper;
import org.endless.tianyan.sales.components.market.price.history.infrastructure.data.record.MarketPriceHistoryRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * MarketPriceHistoryDataManager
 * <p>市场价格历史聚合数据管理器
 * <p>
 * create 2025/07/26 18:57
 * <p>
 * update 2025/07/26 18:57
 *
 * @author Deng Haozhi
 * @see MarketPriceHistoryRepository
 * @see MarketPriceHistoryQueryRepository
 * @see TianyanSalesAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class MarketPriceHistoryDataManager implements MarketPriceHistoryRepository, MarketPriceHistoryQueryRepository, TianyanSalesAggregateDataManager<MarketPriceHistoryRecord, MarketPriceHistoryAggregate> {

    /**
     * 市场价格历史聚合 Mybatis-Plus 数据访问对象
     */
    private final MarketPriceHistoryMapper marketPriceHistoryMapper;

    public MarketPriceHistoryDataManager(MarketPriceHistoryMapper marketPriceHistoryMapper) {
        this.marketPriceHistoryMapper = marketPriceHistoryMapper;
    }

    @Override
    public MarketPriceHistoryAggregate save(MarketPriceHistoryAggregate marketPriceHistoryAggregate) {
        return null;
    }

    @Override
    public void remove(MarketPriceHistoryAggregate marketPriceHistoryAggregate) {

    }

    @Override
    public MarketPriceHistoryAggregate modify(MarketPriceHistoryAggregate marketPriceHistoryAggregate) {
        return null;
    }

    @Override
    public Optional<MarketPriceHistoryAggregate> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<MarketPriceHistoryAggregate> findByIdForUpdate(String s) {
        return Optional.empty();
    }
}
