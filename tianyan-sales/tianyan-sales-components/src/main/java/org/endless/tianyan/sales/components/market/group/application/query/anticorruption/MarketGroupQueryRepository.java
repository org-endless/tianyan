package org.endless.tianyan.sales.components.market.group.application.query.anticorruption;

import org.endless.tianyan.sales.common.model.application.query.anticorruption.TianyanSalesQueryRepository;
import org.endless.tianyan.sales.components.market.group.domain.anticorruption.MarketGroupRepository;
import org.endless.tianyan.sales.components.market.group.domain.entity.MarketGroupAggregate;

/**
 * MarketGroupQueryRepository
 * <p>市场分组聚合查询仓储接口
 * <p>
 * create 2025/07/24 17:36
 * <p>
 * update 2025/07/24 17:36
 *
 * @author Deng Haozhi
 * @see MarketGroupRepository
 * @see TianyanSalesQueryRepository
 * @since 0.0.1
 */
public interface MarketGroupQueryRepository extends MarketGroupRepository, TianyanSalesQueryRepository<MarketGroupAggregate> {

    Boolean existsById(String marketGroupId);

}
