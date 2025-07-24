package org.endless.tianyan.metadata.components.data.game.eve.facade.adapter.config;

import org.endless.tianyan.metadata.components.data.game.eve.application.command.handler.GameEveDataCommandHandler;
import org.endless.tianyan.metadata.components.data.game.eve.application.command.handler.impl.GameEveDataCommandHandlerImpl;
import org.endless.tianyan.metadata.components.data.game.eve.application.query.handler.GameEveDataQueryHandler;
import org.endless.tianyan.metadata.components.data.game.eve.application.query.handler.impl.GameEveDataQueryHandlerImpl;
import org.endless.tianyan.metadata.components.data.game.eve.domain.anticorruption.GameEveDataLoadDrivenAdapter;
import org.endless.tianyan.metadata.components.data.game.eve.facade.adapter.GameEveDataDrivingAdapter;
import org.endless.tianyan.metadata.components.data.game.eve.facade.adapter.spring.SpringGameEveDataDrivingAdapter;
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
    protected @Bean GameEveDataCommandHandler gameEveDataCommandHandler(GameEveDataLoadDrivenAdapter gameEveDataLoadDrivenAdapter) {
        return new GameEveDataCommandHandlerImpl(gameEveDataLoadDrivenAdapter);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean GameEveDataQueryHandler gameEveDataQueryHandler() {
        return new GameEveDataQueryHandlerImpl();
    }
}
