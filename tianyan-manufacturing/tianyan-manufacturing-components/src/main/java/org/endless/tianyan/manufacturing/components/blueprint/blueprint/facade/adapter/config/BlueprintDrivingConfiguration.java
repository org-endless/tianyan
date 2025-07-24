package org.endless.tianyan.manufacturing.components.blueprint.blueprint.facade.adapter.config;

import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.handler.*;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.handler.impl.*;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.query.handler.*;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.query.handler.impl.*;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.query.anticorruption.*;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.anticorruption.*;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.facade.adapter.*;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.facade.adapter.spring.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * BlueprintDrivingConfiguration
 * <p>蓝图领域主动适配器配置类
 * <p>
 * create 2025/07/23 17:17
 * <p>
 * update 2025/07/23 17:17
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@Lazy
@Configuration
public class BlueprintDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean BlueprintDrivingAdapter springBlueprintDrivingAdapter(BlueprintCommandHandler commandHandler, BlueprintQueryHandler queryHandler) {
        return new SpringBlueprintDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean BlueprintCommandHandler blueprintCommandHandler(BlueprintRepository repository) {
        return new BlueprintCommandHandlerImpl(repository);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean BlueprintQueryHandler blueprintQueryHandler(BlueprintQueryRepository blueprintQueryRepository, BlueprintMaterialQueryRepository blueprintMaterialQueryRepository, BlueprintSkillQueryRepository blueprintSkillQueryRepository, BlueprintProductQueryRepository blueprintProductQueryRepository) {
        return new BlueprintQueryHandlerImpl(blueprintQueryRepository, blueprintMaterialQueryRepository, blueprintSkillQueryRepository, blueprintProductQueryRepository);
    }
}
