package org.endless.tianyan.item.components.item.game.eve.facade.adapter.config;

import org.endless.tianyan.item.components.item.game.eve.application.command.handler.GameEveItemCommandHandler;
import org.endless.tianyan.item.components.item.game.eve.application.command.handler.impl.GameEveItemCommandHandlerImpl;
import org.endless.tianyan.item.components.item.game.eve.application.query.anticorruption.GameEveItemQueryRepository;
import org.endless.tianyan.item.components.item.game.eve.application.query.handler.GameEveItemQueryHandler;
import org.endless.tianyan.item.components.item.game.eve.application.query.handler.impl.GameEveItemQueryHandlerImpl;
import org.endless.tianyan.item.components.item.game.eve.domain.anticorruption.GameEveItemDrivenAdapter;
import org.endless.tianyan.item.components.item.game.eve.domain.anticorruption.GameEveItemRepository;
import org.endless.tianyan.item.components.item.game.eve.facade.adapter.GameEveItemDrivingAdapter;
import org.endless.tianyan.item.components.item.game.eve.facade.adapter.spring.SpringGameEveItemDrivingAdapter;
import org.endless.tianyan.item.components.item.item.facade.adapter.ItemDrivingAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * GameEveItemDrivingConfiguration
 * <p>游戏EVE资源项领域主动适配器配置类
 * <p>
 * create 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
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
    protected @Bean GameEveItemCommandHandler gameEveItemCommandHandler(GameEveItemRepository repository, ItemDrivingAdapter itemDrivingAdapter, GameEveItemDrivenAdapter gameEveItemDrivenAdapter) {
        return new GameEveItemCommandHandlerImpl(repository, itemDrivingAdapter, gameEveItemDrivenAdapter);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean GameEveItemQueryHandler gameEveItemQueryHandler(GameEveItemQueryRepository gameEveItemQueryRepository) {
        return new GameEveItemQueryHandlerImpl(gameEveItemQueryRepository);
    }
}
