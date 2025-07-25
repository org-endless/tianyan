package org.endless.tianyan.sales.components.market.order.market.order.facade.adapter.config;

import org.endless.tianyan.sales.components.market.order.market.order.application.command.handler.*;
import org.endless.tianyan.sales.components.market.order.market.order.application.command.handler.impl.*;
import org.endless.tianyan.sales.components.market.order.market.order.application.query.handler.*;
import org.endless.tianyan.sales.components.market.order.market.order.application.query.handler.impl.*;
import org.endless.tianyan.sales.components.market.order.market.order.application.query.anticorruption.*;
import org.endless.tianyan.sales.components.market.order.market.order.domain.anticorruption.*;
import org.endless.tianyan.sales.components.market.order.market.order.facade.adapter.*;
import org.endless.tianyan.sales.components.market.order.market.order.facade.adapter.spring.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * MarketOrderDrivingConfiguration
 * <p>市场订单领域主动适配器配置类
 * <p>
 * create 2025/07/25 13:11
 * <p>
 * update 2025/07/25 13:11
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@Lazy
@Configuration
public class MarketOrderDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean MarketOrderDrivingAdapter springMarketOrderDrivingAdapter(MarketOrderCommandHandler commandHandler, MarketOrderQueryHandler queryHandler) {
        return new SpringMarketOrderDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean MarketOrderCommandHandler marketOrderCommandHandler(MarketOrderRepository repository) {
        return new MarketOrderCommandHandlerImpl(repository);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean MarketOrderQueryHandler marketOrderQueryHandler(MarketOrderQueryRepository marketOrderQueryRepository) {
        return new MarketOrderQueryHandlerImpl(marketOrderQueryRepository);
    }
}
