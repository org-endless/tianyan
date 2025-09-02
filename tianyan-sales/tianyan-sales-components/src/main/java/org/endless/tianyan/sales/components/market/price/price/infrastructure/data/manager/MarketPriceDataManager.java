package org.endless.tianyan.sales.components.market.price.price.infrastructure.data.manager;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.sales.common.model.infrastructure.data.manager.TianyanSalesAggregateDataManager;
import org.endless.tianyan.sales.components.market.price.price.application.query.anticorruption.MarketPriceQueryRepository;
import org.endless.tianyan.sales.components.market.price.price.domain.anticorruption.MarketPriceRepository;
import org.endless.tianyan.sales.components.market.price.price.domain.entity.MarketPriceAggregate;
import org.endless.tianyan.sales.components.market.price.price.infrastructure.data.persistence.mapper.MarketPriceMapper;
import org.endless.tianyan.sales.components.market.price.price.infrastructure.data.record.MarketPriceRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

/**
 * MarketPriceDataManager
 * <p>市场价格聚合根数据管理器
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
@Validated
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
    @Log(message = "保存市场价格聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void save(MarketPriceAggregate aggregate) {
        marketPriceMapper.save(MarketPriceRecord.from(aggregate));
    }

    @Override
    @Log(message = "删除市场价格聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void remove(MarketPriceAggregate aggregate) {
        marketPriceMapper.remove(MarketPriceRecord.from(aggregate));
    }

    @Override
    @Log(message = "修改市场价格聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void modify(MarketPriceAggregate aggregate) {
        marketPriceMapper.modify(MarketPriceRecord.from(aggregate));
    }

    @Override
    @Log(message = "根据ID查询市场价格聚合根数据", value = "#marketPriceId", level = LogLevel.TRACE)
    public Optional<MarketPriceAggregate> findById(String marketPriceId) {
        return marketPriceMapper.findById(marketPriceId).map(MarketPriceRecord::to);
    }

    @Override
    public Optional<MarketPriceAggregate> findByIdForUpdate(String marketPriceId) {
        return Optional.empty();
    }
}
