package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.category.impl;

import org.endless.ddd.starter.common.config.rest.client.RestExchangeClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.category.TianyanSidecarItemCategoryRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.category.exchange.TianyanSidecarItemCategoryRestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.category.transfer.ItemCategoryCreateDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.category.transfer.ItemCategoryCreateDRespTransfer;

import java.util.Optional;

/**
 * TianyanCommonItemCategoryRestClientImpl
 * <p>
 * 资源项分类REST客户端实现类
 * <p>
 * create 2025/08/24 20:06
 * <p>
 * update 2025/08/24 20:06
 *
 * @author Deng Haozhi
 * @see TianyanSidecarItemCategoryRestClient
 * @since 1.0.0
 */
public class TianyanSidecarItemCategoryRestClientImpl implements TianyanSidecarItemCategoryRestClient {

    private final TianyanSidecarItemCategoryRestExchange itemCategoryRestExchange;

    public TianyanSidecarItemCategoryRestClientImpl(RestExchangeClient restExchangeClient) {
        this.itemCategoryRestExchange = restExchangeClient.exchange(TianyanSidecarItemCategoryRestExchange.class);
    }

    @Override
    public Optional<String> create(ItemCategoryCreateDReqTransfer command) {
        return Optional.ofNullable(itemCategoryRestExchange.create(command)
                .validate(ItemCategoryCreateDRespTransfer.class)
                .itemCategoryId());
    }
}
