package org.endless.tianyan.metadata.components.industry.industry.facade.adapter.config;

import org.endless.tianyan.metadata.components.industry.category.facade.adapter.IndustryCategoryDrivingAdapter;
import org.endless.tianyan.metadata.components.industry.industry.application.command.handler.IndustryCommandHandler;
import org.endless.tianyan.metadata.components.industry.industry.application.command.handler.impl.IndustryCommandHandlerImpl;
import org.endless.tianyan.metadata.components.industry.industry.application.query.anticorruption.IndustryQueryRepository;
import org.endless.tianyan.metadata.components.industry.industry.application.query.handler.IndustryQueryHandler;
import org.endless.tianyan.metadata.components.industry.industry.application.query.handler.impl.IndustryQueryHandlerImpl;
import org.endless.tianyan.metadata.components.industry.industry.domain.anticorruption.IndustryRepository;
import org.endless.tianyan.metadata.components.industry.industry.facade.adapter.IndustryDrivingAdapter;
import org.endless.tianyan.metadata.components.industry.industry.facade.adapter.spring.SpringIndustryDrivingAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * IndustryDrivingConfiguration
 * <p>行业领域主动适配器配置类
 * <p>
 * create 2025/07/28 19:04
 * <p>
 * update 2025/07/28 19:04
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@Lazy
@Configuration
public class IndustryDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean IndustryDrivingAdapter springIndustryDrivingAdapter(IndustryCommandHandler commandHandler, IndustryQueryHandler queryHandler) {
        return new SpringIndustryDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean IndustryCommandHandler industryCommandHandler(IndustryRepository repository, IndustryCategoryDrivingAdapter industryCategoryDrivingAdapter) {
        return new IndustryCommandHandlerImpl(repository, industryCategoryDrivingAdapter);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean IndustryQueryHandler industryQueryHandler(IndustryQueryRepository industryQueryRepository) {
        return new IndustryQueryHandlerImpl(industryQueryRepository);
    }
}
