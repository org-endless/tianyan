package org.endless.tianyan.item.components.item.group.game.eve.facade.adapter.config;

import org.endless.tianyan.item.components.item.group.game.eve.application.command.handler.GameEveItemGroupCommandHandler;
import org.endless.tianyan.item.components.item.group.game.eve.application.command.handler.impl.GameEveItemGroupCommandHandlerImpl;
import org.endless.tianyan.item.components.item.group.game.eve.application.query.anticorruption.GameEveItemGroupQueryRepository;
import org.endless.tianyan.item.components.item.group.game.eve.application.query.handler.GameEveItemGroupQueryHandler;
import org.endless.tianyan.item.components.item.group.game.eve.application.query.handler.impl.GameEveItemGroupQueryHandlerImpl;
import org.endless.tianyan.item.components.item.group.game.eve.domain.anticorruption.GameEveItemGroupRepository;
import org.endless.tianyan.item.components.item.group.game.eve.facade.adapter.GameEveItemGroupDrivingAdapter;
import org.endless.tianyan.item.components.item.group.game.eve.facade.adapter.spring.SpringGameEveItemGroupDrivingAdapter;
import org.endless.tianyan.item.components.item.group.item.group.facade.adapter.ItemGroupDrivingAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * GameEveItemGroupDrivingConfiguration
 * <p>游戏EVE物品分组领域主动适配器配置类
 * <p>
 * create 2025/07/21 16:03
 * <p>
 * update 2025/07/21 16:03
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@Lazy
@Configuration
public class GameEveItemGroupDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean GameEveItemGroupDrivingAdapter springGameEveItemGroupDrivingAdapter(GameEveItemGroupCommandHandler commandHandler, GameEveItemGroupQueryHandler queryHandler) {
        return new SpringGameEveItemGroupDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean GameEveItemGroupCommandHandler gameEveItemGroupCommandHandler(GameEveItemGroupRepository repository, ItemGroupDrivingAdapter itemGroupDrivingAdapter) {
        return new GameEveItemGroupCommandHandlerImpl(repository, itemGroupDrivingAdapter);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean GameEveItemGroupQueryHandler gameEveItemGroupQueryHandler(GameEveItemGroupQueryRepository gameEveItemGroupQueryRepository) {
        return new GameEveItemGroupQueryHandlerImpl(gameEveItemGroupQueryRepository);
    }
}
