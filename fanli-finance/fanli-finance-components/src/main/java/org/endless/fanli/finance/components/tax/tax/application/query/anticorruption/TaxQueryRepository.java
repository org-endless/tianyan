package org.endless.fanli.finance.components.tax.tax.application.query.anticorruption;

import org.endless.fanli.finance.common.model.application.query.anticorruption.*;
import org.endless.fanli.finance.components.tax.tax.domain.anticorruption.*;
import org.endless.fanli.finance.components.tax.tax.domain.entity.*;

/**
 * TaxQueryRepository
 * <p>税务聚合查询仓储接口
 * <p>
 * create 2025/07/19 04:31
 * <p>
 * update 2025/07/19 04:31
 *
 * @author Deng Haozhi
 * @see TaxRepository
 * @see FanliFinanceQueryRepository
 * @since 0.0.1
 */
public interface TaxQueryRepository extends TaxRepository, FanliFinanceQueryRepository<TaxAggregate> {
}
