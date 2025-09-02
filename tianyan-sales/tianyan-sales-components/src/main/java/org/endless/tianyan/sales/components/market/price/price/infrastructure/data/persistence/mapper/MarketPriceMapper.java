package org.endless.tianyan.sales.components.market.price.price.infrastructure.data.persistence.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.endless.tianyan.sales.common.model.infrastructure.data.persistence.mapper.TianyanSalesMapper;
import org.endless.tianyan.sales.components.market.price.price.infrastructure.data.record.MarketPriceRecord;
import org.springframework.context.annotation.Lazy;

/**
 * MarketPriceMapper
 * <p>市场价格聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/07/26 18:56
 * <p>
 * update 2025/07/26 18:56
 *
 * @author Deng Haozhi
 * @see TianyanSalesMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface MarketPriceMapper extends TianyanSalesMapper<MarketPriceRecord> {

}
