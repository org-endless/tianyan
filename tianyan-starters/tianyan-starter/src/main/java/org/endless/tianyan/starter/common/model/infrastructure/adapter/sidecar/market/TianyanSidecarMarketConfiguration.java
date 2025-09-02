package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market;

import org.endless.ddd.starter.common.config.rest.client.RestExchangeClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.game.eve.group.TianyanSidecarGameEveMarketGroupRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.game.eve.group.impl.TianyanSidecarGameEveMarketGroupRestClientImpl;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.group.TianyanSidecarMarketGroupRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.group.impl.TianyanSidecarMarketGroupRestClientImpl;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.order.TianyanSidecarMarketOrderRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.order.impl.TianyanSidecarMarketOrderRestClientImpl;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.price.price.TianyanSidecarMarketPriceRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.price.price.impl.TianyanSidecarMarketPriceRestClientImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * TianyanCommonMarketConfiguration
 * <p>
 * create 2025/08/24 19:24
 * <p>
 * update 2025/08/24 19:24
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class TianyanSidecarMarketConfiguration {

    @Lazy
    @ConditionalOnMissingBean
    public @Bean TianyanSidecarMarketGroupRestClient tianyanMarketGroupRestClient(RestExchangeClient restExchangeClient) {
        return new TianyanSidecarMarketGroupRestClientImpl(restExchangeClient);
    }

    @Lazy
    @ConditionalOnMissingBean
    public @Bean TianyanSidecarGameEveMarketGroupRestClient tianyanGameEveMarketGroupRestClient(RestExchangeClient restExchangeClient) {
        return new TianyanSidecarGameEveMarketGroupRestClientImpl(restExchangeClient);
    }

    @Lazy
    @ConditionalOnMissingBean
    public @Bean TianyanSidecarMarketOrderRestClient tianyanMarketOrderRestClient(RestExchangeClient restExchangeClient) {
        return new TianyanSidecarMarketOrderRestClientImpl(restExchangeClient);
    }

    @Lazy
    @ConditionalOnMissingBean
    public @Bean TianyanSidecarMarketPriceRestClient tianyanMarketPriceRestClient(RestExchangeClient restExchangeClient) {
        return new TianyanSidecarMarketPriceRestClientImpl(restExchangeClient);
    }
}
