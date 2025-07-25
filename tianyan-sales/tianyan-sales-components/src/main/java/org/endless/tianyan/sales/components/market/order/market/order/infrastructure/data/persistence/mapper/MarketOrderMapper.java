package org.endless.tianyan.sales.components.market.order.market.order.infrastructure.data.persistence.mapper;

import org.endless.tianyan.sales.common.model.infrastructure.data.persistence.mapper.*;
import org.endless.tianyan.sales.components.market.order.market.order.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.persistence.mapper.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;

/**
 * MarketOrderMapper
 * <p>市场订单聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/07/25 13:11
 * <p>
 * update 2025/07/25 13:11
 *
 * @author Deng Haozhi
 * @see TianyanSalesMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface MarketOrderMapper extends TianyanSalesMapper<MarketOrderRecord> {
}
