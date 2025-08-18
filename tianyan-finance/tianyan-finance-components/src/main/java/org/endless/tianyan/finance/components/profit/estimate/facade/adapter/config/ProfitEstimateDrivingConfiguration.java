package org.endless.tianyan.finance.components.profit.estimate.facade.adapter.config;

import org.endless.tianyan.finance.components.profit.estimate.application.command.handler.ProfitEstimateCommandHandler;
import org.endless.tianyan.finance.components.profit.estimate.application.command.handler.impl.ProfitEstimateCommandHandlerImpl;
import org.endless.tianyan.finance.components.profit.estimate.application.query.anticorruption.ProfitEstimateQueryRepository;
import org.endless.tianyan.finance.components.profit.estimate.application.query.anticorruption.ProfitMetricQueryRepository;
import org.endless.tianyan.finance.components.profit.estimate.application.query.handler.ProfitEstimateQueryHandler;
import org.endless.tianyan.finance.components.profit.estimate.application.query.handler.impl.ProfitEstimateQueryHandlerImpl;
import org.endless.tianyan.finance.components.profit.estimate.domain.anticorruption.ProfitEstimateRepository;
import org.endless.tianyan.finance.components.profit.estimate.facade.adapter.ProfitEstimateDrivingAdapter;
import org.endless.tianyan.finance.components.profit.estimate.facade.adapter.spring.SpringProfitEstimateDrivingAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * ProfitEstimateDrivingConfiguration
 * <p>预估利润领域主动适配器配置类
 * <p>
 * create 2025/07/28 19:36
 * <p>
 * update 2025/07/28 19:36
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@Lazy
@Configuration
public class ProfitEstimateDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean ProfitEstimateDrivingAdapter springProfitEstimateDrivingAdapter(ProfitEstimateCommandHandler commandHandler, ProfitEstimateQueryHandler queryHandler) {
        return new SpringProfitEstimateDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean ProfitEstimateCommandHandler profitEstimateCommandHandler(ProfitEstimateRepository repository) {
        return new ProfitEstimateCommandHandlerImpl(repository);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean ProfitEstimateQueryHandler profitEstimateQueryHandler(ProfitEstimateQueryRepository profitEstimateQueryRepository, ProfitMetricQueryRepository profitMetricQueryRepository) {
        return new ProfitEstimateQueryHandlerImpl(profitEstimateQueryRepository, profitMetricQueryRepository);
    }
}
