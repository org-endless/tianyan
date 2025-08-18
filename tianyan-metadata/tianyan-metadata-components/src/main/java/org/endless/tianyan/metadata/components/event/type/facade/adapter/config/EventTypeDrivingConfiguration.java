package org.endless.tianyan.metadata.components.event.type.facade.adapter.config;

import org.endless.tianyan.metadata.components.event.type.application.command.handler.EventTypeCommandHandler;
import org.endless.tianyan.metadata.components.event.type.application.command.handler.impl.EventTypeCommandHandlerImpl;
import org.endless.tianyan.metadata.components.event.type.application.query.anticorruption.EventTypeQueryRepository;
import org.endless.tianyan.metadata.components.event.type.application.query.handler.EventTypeQueryHandler;
import org.endless.tianyan.metadata.components.event.type.application.query.handler.impl.EventTypeQueryHandlerImpl;
import org.endless.tianyan.metadata.components.event.type.domain.anticorruption.EventTypeRepository;
import org.endless.tianyan.metadata.components.event.type.facade.adapter.EventTypeDrivingAdapter;
import org.endless.tianyan.metadata.components.event.type.facade.adapter.spring.SpringEventTypeDrivingAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * EventTypeDrivingConfiguration
 * <p>事件类型领域主动适配器配置类
 * <p>
 * create 2025/07/28 18:41
 * <p>
 * update 2025/07/28 18:41
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@Lazy
@Configuration
public class EventTypeDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean EventTypeDrivingAdapter springEventTypeDrivingAdapter(EventTypeCommandHandler commandHandler, EventTypeQueryHandler queryHandler) {
        return new SpringEventTypeDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean EventTypeCommandHandler eventTypeCommandHandler(EventTypeRepository repository) {
        return new EventTypeCommandHandlerImpl(repository);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean EventTypeQueryHandler eventTypeQueryHandler(EventTypeQueryRepository eventTypeQueryRepository) {
        return new EventTypeQueryHandlerImpl(eventTypeQueryRepository);
    }
}
