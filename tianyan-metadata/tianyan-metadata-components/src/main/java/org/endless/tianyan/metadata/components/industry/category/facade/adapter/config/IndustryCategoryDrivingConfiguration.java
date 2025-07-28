package org.endless.tianyan.metadata.components.industry.category.facade.adapter.config;

import org.endless.tianyan.metadata.components.industry.category.application.command.handler.*;
import org.endless.tianyan.metadata.components.industry.category.application.command.handler.impl.*;
import org.endless.tianyan.metadata.components.industry.category.application.query.handler.*;
import org.endless.tianyan.metadata.components.industry.category.application.query.handler.impl.*;
import org.endless.tianyan.metadata.components.industry.category.application.query.anticorruption.*;
import org.endless.tianyan.metadata.components.industry.category.domain.anticorruption.*;
import org.endless.tianyan.metadata.components.industry.category.facade.adapter.*;
import org.endless.tianyan.metadata.components.industry.category.facade.adapter.spring.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * IndustryCategoryDrivingConfiguration
 * <p>行业分类领域主动适配器配置类
 * <p>
 * create 2025/07/28 18:57
 * <p>
 * update 2025/07/28 18:57
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@Lazy
@Configuration
public class IndustryCategoryDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean IndustryCategoryDrivingAdapter springIndustryCategoryDrivingAdapter(IndustryCategoryCommandHandler commandHandler, IndustryCategoryQueryHandler queryHandler) {
        return new SpringIndustryCategoryDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean IndustryCategoryCommandHandler industryCategoryCommandHandler(IndustryCategoryRepository repository) {
        return new IndustryCategoryCommandHandlerImpl(repository);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean IndustryCategoryQueryHandler industryCategoryQueryHandler(IndustryCategoryQueryRepository industryCategoryQueryRepository) {
        return new IndustryCategoryQueryHandlerImpl(industryCategoryQueryRepository);
    }
}
