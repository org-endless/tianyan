package org.endless.tianyan.sales.components.market.order.market.order.facade.adapter.config;

import org.endless.ddd.simplified.starter.common.config.endless.EndlessAutoConfiguration;
import org.endless.tianyan.sales.components.market.order.market.order.application.command.handler.MarketOrderCommandHandler;
import org.endless.tianyan.sales.components.market.order.market.order.application.command.handler.impl.MarketOrderCommandHandlerImpl;
import org.endless.tianyan.sales.components.market.order.market.order.application.query.anticorruption.MarketOrderQueryRepository;
import org.endless.tianyan.sales.components.market.order.market.order.application.query.handler.MarketOrderQueryHandler;
import org.endless.tianyan.sales.components.market.order.market.order.application.query.handler.impl.MarketOrderQueryHandlerImpl;
import org.endless.tianyan.sales.components.market.order.market.order.domain.anticorruption.MarketOrderPriceDrivenAdapter;
import org.endless.tianyan.sales.components.market.order.market.order.domain.anticorruption.MarketOrderRepository;
import org.endless.tianyan.sales.components.market.order.market.order.facade.adapter.MarketOrderDrivingAdapter;
import org.endless.tianyan.sales.components.market.order.market.order.facade.adapter.spring.SpringMarketOrderDrivingAdapter;
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
    protected @Bean MarketOrderCommandHandler marketOrderCommandHandler(MarketOrderRepository repository, MarketOrderPriceDrivenAdapter marketOrderPriceDrivenAdapter, EndlessAutoConfiguration configuration) {
        return new MarketOrderCommandHandlerImpl(repository, marketOrderPriceDrivenAdapter, configuration);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean MarketOrderQueryHandler marketOrderQueryHandler(MarketOrderQueryRepository marketOrderQueryRepository) {
        return new MarketOrderQueryHandlerImpl(marketOrderQueryRepository);
    }
}
