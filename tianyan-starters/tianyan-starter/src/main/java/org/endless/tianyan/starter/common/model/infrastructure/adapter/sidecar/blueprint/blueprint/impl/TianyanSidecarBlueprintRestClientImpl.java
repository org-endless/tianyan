package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.blueprint.impl;

import org.endless.ddd.starter.common.config.rest.client.RestExchangeClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.blueprint.TianyanSidecarBlueprintRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.blueprint.exchange.TianyanSidecarBlueprintRestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.blueprint.transfer.BlueprintCreateDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.blueprint.transfer.BlueprintCreateDRespTransfer;

import java.util.Optional;

/**
 * TianyanCommonBlueprintRestClientImpl
 * <p>
 * 蓝图REST客户端实现类
 * <p>
 * create 2025/08/24 19:55
 * <p>
 * update 2025/08/24 19:55
 *
 * @author Deng Haozhi
 * @see TianyanSidecarBlueprintRestClient
 * @since 1.0.0
 */
public class TianyanSidecarBlueprintRestClientImpl implements TianyanSidecarBlueprintRestClient {

    private final TianyanSidecarBlueprintRestExchange blueprintRestExchange;

    public TianyanSidecarBlueprintRestClientImpl(RestExchangeClient restExchangeClient) {
        this.blueprintRestExchange = restExchangeClient.exchange(TianyanSidecarBlueprintRestExchange.class);
    }

    @Override
    public Optional<String> create(BlueprintCreateDReqTransfer command) {
        return Optional.ofNullable(blueprintRestExchange.blueprintCreate(command)
                .validate(BlueprintCreateDRespTransfer.class)
                .blueprintId());
    }
}
