package org.endless.tianyan.sales.components.market.game.eve.group.facade.adapter.config;

import org.endless.tianyan.sales.components.market.game.eve.group.application.command.handler.*;
import org.endless.tianyan.sales.components.market.game.eve.group.application.command.handler.impl.*;
import org.endless.tianyan.sales.components.market.game.eve.group.application.query.handler.*;
import org.endless.tianyan.sales.components.market.game.eve.group.application.query.handler.impl.*;
import org.endless.tianyan.sales.components.market.game.eve.group.application.query.anticorruption.*;
import org.endless.tianyan.sales.components.market.game.eve.group.domain.anticorruption.*;
import org.endless.tianyan.sales.components.market.game.eve.group.facade.adapter.*;
import org.endless.tianyan.sales.components.market.game.eve.group.facade.adapter.spring.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * GameEveMarketGroupDrivingConfiguration
 * <p>游戏EVE市场分组领域主动适配器配置类
 * <p>
 * create 2025/07/22 09:09
 * <p>
 * update 2025/07/22 09:09
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
    protected @Bean GameEveMarketGroupCommandHandler gameEveMarketGroupCommandHandler(GameEveMarketGroupRepository repository) {
        return new GameEveMarketGroupCommandHandlerImpl(repository);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean GameEveMarketGroupQueryHandler gameEveMarketGroupQueryHandler(GameEveMarketGroupQueryRepository gameEveMarketGroupQueryRepository) {
        return new GameEveMarketGroupQueryHandlerImpl(gameEveMarketGroupQueryRepository);
    }
}
