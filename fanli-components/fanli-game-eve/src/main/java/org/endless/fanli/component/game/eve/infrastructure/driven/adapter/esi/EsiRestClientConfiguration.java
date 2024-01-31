package org.endless.fanli.component.game.eve;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

/**
 * EsiRestClientConfiguration
 * <p>
 * <p>
 * <p>
 * <p>create 2024/1/26 18:27
 * <p>update 2024/1/26 18:27
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
@Configuration
public class EsiRestClientConfiguration {

    private static final String ESI_BASE_URL = "https://ali-esi.evepc.163.com/latest";
    private static final String ESI_AUTHORIZE_URL = "https://login.evepc.163.com/v2/oauth/authorize";

    protected static final String ESI_DATASOURCE = "serenity";

    public @Bean RestClient esiRestClient() {
        return RestClient.builder().baseUrl(ESI_BASE_URL).build();
    }

    public @Bean RestClient esiAuthorizeRestClient() {
        return RestClient.builder().baseUrl(ESI_AUTHORIZE_URL).build();
    }
}
