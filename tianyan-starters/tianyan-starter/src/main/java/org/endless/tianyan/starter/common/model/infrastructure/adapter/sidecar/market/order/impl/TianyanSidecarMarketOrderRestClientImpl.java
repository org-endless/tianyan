package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.order.impl;

import org.endless.ddd.starter.common.config.rest.client.RestExchangeClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.order.TianyanSidecarMarketOrderRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.order.exchange.TianyanSidecarMarketOrderRestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.order.transfer.*;

import java.util.List;
import java.util.Optional;

/**
 * TianyanSidecarMarketOrderRestClientImpl
 * <p>市场订单REST客户端
 * <p>
 * create 2025/08/27 12:47
 * <p>
 * update 2025/08/27 12:47
 *
 * @author Deng Haozhi
 * @see TianyanSidecarMarketOrderRestClient
 * @since 1.0.0
 */
public class TianyanSidecarMarketOrderRestClientImpl implements TianyanSidecarMarketOrderRestClient {

    private final TianyanSidecarMarketOrderRestExchange marketOrderRestExchange;

    public TianyanSidecarMarketOrderRestClientImpl(RestExchangeClient restExchangeClient) {
        this.marketOrderRestExchange = restExchangeClient.exchange(TianyanSidecarMarketOrderRestExchange.class);
    }

    @Override
    public Optional<String> create(MarketOrderCreateDReqTransfer command) {
        return Optional.ofNullable(marketOrderRestExchange.create(command)
                .validate(MarketOrderCreateDRespTransfer.class)
                .marketOrderId());
    }

    @Override
    public void remove(MarketOrderRemoveDReqTransfer command) {
        marketOrderRestExchange.remove(command).validate();
    }

    @Override
    public void modify(MarketOrderModifyDReqTransfer command) {
        marketOrderRestExchange.modify(command).validate();
    }

    @Override
    public void generatePrice(MarketOrderGeneratePriceDReqTransfer command) {
        marketOrderRestExchange.generatePrice(command).validate();
    }

    @Override
    public List<String> findIdsByItemId(String itemId) {
        return marketOrderRestExchange.findIdsByItemId(FindByItemIdDReqTransfer.builder()
                        .itemId(itemId).build())
                .validate(FindMarketOrderIdsDRespTransfer.class)
                .marketOrderIds();
    }
}
