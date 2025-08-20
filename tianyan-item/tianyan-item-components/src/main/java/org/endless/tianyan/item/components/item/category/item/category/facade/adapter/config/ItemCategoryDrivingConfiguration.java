package org.endless.tianyan.item.components.item.category.item.category.facade.adapter.config;

import org.endless.tianyan.item.components.item.category.item.category.application.command.handler.ItemCategoryCommandHandler;
import org.endless.tianyan.item.components.item.category.item.category.application.command.handler.impl.ItemCategoryCommandHandlerImpl;
import org.endless.tianyan.item.components.item.category.item.category.application.query.anticorruption.ItemCategoryQueryRepository;
import org.endless.tianyan.item.components.item.category.item.category.application.query.handler.ItemCategoryQueryHandler;
import org.endless.tianyan.item.components.item.category.item.category.application.query.handler.impl.ItemCategoryQueryHandlerImpl;
import org.endless.tianyan.item.components.item.category.item.category.domain.anticorruption.ItemCategoryRepository;
import org.endless.tianyan.item.components.item.category.item.category.facade.adapter.ItemCategoryDrivingAdapter;
import org.endless.tianyan.item.components.item.category.item.category.facade.adapter.spring.SpringItemCategoryDrivingAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * ItemCategoryDrivingConfiguration
 * <p>资源项分类领域主动适配器配置类
 * <p>
 * itemCreate 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@Lazy
@Configuration
public class ItemCategoryDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean ItemCategoryDrivingAdapter springItemCategoryDrivingAdapter(ItemCategoryCommandHandler commandHandler, ItemCategoryQueryHandler queryHandler) {
        return new SpringItemCategoryDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean ItemCategoryCommandHandler itemCategoryCommandHandler(ItemCategoryRepository repository) {
        return new ItemCategoryCommandHandlerImpl(repository);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean ItemCategoryQueryHandler itemCategoryQueryHandler(ItemCategoryQueryRepository itemCategoryQueryRepository) {
        return new ItemCategoryQueryHandlerImpl(itemCategoryQueryRepository);
    }
}
