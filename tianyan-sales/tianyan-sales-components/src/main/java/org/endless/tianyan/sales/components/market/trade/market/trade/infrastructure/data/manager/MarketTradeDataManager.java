package org.endless.tianyan.sales.components.market.trade.market.trade.infrastructure.data.manager;

import org.endless.tianyan.sales.common.model.infrastructure.data.manager.*;
import org.endless.tianyan.sales.components.market.trade.market.trade.application.query.anticorruption.*;
import org.endless.tianyan.sales.components.market.trade.market.trade.domain.anticorruption.*;
import org.endless.tianyan.sales.components.market.trade.market.trade.domain.entity.*;
import org.endless.tianyan.sales.components.market.trade.market.trade.infrastructure.data.persistence.mapper.*;
import org.endless.tianyan.sales.components.market.trade.market.trade.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.manager.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
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
}
