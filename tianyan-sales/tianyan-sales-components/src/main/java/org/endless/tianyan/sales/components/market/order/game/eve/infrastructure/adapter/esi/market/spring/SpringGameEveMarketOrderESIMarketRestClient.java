package org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.esi.market.spring;

import org.endless.ddd.simplified.starter.common.model.common.transfer.FindPageRespTransfer;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.esi.market.GameEveMarketOrderESIMarketRestClient;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.esi.market.transfer.GameEveMarketOrderESIMarketExchangeTransfer;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.transfer.ESIMarketItemFindPageReqDTransfer;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.transfer.ESIMarketOrderFindPageReqDTransfer;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.transfer.ESIMarketOrderFindProfileRespDTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

/**
 * SpringGameEveMarketOrderESIMarketRestClient
 * <p>
 * create 2025/07/25 11:42
 * <p>
 * update 2025/07/28 04:56
 *
 * @author Deng Haozhi
 * @see GameEveMarketOrderESIMarketRestClient
 * @since 0.0.1
 */
@Lazy
@Component
public class SpringGameEveMarketOrderESIMarketRestClient implements GameEveMarketOrderESIMarketRestClient {

    private final RestClient restClient;

    public SpringGameEveMarketOrderESIMarketRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public FindPageRespTransfer fetchMarketOrderPage(ESIMarketOrderFindPageReqDTransfer query) {
        ResponseEntity<List<ESIMarketOrderFindProfileRespDTransfer>> response = exchange(restClient, GameEveMarketOrderESIMarketExchangeTransfer.class)
                .fetchMarketOrders(query.getRegionId(), DATASOURCE, query.getOrderType(), query.getGameEveItemCode(), query.getPage());
        return FindPageRespTransfer.builder()
                .rows(response.getBody())
                .pageNum(query.getPage())
                .pageSize(query.getPage())
                .total(pageTotal(response))
                .build().validate();
    }

    @Override
    public FindPageRespTransfer fetchCodePage(ESIMarketItemFindPageReqDTransfer query) {
        ResponseEntity<List<String>> response = exchange(restClient, GameEveMarketOrderESIMarketExchangeTransfer.class)
                .fetchCodes(query.getRegionId(), DATASOURCE, query.getPage());
        return FindPageRespTransfer.builder()
                .rows(response.getBody())
                .pageNum(query.getPage())
                .pageSize(query.getPage())
                .total(pageTotal(response))
                .build().validate();
    }

}
