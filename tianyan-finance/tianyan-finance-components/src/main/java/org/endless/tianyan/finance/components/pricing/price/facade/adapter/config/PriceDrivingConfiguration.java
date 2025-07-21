package org.endless.tianyan.finance.components.pricing.price.facade.adapter.config;

import org.endless.tianyan.finance.components.pricing.price.application.command.handler.*;
import org.endless.tianyan.finance.components.pricing.price.application.command.handler.impl.*;
import org.endless.tianyan.finance.components.pricing.price.application.query.handler.*;
import org.endless.tianyan.finance.components.pricing.price.application.query.handler.impl.*;
import org.endless.tianyan.finance.components.pricing.price.application.query.anticorruption.*;
import org.endless.tianyan.finance.components.pricing.price.domain.anticorruption.*;
import org.endless.tianyan.finance.components.pricing.price.facade.adapter.*;
import org.endless.tianyan.finance.components.pricing.price.facade.adapter.spring.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * PriceDrivingConfiguration
 * <p>价格领域主动适配器配置类
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
public class PriceDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean PriceDrivingAdapter springPriceDrivingAdapter(PriceCommandHandler commandHandler, PriceQueryHandler queryHandler) {
        return new SpringPriceDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean PriceCommandHandler priceCommandHandler(PriceRepository repository) {
        return new PriceCommandHandlerImpl(repository);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean PriceQueryHandler priceQueryHandler(PriceQueryRepository priceQueryRepository) {
        return new PriceQueryHandlerImpl(priceQueryRepository);
    }
}
