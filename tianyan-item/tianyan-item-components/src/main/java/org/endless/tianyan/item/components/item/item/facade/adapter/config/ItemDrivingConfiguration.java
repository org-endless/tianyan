package org.endless.tianyan.item.components.item.item.facade.adapter.config;

import org.endless.tianyan.item.components.item.item.application.command.handler.ItemCommandHandler;
import org.endless.tianyan.item.components.item.item.application.command.handler.impl.ItemCommandHandlerImpl;
import org.endless.tianyan.item.components.item.item.application.query.anticorruption.ItemQueryRepository;
import org.endless.tianyan.item.components.item.item.application.query.handler.ItemQueryHandler;
import org.endless.tianyan.item.components.item.item.application.query.handler.impl.ItemQueryHandlerImpl;
import org.endless.tianyan.item.components.item.item.domain.anticorruption.ItemRepository;
import org.endless.tianyan.item.components.item.item.facade.adapter.ItemDrivingAdapter;
import org.endless.tianyan.item.components.item.item.facade.adapter.spring.SpringItemDrivingAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * ItemDrivingConfiguration
 * <p>资源项领域主动适配器配置类
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
public class ItemDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean ItemDrivingAdapter springItemDrivingAdapter(ItemCommandHandler commandHandler, ItemQueryHandler queryHandler) {
        return new SpringItemDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean ItemCommandHandler itemCommandHandler(ItemRepository repository) {
        return new ItemCommandHandlerImpl(repository);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean ItemQueryHandler itemQueryHandler(ItemQueryRepository itemQueryRepository) {
        return new ItemQueryHandlerImpl(itemQueryRepository);
    }
}
