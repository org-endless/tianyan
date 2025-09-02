package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.price.price.impl;

import org.endless.ddd.starter.common.config.rest.client.RestExchangeClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.price.price.TianyanSidecarMarketPriceRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.price.price.exchange.TianyanSidecarMarketPriceRestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.price.price.transfer.MarketPriceCreateDReqTransfer;

/**
 * TianyanSidecarMarketPriceRestClientImpl
 * <p>
 * create 2025/08/27 12:27
 * <p>
 * update 2025/08/27 12:27
 *
 * @author Deng Haozhi
 * @see TianyanSidecarMarketPriceRestClient
 * @since 1.0.0
 */
public class TianyanSidecarMarketPriceRestClientImpl implements TianyanSidecarMarketPriceRestClient {

    private final TianyanSidecarMarketPriceRestExchange marketPriceRestExchange;

    public TianyanSidecarMarketPriceRestClientImpl(RestExchangeClient restExchangeClient) {
        this.marketPriceRestExchange = restExchangeClient.exchange(TianyanSidecarMarketPriceRestExchange.class);
    }

    @Override
    public void create(MarketPriceCreateDReqTransfer command) {
        marketPriceRestExchange.create(command).validate();
    }
}
