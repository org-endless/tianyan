package org.endless.tianyan.finance.components.cost.rule.application.query.anticorruption;

import org.endless.tianyan.finance.common.model.application.query.anticorruption.TianyanFinanceQueryRepository;
import org.endless.tianyan.finance.components.cost.rule.domain.anticorruption.CostRuleRepository;
import org.endless.tianyan.finance.components.cost.rule.domain.entity.CostRuleAggregate;

/**
 * CostRuleQueryRepository
 * <p>成本规则聚合查询仓储接口
 * <p>
 * create 2025/07/28 20:10
 * <p>
 * update 2025/07/28 20:10
 *
 * @author Deng Haozhi
 * @see CostRuleRepository
 * @see TianyanFinanceQueryRepository
 * @since 0.0.1
 */
public interface CostRuleQueryRepository extends CostRuleRepository, TianyanFinanceQueryRepository<CostRuleAggregate> {

}
