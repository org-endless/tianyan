package org.endless.tianyan.sales.components.market.price.history.infrastructure.data.persistence.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.endless.tianyan.sales.common.model.infrastructure.data.persistence.mapper.TianyanSalesMapper;
import org.endless.tianyan.sales.components.market.price.history.infrastructure.data.record.MarketPriceHistoryRecord;
import org.springframework.context.annotation.Lazy;

/**
 * MarketPriceHistoryMapper
 * <p>市场价格历史聚合 Mybatis-Plus 数据访问对象
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
public interface MarketPriceHistoryMapper extends TianyanSalesMapper<MarketPriceHistoryRecord> {

}
