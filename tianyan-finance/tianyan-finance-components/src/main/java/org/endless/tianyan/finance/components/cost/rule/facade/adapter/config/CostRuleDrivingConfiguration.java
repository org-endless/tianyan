package org.endless.tianyan.finance.components.cost.rule.facade.adapter.config;

import org.endless.tianyan.finance.components.cost.rule.application.command.handler.CostRuleCommandHandler;
import org.endless.tianyan.finance.components.cost.rule.application.command.handler.impl.CostRuleCommandHandlerImpl;
import org.endless.tianyan.finance.components.cost.rule.application.query.anticorruption.CostRuleQueryRepository;
import org.endless.tianyan.finance.components.cost.rule.application.query.handler.CostRuleQueryHandler;
import org.endless.tianyan.finance.components.cost.rule.application.query.handler.impl.CostRuleQueryHandlerImpl;
import org.endless.tianyan.finance.components.cost.rule.domain.anticorruption.CostRuleRepository;
import org.endless.tianyan.finance.components.cost.rule.facade.adapter.CostRuleDrivingAdapter;
import org.endless.tianyan.finance.components.cost.rule.facade.adapter.spring.SpringCostRuleDrivingAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * CostRuleDrivingConfiguration
 * <p>成本规则领域主动适配器配置类
 * <p>
 * create 2025/07/28 20:10
 * <p>
 * update 2025/07/28 20:10
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@Lazy
@Configuration
public class CostRuleDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean CostRuleDrivingAdapter springCostRuleDrivingAdapter(CostRuleCommandHandler commandHandler, CostRuleQueryHandler queryHandler) {
        return new SpringCostRuleDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean CostRuleCommandHandler costRuleCommandHandler(CostRuleRepository repository) {
        return new CostRuleCommandHandlerImpl(repository);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean CostRuleQueryHandler costRuleQueryHandler(CostRuleQueryRepository costRuleQueryRepository) {
        return new CostRuleQueryHandlerImpl(costRuleQueryRepository);
    }
}
