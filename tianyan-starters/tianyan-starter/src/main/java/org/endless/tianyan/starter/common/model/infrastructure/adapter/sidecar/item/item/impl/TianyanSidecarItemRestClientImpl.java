package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.item.impl;

import org.endless.ddd.starter.common.config.rest.client.RestExchangeClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.item.TianyanSidecarItemRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.item.exchange.TianyanSidecarItemRestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.item.transfer.ItemCreateDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.item.transfer.ItemCreateDRespTransfer;

import java.util.Optional;

/**
 * TianyanCommonItemRestClientImpl
 * <p>
 * create 2025/08/24 19:38
 * <p>
 * update 2025/08/24 19:38
 *
 * @author Deng Haozhi
 * @see TianyanSidecarItemRestClient
 * @since 1.0.0
 */
public class TianyanSidecarItemRestClientImpl implements TianyanSidecarItemRestClient {

    private final TianyanSidecarItemRestExchange itemRestExchange;

    public TianyanSidecarItemRestClientImpl(RestExchangeClient restExchangeClient) {
        this.itemRestExchange = restExchangeClient.exchange(TianyanSidecarItemRestExchange.class);
    }

    @Override
    public Optional<String> create(ItemCreateDReqTransfer command) {
        return Optional.ofNullable(itemRestExchange.create(command)
                .validate(ItemCreateDRespTransfer.class)
                .itemId());
    }
}
