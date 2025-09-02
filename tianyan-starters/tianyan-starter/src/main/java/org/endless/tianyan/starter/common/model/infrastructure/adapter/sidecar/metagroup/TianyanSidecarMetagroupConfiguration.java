package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup;

import org.endless.ddd.starter.common.config.rest.client.RestExchangeClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.game.eve.TianyanSidecarGameEveMetagroupRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.game.eve.impl.TianyanSidecarGameEveMetagroupRestClientImpl;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.metagroup.TianyanSidecarMetagroupRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.metagroup.impl.TianyanSidecarMetagroupRestClientImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * TianyanCommonMetagroupConfiguration
 * <p>
 * create 2025/08/24 19:02
 * <p>
 * update 2025/08/24 19:02
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class TianyanSidecarMetagroupConfiguration {

    @Lazy
    @ConditionalOnMissingBean
    public @Bean TianyanSidecarMetagroupRestClient tianyanMetagroupRestClient(RestExchangeClient restExchangeClient) {
        return new TianyanSidecarMetagroupRestClientImpl(restExchangeClient);
    }

    @Lazy
    @ConditionalOnMissingBean
    public @Bean TianyanSidecarGameEveMetagroupRestClient tianyanGameEveMetagroupRestClient(RestExchangeClient restExchangeClient) {
        return new TianyanSidecarGameEveMetagroupRestClientImpl(restExchangeClient);
    }
}
