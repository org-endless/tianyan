package org.endless.tianyan.sales.components.market.trade.market.trade.infrastructure.data.manager;

import org.endless.tianyan.sales.common.model.infrastructure.data.manager.TianyanSalesAggregateDataManager;
import org.endless.tianyan.sales.components.market.trade.market.trade.application.query.anticorruption.MarketTradeQueryRepository;
import org.endless.tianyan.sales.components.market.trade.market.trade.domain.anticorruption.MarketTradeRepository;
import org.endless.tianyan.sales.components.market.trade.market.trade.domain.entity.MarketTradeAggregate;
import org.endless.tianyan.sales.components.market.trade.market.trade.infrastructure.data.persistence.mapper.MarketTradeMapper;
import org.endless.tianyan.sales.components.market.trade.market.trade.infrastructure.data.record.MarketTradeRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * MarketTradeDataManager
 * <p>市场交易聚合数据管理器
 * <p>
 * create 2025/07/26 18:57
 * <p>
 * update 2025/07/26 18:57
 *
 * @author Deng Haozhi
 * @see MarketTradeRepository
 * @see MarketTradeQueryRepository
 * @see TianyanSalesAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class MarketTradeDataManager implements MarketTradeRepository, MarketTradeQueryRepository, TianyanSalesAggregateDataManager<MarketTradeRecord, MarketTradeAggregate> {

    /**
     * 市场交易聚合 Mybatis-Plus 数据访问对象
     */
    private final MarketTradeMapper marketTradeMapper;

    public MarketTradeDataManager(MarketTradeMapper marketTradeMapper) {
        this.marketTradeMapper = marketTradeMapper;
    }

    @Override
    public MarketTradeAggregate save(MarketTradeAggregate marketTradeAggregate) {
        return null;
    }

    @Override
    public void remove(MarketTradeAggregate marketTradeAggregate) {

    }

    @Override
    public MarketTradeAggregate modify(MarketTradeAggregate marketTradeAggregate) {
        return null;
    }

    @Override
    public Optional<MarketTradeAggregate> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<MarketTradeAggregate> findByIdForUpdate(String s) {
        return Optional.empty();
    }
}
