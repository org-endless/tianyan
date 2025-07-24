package org.endless.tianyan.metadata.components.meta.group.game.eve.facade.adapter.config;

import org.endless.tianyan.metadata.components.meta.group.game.eve.application.command.handler.GameEveMetaGroupCommandHandler;
import org.endless.tianyan.metadata.components.meta.group.game.eve.application.command.handler.impl.GameEveMetaGroupCommandHandlerImpl;
import org.endless.tianyan.metadata.components.meta.group.game.eve.application.query.anticorruption.GameEveMetaGroupQueryRepository;
import org.endless.tianyan.metadata.components.meta.group.game.eve.application.query.handler.GameEveMetaGroupQueryHandler;
import org.endless.tianyan.metadata.components.meta.group.game.eve.application.query.handler.impl.GameEveMetaGroupQueryHandlerImpl;
import org.endless.tianyan.metadata.components.meta.group.game.eve.domain.anticorruption.GameEveMetaGroupRepository;
import org.endless.tianyan.metadata.components.meta.group.game.eve.facade.adapter.GameEveMetaGroupDrivingAdapter;
import org.endless.tianyan.metadata.components.meta.group.game.eve.facade.adapter.spring.SpringGameEveMetaGroupDrivingAdapter;
import org.endless.tianyan.metadata.components.meta.group.meta.group.facade.adapter.MetaGroupDrivingAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * GameEveMetaGroupDrivingConfiguration
 * <p>游戏EVE元分组领域主动适配器配置类
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@Lazy
@Configuration
public class GameEveMetaGroupDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean GameEveMetaGroupDrivingAdapter springGameEveMetaGroupDrivingAdapter(GameEveMetaGroupCommandHandler commandHandler, GameEveMetaGroupQueryHandler queryHandler) {
        return new SpringGameEveMetaGroupDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean GameEveMetaGroupCommandHandler gameEveMetaGroupCommandHandler(GameEveMetaGroupRepository repository, MetaGroupDrivingAdapter metaGroupDrivingAdapter) {
        return new GameEveMetaGroupCommandHandlerImpl(repository, metaGroupDrivingAdapter);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean GameEveMetaGroupQueryHandler gameEveMetaGroupQueryHandler(GameEveMetaGroupQueryRepository gameEveMetaGroupQueryRepository) {
        return new GameEveMetaGroupQueryHandlerImpl(gameEveMetaGroupQueryRepository);
    }
}
