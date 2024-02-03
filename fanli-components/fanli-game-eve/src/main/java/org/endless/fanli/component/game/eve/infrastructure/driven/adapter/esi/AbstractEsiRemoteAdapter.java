package org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/**
 * AbstractEsiRemoteAdapter
 * <p>
 * <p>
 * <p>
 * <p>create 2024/02/01 16:29
 * <p>update 2024/02/01 16:29
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
@Slf4j
@Component
public abstract class AbstractEsiRemoteAdapter implements EsiRemoteAdapter {

    protected static final String ESI_DATASOURCE = "serenity";

    protected static final String ESI_LANGUAGE = "zh";

    protected static final String ESI_Forge_REGION_ID = "10000002";

    protected static final String ESI_SSO_CACHE_URI = "https://login.evepc.163.com/account/logoff";

    protected static final String ESI_SSO_REDIRECT_URI = "https://esi.evepc.163.com/ui/oauth2-redirect.html";

    protected static final String ESI_SSO_CLIENT_ID = "bc90aa496a404724a93f41b4f4e97761";

    protected static final String ESI_SSO_DEVICE_ID = "eve_erp";

    protected static final String ESI_SSO_STATE = "eve_erp_state";

    protected static final String ESI_SSO_SCOPE = "esi-characters.read_corporation_roles.v1 esi-corporations.read_blueprints.v1 esi-industry.read_corporation_jobs.v1 esi-skills.read_skills.v1 esi-wallet.read_corporation_wallets.v1 esi-assets.read_corporation_assets.v1 esi-planets.manage_planets.v1";

    protected <T> T get(@NonNull RestClient restClient, @NonNull String uri,
                        @NonNull Class<T> bodyType) {
        return get(restClient, uri, bodyType, Object.class);
    }

    protected <T> T get(@NonNull RestClient restClient, @NonNull String uri,
                        @NonNull Class<T> bodyType, @NonNull Map<String, Object> uriVariables) {

        try {

            return restClient.get().uri(uri, uriVariables).retrieve().body(bodyType);

        } catch (Exception e) {

            log.error(e.getMessage());
            log.trace(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

    protected <T> T get(@NonNull RestClient restClient, @NonNull String uri,
                        @NonNull Class<T> bodyType, Object... uriVariables) {

        try {

            if (Objects.isNull(uriVariables)) {
                return restClient.get().uri(uri).retrieve().body(bodyType);
            } else {
                return restClient.get().uri(uri, uriVariables).retrieve().body(bodyType);
            }

        } catch (Exception e) {

            log.error(e.getMessage());
            log.trace(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

    protected <T> HttpHeaders getHeader(@NonNull RestClient restClient, @NonNull String uri,
                                        @NonNull Class<T> bodyType, @NonNull Map<String, Object> uriVariables) {

        try {
            return restClient.get().uri(uri, uriVariables).retrieve().toEntity(bodyType)
                    .getHeaders();
        } catch (Exception e) {

            log.error(e.getMessage());
            log.trace(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

    public <T> Integer getPages(HttpHeaders headers) {

        try {
            return Integer.parseInt(Objects
                    .requireNonNull(headers.get("X-Pages"))
                    .getFirst());

        } catch (Exception e) {

            log.error(e.getMessage());
            log.trace(Arrays.toString(e.getStackTrace()));
            return 0;
        }
    }

    // public List<?> get(String service, String scenes, Map<String, String> paras)
    // {

    // String url = getUrl(service, scenes);

    // url = url + UrlFormatter.para(paras);

    // try {

    // return restTemplate.getForObject(url, List.class, paras);

    // } catch (HttpClientErrorException.NotFound e) {
    // return null;
    // } catch (Exception e) {
    // log.error(e.getMessage());
    // log.trace(Arrays.toString(e.getStackTrace()));
    // return null;
    // }
    // }

}
