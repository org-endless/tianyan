package org.endless.tianyan.sales.components.market.price.market.price.facade.adapter.config;

import org.endless.tianyan.sales.components.market.price.market.price.application.command.handler.MarketPriceCommandHandler;
import org.endless.tianyan.sales.components.market.price.market.price.application.command.handler.impl.MarketPriceCommandHandlerImpl;
import org.endless.tianyan.sales.components.market.price.market.price.application.query.anticorruption.MarketPriceQueryRepository;
import org.endless.tianyan.sales.components.market.price.market.price.application.query.handler.MarketPriceQueryHandler;
import org.endless.tianyan.sales.components.market.price.market.price.application.query.handler.impl.MarketPriceQueryHandlerImpl;
import org.endless.tianyan.sales.components.market.price.market.price.domain.anticorruption.MarketPriceRepository;
import org.endless.tianyan.sales.components.market.price.market.price.facade.adapter.MarketPriceDrivingAdapter;
import org.endless.tianyan.sales.components.market.price.market.price.facade.adapter.spring.SpringMarketPriceDrivingAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * MarketPriceDrivingConfiguration
 * <p>市场价格领域主动适配器配置类
 * <p>
 * create 2025/07/26 18:56
 * <p>
 * update 2025/07/26 18:56
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@Lazy
@Configuration
public class MarketPriceDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean MarketPriceDrivingAdapter springMarketPriceDrivingAdapter(MarketPriceCommandHandler commandHandler, MarketPriceQueryHandler queryHandler) {
        return new SpringMarketPriceDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean MarketPriceCommandHandler marketPriceCommandHandler(MarketPriceRepository repository) {
        return new MarketPriceCommandHandlerImpl(repository);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean MarketPriceQueryHandler marketPriceQueryHandler(MarketPriceQueryRepository marketPriceQueryRepository) {
        return new MarketPriceQueryHandlerImpl(marketPriceQueryRepository);
    }
}
