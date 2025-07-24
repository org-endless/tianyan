package org.endless.tianyan.sales.components.market.group.game.eve.facade.adapter.config;

import org.endless.tianyan.sales.components.market.group.game.eve.application.command.handler.GameEveMarketGroupCommandHandler;
import org.endless.tianyan.sales.components.market.group.game.eve.application.command.handler.impl.GameEveMarketGroupCommandHandlerImpl;
import org.endless.tianyan.sales.components.market.group.game.eve.application.query.anticorruption.GameEveMarketGroupQueryRepository;
import org.endless.tianyan.sales.components.market.group.game.eve.application.query.handler.GameEveMarketGroupQueryHandler;
import org.endless.tianyan.sales.components.market.group.game.eve.application.query.handler.impl.GameEveMarketGroupQueryHandlerImpl;
import org.endless.tianyan.sales.components.market.group.game.eve.domain.anticorruption.GameEveMarketGroupRepository;
import org.endless.tianyan.sales.components.market.group.game.eve.facade.adapter.GameEveMarketGroupDrivingAdapter;
import org.endless.tianyan.sales.components.market.group.game.eve.facade.adapter.spring.SpringGameEveMarketGroupDrivingAdapter;
import org.endless.tianyan.sales.components.market.group.market.group.facade.adapter.MarketGroupDrivingAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * GameEveMarketGroupDrivingConfiguration
 * <p>游戏EVE市场分组领域主动适配器配置类
 * <p>
 * create 2025/07/24 17:37
 * <p>
 * update 2025/07/24 17:37
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@Lazy
@Configuration
public class GameEveMarketGroupDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean GameEveMarketGroupDrivingAdapter springGameEveMarketGroupDrivingAdapter(GameEveMarketGroupCommandHandler commandHandler, GameEveMarketGroupQueryHandler queryHandler) {
        return new SpringGameEveMarketGroupDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean GameEveMarketGroupCommandHandler gameEveMarketGroupCommandHandler(GameEveMarketGroupRepository repository, MarketGroupDrivingAdapter marketGroupDrivingAdapter) {
        return new GameEveMarketGroupCommandHandlerImpl(repository, marketGroupDrivingAdapter);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean GameEveMarketGroupQueryHandler gameEveMarketGroupQueryHandler(GameEveMarketGroupQueryRepository gameEveMarketGroupQueryRepository) {
        return new GameEveMarketGroupQueryHandlerImpl(gameEveMarketGroupQueryRepository);
    }
}
