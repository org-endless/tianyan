package org.endless.tianyan.finance.components.cost.rule.application.command.handler.impl;

import org.endless.tianyan.finance.components.cost.rule.application.command.handler.CostRuleCommandHandler;
import org.endless.tianyan.finance.components.cost.rule.domain.anticorruption.CostRuleRepository;

/**
 * CostRuleCommandHandlerImpl
 * <p>成本规则领域命令处理器
 * <p>
 * create 2025/07/28 20:10
 * <p>
 * update 2025/07/28 20:10
 *
 * @author Deng Haozhi
 * @see CostRuleCommandHandler
 * @since 0.0.1
 */
public class CostRuleCommandHandlerImpl implements CostRuleCommandHandler {

    /**
     * 成本规则聚合仓储接口
     */
    private final CostRuleRepository costRuleRepository;

    public CostRuleCommandHandlerImpl(CostRuleRepository costRuleRepository) {
        this.costRuleRepository = costRuleRepository;
    }
}
