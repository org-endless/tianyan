package org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.universe.impl;

import org.endless.ddd.starter.common.config.rest.client.RestExchangeClient;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.universe.GameEveESIUniverseRestClient;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.universe.exchange.GameEveESIUniverseRestExchange;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.universe.transfer.FindESIUniverseItemDRespTransfer;

/**
 * GameEveESIUniverseRestClientImpl
 * <p>
 * create 2025/08/27 21:58
 * <p>
 * update 2025/08/27 22:03
 *
 * @author Deng Haozhi
 * @see GameEveESIUniverseRestClient
 * @since 1.0.0
 */
public class GameEveESIUniverseRestClientImpl implements GameEveESIUniverseRestClient {

    private final GameEveESIUniverseRestExchange gameEveESIUniverseRestExchange;

    public GameEveESIUniverseRestClientImpl(RestExchangeClient restExchangeClient) {
        this.gameEveESIUniverseRestExchange = restExchangeClient.exchange(GameEveESIUniverseRestExchange.class);
    }

    @Override
    public FindESIUniverseItemDRespTransfer fetchItem(String gameEveItemCode) {
        return gameEveESIUniverseRestExchange.fetchItem(gameEveItemCode, DATASOURCE, LANGUAGE_ZH);
    }
}
