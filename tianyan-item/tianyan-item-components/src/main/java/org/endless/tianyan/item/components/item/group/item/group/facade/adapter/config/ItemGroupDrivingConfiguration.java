package org.endless.tianyan.item.components.item.group.item.group.facade.adapter.config;

import org.endless.tianyan.item.components.item.group.item.group.application.command.handler.ItemGroupCommandHandler;
import org.endless.tianyan.item.components.item.group.item.group.application.command.handler.impl.ItemGroupCommandHandlerImpl;
import org.endless.tianyan.item.components.item.group.item.group.application.query.anticorruption.ItemGroupQueryRepository;
import org.endless.tianyan.item.components.item.group.item.group.application.query.handler.ItemGroupQueryHandler;
import org.endless.tianyan.item.components.item.group.item.group.application.query.handler.impl.ItemGroupQueryHandlerImpl;
import org.endless.tianyan.item.components.item.group.item.group.domain.anticorruption.ItemGroupRepository;
import org.endless.tianyan.item.components.item.group.item.group.facade.adapter.ItemGroupDrivingAdapter;
import org.endless.tianyan.item.components.item.group.item.group.facade.adapter.spring.SpringItemGroupDrivingAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * ItemGroupDrivingConfiguration
 * <p>资源项分组领域主动适配器配置类
 * <p>
 * create 2025/07/21 16:04
 * <p>
 * update 2025/07/21 16:04
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@Lazy
@Configuration
public class ItemGroupDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean ItemGroupDrivingAdapter springItemGroupDrivingAdapter(ItemGroupCommandHandler commandHandler, ItemGroupQueryHandler queryHandler) {
        return new SpringItemGroupDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean ItemGroupCommandHandler itemGroupCommandHandler(ItemGroupRepository repository) {
        return new ItemGroupCommandHandlerImpl(repository);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean ItemGroupQueryHandler itemGroupQueryHandler(ItemGroupQueryRepository itemGroupQueryRepository) {
        return new ItemGroupQueryHandlerImpl(itemGroupQueryRepository);
    }
}
