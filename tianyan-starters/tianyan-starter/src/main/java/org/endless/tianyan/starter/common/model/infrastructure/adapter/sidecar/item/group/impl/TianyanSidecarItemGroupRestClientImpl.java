package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.group.impl;

import org.endless.ddd.starter.common.config.rest.client.RestExchangeClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.group.TianyanSidecarItemGroupRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.group.exchange.TianyanSidecarItemGroupRestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.group.transfer.ItemGroupCreateDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.group.transfer.ItemGroupCreateDRespTransfer;

import java.util.Optional;

/**
 * TianyanCommonItemGroupRestClientImpl
 * <p>
 * 资源项分组REST客户端实现类
 * <p>
 * create 2025/08/24 20:07
 * <p>
 * update 2025/08/24 20:07
 *
 * @author Deng Haozhi
 * @see TianyanSidecarItemGroupRestClient
 * @since 1.0.0
 */
public class TianyanSidecarItemGroupRestClientImpl implements TianyanSidecarItemGroupRestClient {

    private final TianyanSidecarItemGroupRestExchange itemGroupRestExchange;

    public TianyanSidecarItemGroupRestClientImpl(RestExchangeClient restExchangeClient) {
        this.itemGroupRestExchange = restExchangeClient.exchange(TianyanSidecarItemGroupRestExchange.class);
    }

    @Override
    public Optional<String> create(ItemGroupCreateDReqTransfer command) {
        return Optional.ofNullable(itemGroupRestExchange.create(command)
                .validate(ItemGroupCreateDRespTransfer.class)
                .itemGroupId());
    }
}
