package org.endless.tianyan.finance.components.cost.type.facade.adapter.config;

import org.endless.tianyan.finance.components.cost.type.application.command.handler.CostTypeCommandHandler;
import org.endless.tianyan.finance.components.cost.type.application.command.handler.impl.CostTypeCommandHandlerImpl;
import org.endless.tianyan.finance.components.cost.type.application.query.anticorruption.CostTypeQueryRepository;
import org.endless.tianyan.finance.components.cost.type.application.query.handler.CostTypeQueryHandler;
import org.endless.tianyan.finance.components.cost.type.application.query.handler.impl.CostTypeQueryHandlerImpl;
import org.endless.tianyan.finance.components.cost.type.domain.anticorruption.CostTypeRepository;
import org.endless.tianyan.finance.components.cost.type.facade.adapter.CostTypeDrivingAdapter;
import org.endless.tianyan.finance.components.cost.type.facade.adapter.spring.SpringCostTypeDrivingAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * CostTypeDrivingConfiguration
 * <p>成本类型领域主动适配器配置类
 * <p>
 * create 2025/07/28 20:09
 * <p>
 * update 2025/07/28 20:09
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@Lazy
@Configuration
public class CostTypeDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean CostTypeDrivingAdapter springCostTypeDrivingAdapter(CostTypeCommandHandler commandHandler, CostTypeQueryHandler queryHandler) {
        return new SpringCostTypeDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean CostTypeCommandHandler costTypeCommandHandler(CostTypeRepository repository) {
        return new CostTypeCommandHandlerImpl(repository);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean CostTypeQueryHandler costTypeQueryHandler(CostTypeQueryRepository costTypeQueryRepository) {
        return new CostTypeQueryHandlerImpl(costTypeQueryRepository);
    }
}
