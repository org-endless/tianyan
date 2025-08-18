package org.endless.tianyan.sales.components.market.trade.market.trade.facade.adapter.config;

import org.endless.tianyan.sales.components.market.trade.market.trade.application.command.handler.MarketTradeCommandHandler;
import org.endless.tianyan.sales.components.market.trade.market.trade.application.command.handler.impl.MarketTradeCommandHandlerImpl;
import org.endless.tianyan.sales.components.market.trade.market.trade.application.query.anticorruption.MarketTradeQueryRepository;
import org.endless.tianyan.sales.components.market.trade.market.trade.application.query.handler.MarketTradeQueryHandler;
import org.endless.tianyan.sales.components.market.trade.market.trade.application.query.handler.impl.MarketTradeQueryHandlerImpl;
import org.endless.tianyan.sales.components.market.trade.market.trade.domain.anticorruption.MarketTradeRepository;
import org.endless.tianyan.sales.components.market.trade.market.trade.facade.adapter.MarketTradeDrivingAdapter;
import org.endless.tianyan.sales.components.market.trade.market.trade.facade.adapter.spring.SpringMarketTradeDrivingAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * MarketTradeDrivingConfiguration
 * <p>市场交易领域主动适配器配置类
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
public class MarketTradeDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean MarketTradeDrivingAdapter springMarketTradeDrivingAdapter(MarketTradeCommandHandler commandHandler, MarketTradeQueryHandler queryHandler) {
        return new SpringMarketTradeDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean MarketTradeCommandHandler marketTradeCommandHandler(MarketTradeRepository repository) {
        return new MarketTradeCommandHandlerImpl(repository);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean MarketTradeQueryHandler marketTradeQueryHandler(MarketTradeQueryRepository marketTradeQueryRepository) {
        return new MarketTradeQueryHandlerImpl(marketTradeQueryRepository);
    }
}
