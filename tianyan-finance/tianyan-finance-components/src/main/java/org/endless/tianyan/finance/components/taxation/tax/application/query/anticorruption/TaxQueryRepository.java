package org.endless.tianyan.finance.components.taxation.tax.application.query.anticorruption;

import org.endless.tianyan.finance.common.model.application.query.anticorruption.TianyanFinanceQueryRepository;
import org.endless.tianyan.finance.components.taxation.tax.domain.anticorruption.TaxRepository;
import org.endless.tianyan.finance.components.taxation.tax.domain.entity.TaxAggregate;

/**
 * TaxQueryRepository
 * <p>税务聚合查询仓储接口
 * <p>
 * create 2025/07/19 08:27
 * <p>
 * update 2025/07/19 08:27
 *
 * @author Deng Haozhi
 * @see TaxRepository
 * @see TianyanFinanceQueryRepository
 * @since 0.0.1
 */
public interface TaxQueryRepository extends TaxRepository, TianyanFinanceQueryRepository<TaxAggregate> {
}
