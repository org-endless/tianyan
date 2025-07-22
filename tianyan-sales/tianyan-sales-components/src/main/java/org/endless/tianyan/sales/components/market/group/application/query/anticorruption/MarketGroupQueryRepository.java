package org.endless.tianyan.sales.components.market.group.application.query.anticorruption;

import org.endless.tianyan.sales.common.model.application.query.anticorruption.*;
import org.endless.tianyan.sales.components.market.group.domain.anticorruption.*;
import org.endless.tianyan.sales.components.market.group.domain.entity.*;

/**
 * MarketGroupQueryRepository
 * <p>市场分组聚合查询仓储接口
 * <p>
 * create 2025/07/22 09:08
 * <p>
 * update 2025/07/22 09:08
 *
 * @author Deng Haozhi
 * @see MarketGroupRepository
 * @see TianyanSalesQueryRepository
 * @since 0.0.1
 */
public interface MarketGroupQueryRepository extends MarketGroupRepository, TianyanSalesQueryRepository<MarketGroupAggregate> {
}
