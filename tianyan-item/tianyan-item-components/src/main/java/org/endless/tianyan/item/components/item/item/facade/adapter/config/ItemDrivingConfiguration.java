package org.endless.tianyan.item.components.item.item.facade.adapter.config;

import org.endless.tianyan.item.components.item.item.application.command.handler.*;
import org.endless.tianyan.item.components.item.item.application.command.handler.impl.*;
import org.endless.tianyan.item.components.item.item.application.query.handler.*;
import org.endless.tianyan.item.components.item.item.application.query.handler.impl.*;
import org.endless.tianyan.item.components.item.item.application.query.anticorruption.*;
import org.endless.tianyan.item.components.item.item.domain.anticorruption.*;
import org.endless.tianyan.item.components.item.item.facade.adapter.*;
import org.endless.tianyan.item.components.item.item.facade.adapter.spring.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * ItemDrivingConfiguration
 * <p>物品领域主动适配器配置类
 * <p>
 * create 2025/07/19 07:15
 * <p>
 * update 2025/07/19 07:15
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
