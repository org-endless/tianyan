package org.endless.tianyan.finance.components.cost.rule.facade.adapter.spring;

import org.endless.tianyan.finance.components.cost.rule.application.command.handler.CostRuleCommandHandler;
import org.endless.tianyan.finance.components.cost.rule.application.query.handler.CostRuleQueryHandler;
import org.endless.tianyan.finance.components.cost.rule.facade.adapter.CostRuleDrivingAdapter;

/**
 * SpringCostRuleDrivingAdapter
 * <p>成本规则领域主动适配器Spring实现类
 * <p>
 * create 2025/07/28 20:10
 * <p>
 * update 2025/07/28 20:10
 *
 * @author Deng Haozhi
 * @see CostRuleDrivingAdapter
 * @since 0.0.1
 */
public class SpringCostRuleDrivingAdapter implements CostRuleDrivingAdapter {

    /**
     * 成本规则领域命令处理器
     */
    private final CostRuleCommandHandler costRuleCommandHandler;

    /**
     * 成本规则领域查询处理器
     */
    private final CostRuleQueryHandler costRuleQueryHandler;

    public SpringCostRuleDrivingAdapter(CostRuleCommandHandler costRuleCommandHandler, CostRuleQueryHandler costRuleQueryHandler) {
        this.costRuleCommandHandler = costRuleCommandHandler;
        this.costRuleQueryHandler = costRuleQueryHandler;
    }
}
