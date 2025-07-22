package org.endless.tianyan.sales.components.market.group.infrastructure.data.persistence.mapper;

import org.endless.tianyan.sales.common.model.infrastructure.data.persistence.mapper.*;
import org.endless.tianyan.sales.components.market.group.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.persistence.mapper.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;

/**
 * MarketGroupMapper
 * <p>市场分组聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/07/22 09:08
 * <p>
 * update 2025/07/22 09:08
 *
 * @author Deng Haozhi
 * @see TianyanSalesMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface MarketGroupMapper extends TianyanSalesMapper<MarketGroupRecord> {
}
