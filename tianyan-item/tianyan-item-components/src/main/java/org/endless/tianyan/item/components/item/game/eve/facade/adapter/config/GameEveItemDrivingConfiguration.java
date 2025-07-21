package org.endless.tianyan.item.components.item.game.eve.facade.adapter.config;

import org.endless.tianyan.item.components.item.game.eve.application.command.handler.*;
import org.endless.tianyan.item.components.item.game.eve.application.command.handler.impl.*;
import org.endless.tianyan.item.components.item.game.eve.application.query.handler.*;
import org.endless.tianyan.item.components.item.game.eve.application.query.handler.impl.*;
import org.endless.tianyan.item.components.item.game.eve.application.query.anticorruption.*;
import org.endless.tianyan.item.components.item.game.eve.domain.anticorruption.*;
import org.endless.tianyan.item.components.item.game.eve.facade.adapter.*;
import org.endless.tianyan.item.components.item.game.eve.facade.adapter.spring.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * GameEveItemDrivingConfiguration
 * <p>游戏EVE物品领域主动适配器配置类
 * <p>
 * create 2025/07/19 09:28
 * <p>
 * update 2025/07/19 09:28
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@Lazy
@Configuration
public class GameEveItemDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean GameEveItemDrivingAdapter springGameEveItemDrivingAdapter(GameEveItemCommandHandler commandHandler, GameEveItemQueryHandler queryHandler) {
        return new SpringGameEveItemDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean GameEveItemCommandHandler gameEveItemCommandHandler(GameEveItemRepository repository) {
        return new GameEveItemCommandHandlerImpl(repository);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean GameEveItemQueryHandler gameEveItemQueryHandler(GameEveItemQueryRepository gameEveItemQueryRepository) {
        return new GameEveItemQueryHandlerImpl(gameEveItemQueryRepository);
    }
}
