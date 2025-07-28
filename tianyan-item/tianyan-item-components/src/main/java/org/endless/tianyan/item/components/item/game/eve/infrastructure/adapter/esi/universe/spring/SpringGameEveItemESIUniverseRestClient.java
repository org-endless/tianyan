package org.endless.tianyan.item.components.item.game.eve.infrastructure.adapter.esi.universe.spring;

import org.endless.tianyan.item.components.item.game.eve.infrastructure.adapter.esi.universe.GameEveItemESIUniverseRestClient;
import org.endless.tianyan.item.components.item.game.eve.infrastructure.adapter.esi.universe.transfer.GameEveItemESIUniverseExchangeTransfer;
import org.endless.tianyan.item.components.item.game.eve.infrastructure.adapter.transfer.ESIUniverseItemFindProfileRespDTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

/**
 * SpringGameEveItemESIUniverseRestClient
 * <p>
 * create 2025/07/28 05:14
 * <p>
 * update 2025/07/28 05:14
 *
 * @author Deng Haozhi
 * @see GameEveItemESIUniverseRestClient
 * @since 2.0.0
 */
@Lazy
@Component
public class SpringGameEveItemESIUniverseRestClient implements GameEveItemESIUniverseRestClient {

    private final RestClient restClient;

    public SpringGameEveItemESIUniverseRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public ESIUniverseItemFindProfileRespDTransfer fetchItem(String gameEveItemCode) {
        return exchange(restClient, GameEveItemESIUniverseExchangeTransfer.class)
                .fetchItem(gameEveItemCode, DATASOURCE, LANGUAGE_ZH);

    }
}
