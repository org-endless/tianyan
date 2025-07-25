package org.endless.tianyan.sales.components.market.group.market.group.facade.adapter.config;

import org.endless.tianyan.sales.components.market.group.market.group.application.command.handler.MarketGroupCommandHandler;
import org.endless.tianyan.sales.components.market.group.market.group.application.command.handler.impl.MarketGroupCommandHandlerImpl;
import org.endless.tianyan.sales.components.market.group.market.group.application.query.anticorruption.MarketGroupQueryRepository;
import org.endless.tianyan.sales.components.market.group.market.group.application.query.handler.MarketGroupQueryHandler;
import org.endless.tianyan.sales.components.market.group.market.group.application.query.handler.impl.MarketGroupQueryHandlerImpl;
import org.endless.tianyan.sales.components.market.group.market.group.domain.anticorruption.MarketGroupRepository;
import org.endless.tianyan.sales.components.market.group.market.group.facade.adapter.MarketGroupDrivingAdapter;
import org.endless.tianyan.sales.components.market.group.market.group.facade.adapter.spring.SpringMarketGroupDrivingAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * MarketGroupDrivingConfiguration
 * <p>市场分组领域主动适配器配置类
 * <p>
 * create 2025/07/24 17:36
 * <p>
 * update 2025/07/24 17:36
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
