package org.endless.tianyan.sales.components.market.trade.history.infrastructure.data.manager;

import org.endless.tianyan.sales.common.model.infrastructure.data.manager.TianyanSalesAggregateDataManager;
import org.endless.tianyan.sales.components.market.trade.history.application.query.anticorruption.MarketTradeHistoryQueryRepository;
import org.endless.tianyan.sales.components.market.trade.history.domain.anticorruption.MarketTradeHistoryRepository;
import org.endless.tianyan.sales.components.market.trade.history.domain.entity.MarketTradeHistoryAggregate;
import org.endless.tianyan.sales.components.market.trade.history.infrastructure.data.persistence.mapper.MarketTradeHistoryMapper;
import org.endless.tianyan.sales.components.market.trade.history.infrastructure.data.record.MarketTradeHistoryRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * MarketTradeHistoryDataManager
 * <p>市场交易历史聚合数据管理器
 * <p>
 * create 2025/07/26 18:57
 * <p>
 * update 2025/07/26 18:57
 *
 * @author Deng Haozhi
 * @see MarketTradeHistoryRepository
 * @see MarketTradeHistoryQueryRepository
 * @see TianyanSalesAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class MarketTradeHistoryDataManager implements MarketTradeHistoryRepository, MarketTradeHistoryQueryRepository, TianyanSalesAggregateDataManager<MarketTradeHistoryRecord, MarketTradeHistoryAggregate> {

    /**
     * 市场交易历史聚合 Mybatis-Plus 数据访问对象
     */
    private final MarketTradeHistoryMapper marketTradeHistoryMapper;

    public MarketTradeHistoryDataManager(MarketTradeHistoryMapper marketTradeHistoryMapper) {
        this.marketTradeHistoryMapper = marketTradeHistoryMapper;
    }

    @Override
    public MarketTradeHistoryAggregate save(MarketTradeHistoryAggregate marketTradeHistoryAggregate) {
        return null;
    }

    @Override
    public void remove(MarketTradeHistoryAggregate marketTradeHistoryAggregate) {

    }

    @Override
    public MarketTradeHistoryAggregate modify(MarketTradeHistoryAggregate marketTradeHistoryAggregate) {
        return null;
    }

    @Override
    public Optional<MarketTradeHistoryAggregate> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<MarketTradeHistoryAggregate> findByIdForUpdate(String s) {
        return Optional.empty();
    }
}
