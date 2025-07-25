package org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.esi.order.rest.spring;

import org.endless.ddd.simplified.starter.common.model.common.transfer.FindPageRespTransfer;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.esi.order.rest.GameEveMarketOrderESIRestClient;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.esi.order.rest.transfer.GameEveMarketOrderESIExchangeTransfer;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.transfer.GameEveMarketOrderESIFindPageReqDTransfer;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.transfer.GameEveMarketOrderESIFindProfileRespDTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

/**
 * SpringGameEveMarketOrderESIRestClient
 * <p>
 * create 2025/07/25 11:42
 * <p>
 * update 2025/07/25 11:50
 *
 * @author Deng Haozhi
 * @see GameEveMarketOrderESIRestClient
 * @since 2.0.0
 */
@Lazy
@Component
public class SpringGameEveMarketOrderESIRestClient implements GameEveMarketOrderESIRestClient {

    private final RestClient restClient;

    public SpringGameEveMarketOrderESIRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public FindPageRespTransfer findMarketOrderPage(GameEveMarketOrderESIFindPageReqDTransfer query) {
        ResponseEntity<List<GameEveMarketOrderESIFindProfileRespDTransfer>> response = exchange(restClient, GameEveMarketOrderESIExchangeTransfer.class)
                .findMarketOrderProfiles(query.getRegionId(), DATASOURCE, query.getOrderType(), query.getGameEveItemCode(), query.getPage());
        return FindPageRespTransfer.builder()
                .rows(response.getBody())
                .pageNum(query.getPage())
                .pageSize(query.getPage())
                .total(pageTotal(response))
                .build().validate();
    }
}
