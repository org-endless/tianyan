package org.endless.tianyan.sales.components.market.order.game.eve.facade.adapter.config;

import org.endless.tianyan.sales.components.market.order.game.eve.application.command.handler.GameEveMarketOrderCommandHandler;
import org.endless.tianyan.sales.components.market.order.game.eve.application.command.handler.impl.GameEveMarketOrderCommandHandlerImpl;
import org.endless.tianyan.sales.components.market.order.game.eve.application.query.anticorruption.GameEveMarketOrderQueryRepository;
import org.endless.tianyan.sales.components.market.order.game.eve.application.query.handler.GameEveMarketOrderQueryHandler;
import org.endless.tianyan.sales.components.market.order.game.eve.application.query.handler.impl.GameEveMarketOrderQueryHandlerImpl;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.anticorruption.GameEveMarketOrderDrivenAdapter;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.anticorruption.GameEveMarketOrderRepository;
import org.endless.tianyan.sales.components.market.order.game.eve.facade.adapter.GameEveMarketOrderDrivingAdapter;
import org.endless.tianyan.sales.components.market.order.game.eve.facade.adapter.spring.SpringGameEveMarketOrderDrivingAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * GameEveMarketOrderDrivingConfiguration
 * <p>游戏EVE市场订单领域主动适配器配置类
 * <p>
 * create 2025/07/25 11:19
 * <p>
 * update 2025/07/25 11:19
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@Lazy
@Configuration
public class GameEveMarketOrderDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean GameEveMarketOrderDrivingAdapter springGameEveMarketOrderDrivingAdapter(GameEveMarketOrderCommandHandler commandHandler, GameEveMarketOrderQueryHandler queryHandler) {
        return new SpringGameEveMarketOrderDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean GameEveMarketOrderCommandHandler gameEveMarketOrderCommandHandler(GameEveMarketOrderRepository repository, GameEveMarketOrderDrivenAdapter gameEveMarketOrderDrivenAdapter) {
        return new GameEveMarketOrderCommandHandlerImpl(repository, gameEveMarketOrderDrivenAdapter);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean GameEveMarketOrderQueryHandler gameEveMarketOrderQueryHandler(GameEveMarketOrderQueryRepository gameEveMarketOrderQueryRepository) {
        return new GameEveMarketOrderQueryHandlerImpl(gameEveMarketOrderQueryRepository);
    }
}
