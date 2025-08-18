package org.endless.tianyan.finance.components.cost.type.application.query.anticorruption;

import org.endless.tianyan.finance.common.model.application.query.anticorruption.TianyanFinanceQueryRepository;
import org.endless.tianyan.finance.components.cost.type.domain.anticorruption.CostTypeRepository;
import org.endless.tianyan.finance.components.cost.type.domain.entity.CostTypeAggregate;

/**
 * CostTypeQueryRepository
 * <p>成本类型聚合查询仓储接口
 * <p>
 * create 2025/07/28 20:09
 * <p>
 * update 2025/07/28 20:09
 *
 * @author Deng Haozhi
 * @see CostTypeRepository
 * @see TianyanFinanceQueryRepository
 * @since 0.0.1
 */
public interface CostTypeQueryRepository extends CostTypeRepository, TianyanFinanceQueryRepository<CostTypeAggregate> {

}
