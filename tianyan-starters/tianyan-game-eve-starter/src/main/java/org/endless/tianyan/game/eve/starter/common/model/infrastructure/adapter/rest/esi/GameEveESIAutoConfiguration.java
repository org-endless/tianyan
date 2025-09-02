package org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi;

import org.endless.ddd.starter.common.config.rest.client.RestExchangeClient;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.market.GameEveESIMarketRestClient;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.market.impl.GameEveESIMarketOrderRestClientImpl;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.universe.GameEveESIUniverseRestClient;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.universe.impl.GameEveESIUniverseRestClientImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * GameEveESIAutoConfiguration
 * <p>
 * create 2025/08/27 00:02
 * <p>
 * update 2025/08/27 00:02
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@AutoConfiguration
public class GameEveESIAutoConfiguration {

    @Lazy
    @ConditionalOnMissingBean
    public @Bean GameEveESIMarketRestClient gameEveESIMarketOrderRestClient(RestExchangeClient restExchangeClient) {
        return new GameEveESIMarketOrderRestClientImpl(restExchangeClient);
    }

    @Lazy
    @ConditionalOnMissingBean
    public @Bean GameEveESIUniverseRestClient gameEveESIUniverseRestClient(RestExchangeClient restExchangeClient) {
        return new GameEveESIUniverseRestClientImpl(restExchangeClient);
    }
}
