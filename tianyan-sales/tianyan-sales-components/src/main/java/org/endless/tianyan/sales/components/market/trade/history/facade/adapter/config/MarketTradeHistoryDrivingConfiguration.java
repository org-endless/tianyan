package org.endless.tianyan.sales.components.market.trade.history.facade.adapter.config;

import org.endless.tianyan.sales.components.market.trade.history.application.command.handler.MarketTradeHistoryCommandHandler;
import org.endless.tianyan.sales.components.market.trade.history.application.command.handler.impl.MarketTradeHistoryCommandHandlerImpl;
import org.endless.tianyan.sales.components.market.trade.history.application.query.anticorruption.MarketTradeHistoryQueryRepository;
import org.endless.tianyan.sales.components.market.trade.history.application.query.handler.MarketTradeHistoryQueryHandler;
import org.endless.tianyan.sales.components.market.trade.history.application.query.handler.impl.MarketTradeHistoryQueryHandlerImpl;
import org.endless.tianyan.sales.components.market.trade.history.domain.anticorruption.MarketTradeHistoryRepository;
import org.endless.tianyan.sales.components.market.trade.history.facade.adapter.MarketTradeHistoryDrivingAdapter;
import org.endless.tianyan.sales.components.market.trade.history.facade.adapter.spring.SpringMarketTradeHistoryDrivingAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * MarketTradeHistoryDrivingConfiguration
 * <p>市场交易历史领域主动适配器配置类
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
public class MarketTradeHistoryDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean MarketTradeHistoryDrivingAdapter springMarketTradeHistoryDrivingAdapter(MarketTradeHistoryCommandHandler commandHandler, MarketTradeHistoryQueryHandler queryHandler) {
        return new SpringMarketTradeHistoryDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean MarketTradeHistoryCommandHandler marketTradeHistoryCommandHandler(MarketTradeHistoryRepository repository) {
        return new MarketTradeHistoryCommandHandlerImpl(repository);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean MarketTradeHistoryQueryHandler marketTradeHistoryQueryHandler(MarketTradeHistoryQueryRepository marketTradeHistoryQueryRepository) {
        return new MarketTradeHistoryQueryHandlerImpl(marketTradeHistoryQueryRepository);
    }
}
