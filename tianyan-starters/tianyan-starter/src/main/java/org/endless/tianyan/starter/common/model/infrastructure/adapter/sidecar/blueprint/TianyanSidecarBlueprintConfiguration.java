package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint;

import org.endless.ddd.starter.common.config.rest.client.RestExchangeClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.blueprint.TianyanSidecarBlueprintRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.blueprint.impl.TianyanSidecarBlueprintRestClientImpl;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.game.eve.blueprint.TianyanSidecarGameEveBlueprintRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.game.eve.blueprint.impl.TianyanSidecarGameEveBlueprintRestClientImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * TianyanCommonBlueprintConfiguration
 * <p>
 * 蓝图配置类
 * <p>
 * create 2025/08/24 19:42
 * <p>
 * update 2025/08/24 20:03
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class TianyanSidecarBlueprintConfiguration {

    @Lazy
    @ConditionalOnMissingBean
    public @Bean TianyanSidecarBlueprintRestClient tianyanBlueprintRestClient(RestExchangeClient restExchangeClient) {
        return new TianyanSidecarBlueprintRestClientImpl(restExchangeClient);
    }

    @Lazy
    @ConditionalOnMissingBean
    public @Bean TianyanSidecarGameEveBlueprintRestClient tianyanGameEveBlueprintRestClient(RestExchangeClient restExchangeClient) {
        return new TianyanSidecarGameEveBlueprintRestClientImpl(restExchangeClient);
    }
}
