package org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

/**
 * EsiRestClientConfiguration
 * <p>
 * <p>
 * <p>
 * <p>
 * create 2024/1/26 18:27
 * <p>
 * update 2024/1/26 18:27
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
@Configuration
public class EsiRestClientConfiguration {

    public @Bean RestClient esiRestClient() {
        return RestClient.builder().baseUrl(AbstractEsiRemoteAdapter.ESI_BASE_URL).build();
    }

    public @Bean RestClient esiAuthorizeRestClient() {
        return RestClient.builder().baseUrl(AbstractEsiRemoteAdapter.ESI_AUTHORIZE_URL).build();
    }
}
