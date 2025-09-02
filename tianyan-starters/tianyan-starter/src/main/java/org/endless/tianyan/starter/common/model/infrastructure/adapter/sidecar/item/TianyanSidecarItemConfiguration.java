package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item;

import org.endless.ddd.starter.common.config.rest.client.RestExchangeClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.category.TianyanSidecarItemCategoryRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.category.impl.TianyanSidecarItemCategoryRestClientImpl;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.category.TianyanSidecarGameEveItemCategoryRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.category.impl.TianyanSidecarGameEveItemCategoryRestClientImpl;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.group.TianyanSidecarGameEveItemGroupRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.group.impl.TianyanSidecarGameEveItemGroupRestClientImpl;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.item.TianyanSidecarGameEveItemRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.item.impl.TianyanSidecarGameEveItemRestClientImpl;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.group.TianyanSidecarItemGroupRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.group.impl.TianyanSidecarItemGroupRestClientImpl;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.item.TianyanSidecarItemRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.item.impl.TianyanSidecarItemRestClientImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * TianyanCommonItemConfiguration
 * <p>
 * 资源项配置类
 * <p>
 * create 2025/08/24 19:37
 * <p>
 * update 2025/08/24 20:10
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class TianyanSidecarItemConfiguration {

    @Lazy
    @ConditionalOnMissingBean
    public @Bean TianyanSidecarItemRestClient tianyanItemRestClient(RestExchangeClient restExchangeClient) {
        return new TianyanSidecarItemRestClientImpl(restExchangeClient);
    }

    @Lazy
    @ConditionalOnMissingBean
    public @Bean TianyanSidecarItemCategoryRestClient tianyanItemCategoryRestClient(RestExchangeClient restExchangeClient) {
        return new TianyanSidecarItemCategoryRestClientImpl(restExchangeClient);
    }

    @Lazy
    @ConditionalOnMissingBean
    public @Bean TianyanSidecarItemGroupRestClient tianyanItemGroupRestClient(RestExchangeClient restExchangeClient) {
        return new TianyanSidecarItemGroupRestClientImpl(restExchangeClient);
    }

    @Lazy
    @ConditionalOnMissingBean
    public @Bean TianyanSidecarGameEveItemRestClient tianyanGameEveItemRestClient(RestExchangeClient restExchangeClient) {
        return new TianyanSidecarGameEveItemRestClientImpl(restExchangeClient);
    }

    @Lazy
    @ConditionalOnMissingBean
    public @Bean TianyanSidecarGameEveItemCategoryRestClient tianyanGameEveItemCategoryRestClient(RestExchangeClient restExchangeClient) {
        return new TianyanSidecarGameEveItemCategoryRestClientImpl(restExchangeClient);
    }

    @Lazy
    @ConditionalOnMissingBean
    public @Bean TianyanSidecarGameEveItemGroupRestClient tianyanGameEveItemGroupRestClient(RestExchangeClient restExchangeClient) {
        return new TianyanSidecarGameEveItemGroupRestClientImpl(restExchangeClient);
    }
}
