package org.endless.tianyan.finance.components.pricing.price.application.query.anticorruption;

import org.endless.tianyan.finance.common.model.application.query.anticorruption.*;
import org.endless.tianyan.finance.components.pricing.price.domain.anticorruption.*;
import org.endless.tianyan.finance.components.pricing.price.domain.entity.*;

/**
 * PriceQueryRepository
 * <p>价格聚合查询仓储接口
 * <p>
 * create 2025/07/19 08:27
 * <p>
 * update 2025/07/19 08:27
 *
 * @author Deng Haozhi
 * @see PriceRepository
 * @see TianyanFinanceQueryRepository
 * @since 0.0.1
 */
public interface PriceQueryRepository extends PriceRepository, TianyanFinanceQueryRepository<PriceAggregate> {
}
