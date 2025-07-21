package org.endless.tianyan.finance.components.taxation.tax.facade.adapter.config;

import org.endless.tianyan.finance.components.taxation.tax.application.command.handler.*;
import org.endless.tianyan.finance.components.taxation.tax.application.command.handler.impl.*;
import org.endless.tianyan.finance.components.taxation.tax.application.query.handler.*;
import org.endless.tianyan.finance.components.taxation.tax.application.query.handler.impl.*;
import org.endless.tianyan.finance.components.taxation.tax.application.query.anticorruption.*;
import org.endless.tianyan.finance.components.taxation.tax.domain.anticorruption.*;
import org.endless.tianyan.finance.components.taxation.tax.facade.adapter.*;
import org.endless.tianyan.finance.components.taxation.tax.facade.adapter.spring.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * TaxDrivingConfiguration
 * <p>税务领域主动适配器配置类
 * <p>
 * create 2025/07/19 08:27
 * <p>
 * update 2025/07/19 08:27
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@Lazy
@Configuration
public class TaxDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean TaxDrivingAdapter springTaxDrivingAdapter(TaxCommandHandler commandHandler, TaxQueryHandler queryHandler) {
        return new SpringTaxDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean TaxCommandHandler taxCommandHandler(TaxRepository repository) {
        return new TaxCommandHandlerImpl(repository);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean TaxQueryHandler taxQueryHandler(TaxQueryRepository taxQueryRepository) {
        return new TaxQueryHandlerImpl(taxQueryRepository);
    }
}
