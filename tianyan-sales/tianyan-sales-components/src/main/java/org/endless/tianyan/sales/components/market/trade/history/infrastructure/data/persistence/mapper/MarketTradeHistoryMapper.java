package org.endless.tianyan.sales.components.market.trade.history.infrastructure.data.persistence.mapper;

import org.endless.tianyan.sales.common.model.infrastructure.data.persistence.mapper.*;
import org.endless.tianyan.sales.components.market.trade.history.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.persistence.mapper.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;

/**
 * MarketTradeHistoryMapper
 * <p>市场交易历史聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/07/26 18:57
 * <p>
 * update 2025/07/26 18:57
 *
 * @author Deng Haozhi
 * @see TianyanSalesMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface MarketTradeHistoryMapper extends TianyanSalesMapper<MarketTradeHistoryRecord> {
}
