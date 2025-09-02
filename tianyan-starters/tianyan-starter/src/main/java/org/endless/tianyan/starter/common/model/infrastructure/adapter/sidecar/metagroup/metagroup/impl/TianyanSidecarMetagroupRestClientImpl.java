package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.metagroup.impl;

import org.endless.ddd.starter.common.config.rest.client.RestExchangeClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.metagroup.TianyanSidecarMetagroupRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.metagroup.exchange.TianyanSidecarMetagroupRestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.metagroup.transfer.MetagroupCreateDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.metagroup.transfer.MetagroupCreateDRespTransfer;

import java.util.Optional;

/**
 * TianyanCommonMetagroupRestClientImpl
 * <p>元分组REST客户端
 * <p>
 * create 2025/08/24 19:00
 * <p>
 * update 2025/08/24 19:08
 *
 * @author Deng Haozhi
 * @see TianyanSidecarMetagroupRestClient
 * @since 1.0.0
 */
public class TianyanSidecarMetagroupRestClientImpl implements TianyanSidecarMetagroupRestClient {

    private final TianyanSidecarMetagroupRestExchange metagroupRestExchange;

    public TianyanSidecarMetagroupRestClientImpl(RestExchangeClient restExchangeClient) {
        this.metagroupRestExchange = restExchangeClient.exchange(TianyanSidecarMetagroupRestExchange.class);
    }

    @Override
    public Optional<String> create(MetagroupCreateDReqTransfer command) {
        return Optional.ofNullable(metagroupRestExchange.create(command)
                .validate(MetagroupCreateDRespTransfer.class)
                .metagroupId());
    }
}
