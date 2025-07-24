package org.endless.tianyan.metadata.components.meta.group.meta.group.facade.adapter.config;

import org.endless.tianyan.metadata.components.meta.group.meta.group.application.command.handler.*;
import org.endless.tianyan.metadata.components.meta.group.meta.group.application.command.handler.impl.*;
import org.endless.tianyan.metadata.components.meta.group.meta.group.application.query.handler.*;
import org.endless.tianyan.metadata.components.meta.group.meta.group.application.query.handler.impl.*;
import org.endless.tianyan.metadata.components.meta.group.meta.group.application.query.anticorruption.*;
import org.endless.tianyan.metadata.components.meta.group.meta.group.domain.anticorruption.*;
import org.endless.tianyan.metadata.components.meta.group.meta.group.facade.adapter.*;
import org.endless.tianyan.metadata.components.meta.group.meta.group.facade.adapter.spring.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * MetaGroupDrivingConfiguration
 * <p>元分组领域主动适配器配置类
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
public class MetaGroupDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean MetaGroupDrivingAdapter springMetaGroupDrivingAdapter(MetaGroupCommandHandler commandHandler, MetaGroupQueryHandler queryHandler) {
        return new SpringMetaGroupDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean MetaGroupCommandHandler metaGroupCommandHandler(MetaGroupRepository repository) {
        return new MetaGroupCommandHandlerImpl(repository);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean MetaGroupQueryHandler metaGroupQueryHandler(MetaGroupQueryRepository metaGroupQueryRepository) {
        return new MetaGroupQueryHandlerImpl(metaGroupQueryRepository);
    }
}
