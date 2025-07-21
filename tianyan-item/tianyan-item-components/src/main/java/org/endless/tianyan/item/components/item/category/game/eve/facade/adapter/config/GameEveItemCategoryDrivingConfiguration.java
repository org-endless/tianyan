package org.endless.tianyan.item.components.item.category.game.eve.facade.adapter.config;

import org.endless.tianyan.item.components.item.category.game.eve.application.command.handler.GameEveItemCategoryCommandHandler;
import org.endless.tianyan.item.components.item.category.game.eve.application.command.handler.impl.GameEveItemCategoryCommandHandlerImpl;
import org.endless.tianyan.item.components.item.category.game.eve.application.query.anticorruption.GameEveItemCategoryQueryRepository;
import org.endless.tianyan.item.components.item.category.game.eve.application.query.handler.GameEveItemCategoryQueryHandler;
import org.endless.tianyan.item.components.item.category.game.eve.application.query.handler.impl.GameEveItemCategoryQueryHandlerImpl;
import org.endless.tianyan.item.components.item.category.game.eve.domain.anticorruption.GameEveItemCategoryRepository;
import org.endless.tianyan.item.components.item.category.game.eve.facade.adapter.GameEveItemCategoryDrivingAdapter;
import org.endless.tianyan.item.components.item.category.game.eve.facade.adapter.spring.SpringGameEveItemCategoryDrivingAdapter;
import org.endless.tianyan.item.components.item.category.item.category.facade.adapter.ItemCategoryDrivingAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * GameEveItemCategoryDrivingConfiguration
 * <p>游戏EVE物品分类领域主动适配器配置类
 * <p>
 * create 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@Lazy
@Configuration
public class GameEveItemCategoryDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean GameEveItemCategoryDrivingAdapter springGameEveItemCategoryDrivingAdapter(GameEveItemCategoryCommandHandler commandHandler, GameEveItemCategoryQueryHandler queryHandler) {
        return new SpringGameEveItemCategoryDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean GameEveItemCategoryCommandHandler gameEveItemCategoryCommandHandler(GameEveItemCategoryRepository repository, ItemCategoryDrivingAdapter itemCategoryDrivingAdapter) {
        return new GameEveItemCategoryCommandHandlerImpl(repository, itemCategoryDrivingAdapter);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean GameEveItemCategoryQueryHandler gameEveItemCategoryQueryHandler(GameEveItemCategoryQueryRepository gameEveItemCategoryQueryRepository) {
        return new GameEveItemCategoryQueryHandlerImpl(gameEveItemCategoryQueryRepository);
    }
}
