package org.endless.tianyan.finance.components.tax.tax.application.query.anticorruption;

import org.endless.tianyan.finance.common.model.application.query.anticorruption.*;
import org.endless.tianyan.finance.components.tax.tax.domain.anticorruption.*;
import org.endless.tianyan.finance.components.tax.tax.domain.entity.*;

/**
 * TaxQueryRepository
 * <p>税务聚合查询仓储接口
 * <p>
 * create 2025/07/19 05:08
 * <p>
 * update 2025/07/19 05:08
 *
 * @author Deng Haozhi
 * @see TaxRepository
 * @see TianyanFinanceQueryRepository
 * @since 0.0.1
 */
public interface TaxQueryRepository extends TaxRepository, TianyanFinanceQueryRepository<TaxAggregate> {
}
