package org.endless.tianyan.sales.components.market.price.market.price.infrastructure.data.manager;

import org.endless.tianyan.sales.common.model.infrastructure.data.manager.*;
import org.endless.tianyan.sales.components.market.price.market.price.application.query.anticorruption.*;
import org.endless.tianyan.sales.components.market.price.market.price.domain.anticorruption.*;
import org.endless.tianyan.sales.components.market.price.market.price.domain.entity.*;
import org.endless.tianyan.sales.components.market.price.market.price.infrastructure.data.persistence.mapper.*;
import org.endless.tianyan.sales.components.market.price.market.price.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.manager.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
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
}
