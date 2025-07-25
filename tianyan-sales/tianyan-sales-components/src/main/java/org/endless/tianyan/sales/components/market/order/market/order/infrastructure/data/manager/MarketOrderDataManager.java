package org.endless.tianyan.sales.components.market.order.market.order.infrastructure.data.manager;

import org.endless.tianyan.sales.common.model.infrastructure.data.manager.*;
import org.endless.tianyan.sales.components.market.order.market.order.application.query.anticorruption.*;
import org.endless.tianyan.sales.components.market.order.market.order.domain.anticorruption.*;
import org.endless.tianyan.sales.components.market.order.market.order.domain.entity.*;
import org.endless.tianyan.sales.components.market.order.market.order.infrastructure.data.persistence.mapper.*;
import org.endless.tianyan.sales.components.market.order.market.order.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.manager.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * MarketOrderDataManager
 * <p>市场订单聚合数据管理器
 * <p>
 * create 2025/07/25 13:11
 * <p>
 * update 2025/07/25 13:11
 *
 * @author Deng Haozhi
 * @see MarketOrderRepository
 * @see MarketOrderQueryRepository
 * @see TianyanSalesAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class MarketOrderDataManager implements MarketOrderRepository, MarketOrderQueryRepository, TianyanSalesAggregateDataManager<MarketOrderRecord, MarketOrderAggregate> {

    /**
     * 市场订单聚合 Mybatis-Plus 数据访问对象
     */
    private final MarketOrderMapper marketOrderMapper;

    public MarketOrderDataManager(MarketOrderMapper marketOrderMapper) {
        this.marketOrderMapper = marketOrderMapper;
    }
}
