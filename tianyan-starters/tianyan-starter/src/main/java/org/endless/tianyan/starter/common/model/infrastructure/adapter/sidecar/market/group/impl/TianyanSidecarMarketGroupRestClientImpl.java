package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.group.impl;

import org.endless.ddd.starter.common.config.rest.client.RestExchangeClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.group.TianyanSidecarMarketGroupRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.group.exchange.TianyanSidecarMarketGroupRestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.group.transfer.MarketGroupCreateDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.group.transfer.MarketGroupCreateDRespTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.group.transfer.MarketGroupModifyParentDReqTransfer;

import java.util.Optional;

/**
 * TianyanCommonMarketGroupRestClientImpl
 * <p>市场分组REST客户端
 * <p>
 * create 2025/08/24 19:25
 * <p>
 * update 2025/08/24 19:25
 * update 2025/08/24 19:25
 *
 * @author Deng Haozhi
 * @see TianyanSidecarMarketGroupRestClient
 * @since 1.0.0
 */
public class TianyanSidecarMarketGroupRestClientImpl implements TianyanSidecarMarketGroupRestClient {

    private final TianyanSidecarMarketGroupRestExchange marketGroupRestExchange;

    public TianyanSidecarMarketGroupRestClientImpl(RestExchangeClient restExchangeClient) {
        this.marketGroupRestExchange = restExchangeClient.exchange(TianyanSidecarMarketGroupRestExchange.class);
    }

    @Override
    public Optional<String> create(MarketGroupCreateDReqTransfer command) {
        return Optional.ofNullable(marketGroupRestExchange.create(command)
                .validate(MarketGroupCreateDRespTransfer.class).marketGroupId());
    }

    @Override
    public void modifyParent(MarketGroupModifyParentDReqTransfer command) {
        marketGroupRestExchange.modifyParent(command).validate();
    }
}
