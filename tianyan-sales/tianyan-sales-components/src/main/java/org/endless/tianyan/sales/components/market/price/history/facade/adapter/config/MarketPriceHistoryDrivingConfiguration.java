package org.endless.tianyan.sales.components.market.price.history.facade.adapter.config;

import org.endless.tianyan.sales.components.market.price.history.application.command.handler.MarketPriceHistoryCommandHandler;
import org.endless.tianyan.sales.components.market.price.history.application.command.handler.impl.MarketPriceHistoryCommandHandlerImpl;
import org.endless.tianyan.sales.components.market.price.history.application.query.anticorruption.MarketPriceHistoryQueryRepository;
import org.endless.tianyan.sales.components.market.price.history.application.query.handler.MarketPriceHistoryQueryHandler;
import org.endless.tianyan.sales.components.market.price.history.application.query.handler.impl.MarketPriceHistoryQueryHandlerImpl;
import org.endless.tianyan.sales.components.market.price.history.domain.anticorruption.MarketPriceHistoryRepository;
import org.endless.tianyan.sales.components.market.price.history.facade.adapter.MarketPriceHistoryDrivingAdapter;
import org.endless.tianyan.sales.components.market.price.history.facade.adapter.spring.SpringMarketPriceHistoryDrivingAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * MarketPriceHistoryDrivingConfiguration
 * <p>市场价格历史领域主动适配器配置类
 * <p>
 * create 2025/07/26 18:57
 * <p>
 * update 2025/07/26 18:57
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@Lazy
@Configuration
public class MarketPriceHistoryDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean MarketPriceHistoryDrivingAdapter springMarketPriceHistoryDrivingAdapter(MarketPriceHistoryCommandHandler commandHandler, MarketPriceHistoryQueryHandler queryHandler) {
        return new SpringMarketPriceHistoryDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean MarketPriceHistoryCommandHandler marketPriceHistoryCommandHandler(MarketPriceHistoryRepository repository) {
        return new MarketPriceHistoryCommandHandlerImpl(repository);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean MarketPriceHistoryQueryHandler marketPriceHistoryQueryHandler(MarketPriceHistoryQueryRepository marketPriceHistoryQueryRepository) {
        return new MarketPriceHistoryQueryHandlerImpl(marketPriceHistoryQueryRepository);
    }
}
