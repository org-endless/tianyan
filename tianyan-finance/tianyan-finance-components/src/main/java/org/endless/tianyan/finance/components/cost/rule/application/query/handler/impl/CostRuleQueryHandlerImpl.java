package org.endless.tianyan.finance.components.cost.rule.application.query.handler.impl;

import org.endless.tianyan.finance.components.cost.rule.application.query.anticorruption.CostRuleQueryRepository;
import org.endless.tianyan.finance.components.cost.rule.application.query.handler.CostRuleQueryHandler;

/**
 * CostRuleQueryHandlerImpl
 * <p>成本规则领域查询处理器
 * <p>
 * create 2025/07/28 20:10
 * <p>
 * update 2025/07/28 20:10
 *
 * @author Deng Haozhi
 * @see CostRuleQueryHandler
 * @since 0.0.1
 */
public class CostRuleQueryHandlerImpl implements CostRuleQueryHandler {

    /**
     * 成本规则聚合查询仓储接口
     */
    private final CostRuleQueryRepository costRuleQueryRepository;

    public CostRuleQueryHandlerImpl(CostRuleQueryRepository costRuleQueryRepository) {
        this.costRuleQueryRepository = costRuleQueryRepository;
    }
}
