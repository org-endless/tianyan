package org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.market.impl;

import org.endless.ddd.starter.common.config.rest.client.RestExchangeClient;
import org.endless.ddd.starter.common.ddd.common.transfer.FindPageRespTransfer;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.market.GameEveESIMarketRestClient;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.market.exchange.GameEveESIMarketOrderRestExchange;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.market.transfer.FindESIMarketItemPageDReqTransfer;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.market.transfer.FindESIMarketOrderDRespTransfer;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.market.transfer.FindESIMarketOrderPageDReqTransfer;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.market.transfer.FindGameEveItemCodeDRespTransfer;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * GameEveESIMarketOrderRestClientImpl
 * <p>
 * create 2025/08/27 00:06
 * <p>
 * update 2025/08/27 00:06
 *
 * @author Deng Haozhi
 * @see GameEveESIMarketRestClient
 * @since 1.0.0
 */
public class GameEveESIMarketOrderRestClientImpl implements GameEveESIMarketRestClient {

    private final GameEveESIMarketOrderRestExchange gameEveESIMarketOrderRestExchange;

    public GameEveESIMarketOrderRestClientImpl(RestExchangeClient restExchangeClient) {
        this.gameEveESIMarketOrderRestExchange = restExchangeClient.exchange(GameEveESIMarketOrderRestExchange.class);
    }

    @Override
    public FindPageRespTransfer<FindESIMarketOrderDRespTransfer> fetchMarketOrders(FindESIMarketOrderPageDReqTransfer query) {
        ResponseEntity<List<FindESIMarketOrderDRespTransfer>> response = validate(gameEveESIMarketOrderRestExchange
                .fetchMarketOrders(query.regionId(), DATASOURCE, query.orderType(), query.gameEveItemCode(), query.page()));
        return FindPageRespTransfer.<FindESIMarketOrderDRespTransfer>builder()
                .rows(response.getBody())
                .pageNum(query.page())
                .pageSize(query.page())
                .total(pageTotal(response))
                .build().validate();
    }

    @Override
    public FindPageRespTransfer<FindGameEveItemCodeDRespTransfer> fetchMarketItemCodes(FindESIMarketItemPageDReqTransfer query) {
        ResponseEntity<List<String>> response = validate(gameEveESIMarketOrderRestExchange
                .fetchMarketItemCodes(query.regionId(), DATASOURCE, query.page()));
        return FindPageRespTransfer.<FindGameEveItemCodeDRespTransfer>builder()
                .rows(CollectionUtils.isEmpty(response.getBody())
                        ? Collections.emptyList()
                        : response.getBody().stream()
                        .map(code -> FindGameEveItemCodeDRespTransfer.builder()
                                .gameEveItemCode(code)
                                .build())
                        .toList())
                .pageNum(query.page())
                .pageSize(query.page())
                .total(pageTotal(response))
                .build().validate();
    }
}
