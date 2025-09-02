package org.endless.tianyan.sales.components.market.trade.trade.infrastructure.data.persistence.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.endless.tianyan.sales.common.model.infrastructure.data.persistence.mapper.TianyanSalesMapper;
import org.endless.tianyan.sales.components.market.trade.trade.infrastructure.data.record.MarketTradeRecord;
import org.springframework.context.annotation.Lazy;

/**
 * MarketTradeMapper
 * <p>市场交易聚合 Mybatis-Plus 数据访问对象
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
public interface MarketTradeMapper extends TianyanSalesMapper<MarketTradeRecord> {

}
