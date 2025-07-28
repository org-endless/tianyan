package org.endless.tianyan.sales.components.market.price.market.price.infrastructure.data.manager;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.manager.DataManagerRequestNullException;
import org.endless.tianyan.sales.common.model.infrastructure.data.manager.TianyanSalesAggregateDataManager;
import org.endless.tianyan.sales.components.market.price.market.price.application.query.anticorruption.MarketPriceQueryRepository;
import org.endless.tianyan.sales.components.market.price.market.price.domain.anticorruption.MarketPriceRepository;
import org.endless.tianyan.sales.components.market.price.market.price.domain.entity.MarketPriceAggregate;
import org.endless.tianyan.sales.components.market.price.market.price.infrastructure.data.persistence.mapper.MarketPriceMapper;
import org.endless.tianyan.sales.components.market.price.market.price.infrastructure.data.record.MarketPriceRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * MarketPriceDataManager
 * <p>市场价格聚合数据管理器
 * <p>
 * create 2025/07/26 18:56
 * <p>
 * update 2025/07/26 18:56
 *
 * @author Deng Haozhi
 * @see MarketPriceRepository
 * @see MarketPriceQueryRepository
 * @see TianyanSalesAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class MarketPriceDataManager implements MarketPriceRepository, MarketPriceQueryRepository, TianyanSalesAggregateDataManager<MarketPriceRecord, MarketPriceAggregate> {

    /**
     * 市场价格聚合 Mybatis-Plus 数据访问对象
     */
    private final MarketPriceMapper marketPriceMapper;

    public MarketPriceDataManager(MarketPriceMapper marketPriceMapper) {
        this.marketPriceMapper = marketPriceMapper;
    }

    @Override
    @Log(message = "保存市场价格聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public MarketPriceAggregate save(MarketPriceAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .map(MarketPriceAggregate::validate)
                .orElseThrow(() -> new DataManagerRequestNullException("保存市场价格聚合数据数据不能为空"));
        marketPriceMapper.save(MarketPriceRecord.from(aggregate));
        return aggregate;
    }

    @Override
    public void remove(MarketPriceAggregate aggregate) {

    }

    @Override
    public MarketPriceAggregate modify(MarketPriceAggregate aggregate) {
        return null;
    }

    @Override
    public Optional<MarketPriceAggregate> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<MarketPriceAggregate> findByIdForUpdate(String s) {
        return Optional.empty();
    }
}
