package org.endless.tianyan.finance.components.profit.estimate.application.query.anticorruption;

import org.endless.tianyan.finance.common.model.application.query.anticorruption.TianyanFinanceQueryRepository;
import org.endless.tianyan.finance.components.profit.estimate.domain.anticorruption.ProfitEstimateRepository;
import org.endless.tianyan.finance.components.profit.estimate.domain.entity.ProfitEstimateAggregate;

/**
 * ProfitEstimateQueryRepository
 * <p>预估利润聚合查询仓储接口
 * <p>
 * create 2025/07/28 19:36
 * <p>
 * update 2025/07/28 19:36
 *
 * @author Deng Haozhi
 * @see ProfitEstimateRepository
 * @see TianyanFinanceQueryRepository
 * @since 0.0.1
 */
public interface ProfitEstimateQueryRepository extends ProfitEstimateRepository, TianyanFinanceQueryRepository<ProfitEstimateAggregate> {
}
