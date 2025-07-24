package org.endless.tianyan.metadata.components.data.game.eve.facade.adapter.config;

import org.endless.tianyan.metadata.components.data.game.eve.application.command.handler.*;
import org.endless.tianyan.metadata.components.data.game.eve.application.command.handler.impl.*;
import org.endless.tianyan.metadata.components.data.game.eve.application.query.handler.*;
import org.endless.tianyan.metadata.components.data.game.eve.application.query.handler.impl.*;
import org.endless.tianyan.metadata.components.data.game.eve.application.query.anticorruption.*;
import org.endless.tianyan.metadata.components.data.game.eve.domain.anticorruption.*;
import org.endless.tianyan.metadata.components.data.game.eve.facade.adapter.*;
import org.endless.tianyan.metadata.components.data.game.eve.facade.adapter.spring.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * GameEveDataDrivingConfiguration
 * <p>游戏EVE数据领域主动适配器配置类
 * <p>
 * create 2025/07/24 08:49
 * <p>
 * update 2025/07/24 08:49
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@Lazy
@Configuration
public class GameEveDataDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean GameEveDataDrivingAdapter springGameEveDataDrivingAdapter(GameEveDataCommandHandler commandHandler, GameEveDataQueryHandler queryHandler) {
        return new SpringGameEveDataDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean GameEveDataCommandHandler gameEveDataCommandHandler(GameEveDataRepository repository) {
        return new GameEveDataCommandHandlerImpl(repository);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean GameEveDataQueryHandler gameEveDataQueryHandler(GameEveDataQueryRepository gameEveDataQueryRepository) {
        return new GameEveDataQueryHandlerImpl(gameEveDataQueryRepository);
    }
}
