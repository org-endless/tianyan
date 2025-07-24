package org.endless.tianyan.manufacturing.components.blueprint.game.eve.facade.adapter.config;

import org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.command.handler.*;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.command.handler.impl.*;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.query.handler.*;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.query.handler.impl.*;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.query.anticorruption.*;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.domain.anticorruption.*;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.facade.adapter.*;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.facade.adapter.spring.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * GameEveBlueprintDrivingConfiguration
 * <p>游戏EVE蓝图领域主动适配器配置类
 * <p>
 * create 2025/07/24 09:18
 * <p>
 * update 2025/07/24 09:18
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@Lazy
@Configuration
public class GameEveBlueprintDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean GameEveBlueprintDrivingAdapter springGameEveBlueprintDrivingAdapter(GameEveBlueprintCommandHandler commandHandler, GameEveBlueprintQueryHandler queryHandler) {
        return new SpringGameEveBlueprintDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean GameEveBlueprintCommandHandler gameEveBlueprintCommandHandler(GameEveBlueprintRepository repository) {
        return new GameEveBlueprintCommandHandlerImpl(repository);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean GameEveBlueprintQueryHandler gameEveBlueprintQueryHandler(GameEveBlueprintQueryRepository gameEveBlueprintQueryRepository) {
        return new GameEveBlueprintQueryHandlerImpl(gameEveBlueprintQueryRepository);
    }
}
