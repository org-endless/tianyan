package org.endless.tianyan.sales.components.market.group.facade.adapter.config;

import org.endless.tianyan.sales.components.market.group.application.command.handler.*;
import org.endless.tianyan.sales.components.market.group.application.command.handler.impl.*;
import org.endless.tianyan.sales.components.market.group.application.query.handler.*;
import org.endless.tianyan.sales.components.market.group.application.query.handler.impl.*;
import org.endless.tianyan.sales.components.market.group.application.query.anticorruption.*;
import org.endless.tianyan.sales.components.market.group.domain.anticorruption.*;
import org.endless.tianyan.sales.components.market.group.facade.adapter.*;
import org.endless.tianyan.sales.components.market.group.facade.adapter.spring.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * MarketGroupDrivingConfiguration
 * <p>市场分组领域主动适配器配置类
 * <p>
 * create 2025/07/22 16:05
 * <p>
 * update 2025/07/22 16:05
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@Lazy
@Configuration
public class MarketGroupDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean MarketGroupDrivingAdapter springMarketGroupDrivingAdapter(MarketGroupCommandHandler commandHandler, MarketGroupQueryHandler queryHandler) {
        return new SpringMarketGroupDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean MarketGroupCommandHandler marketGroupCommandHandler(MarketGroupRepository repository) {
        return new MarketGroupCommandHandlerImpl(repository);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean MarketGroupQueryHandler marketGroupQueryHandler(MarketGroupQueryRepository marketGroupQueryRepository) {
        return new MarketGroupQueryHandlerImpl(marketGroupQueryRepository);
    }
}
