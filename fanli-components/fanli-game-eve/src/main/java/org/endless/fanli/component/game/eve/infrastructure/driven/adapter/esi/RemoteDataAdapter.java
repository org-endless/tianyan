package org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi;

import org.springframework.http.HttpHeaders;

import java.util.Map;
import java.util.Objects;

/**
 * RemoteDataAdapter
 * <p>
 * <p>
 * <p>
 * <p>create 2024/02/05 9:46
 * <p>update 2024/02/05 9:46
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
public interface RemoteDataAdapter {

    Map<String, Object> ESI_DATASOURCE = Map.of("datasource", "serenity");
    String ESI_LANGUAGE = "zh";
    String ESI_FORGE_REGION_ID = "10000002";
    String ESI_SSO_CACHE_URI = "https://login.evepc.163.com/account/logoff";
    String ESI_SSO_REDIRECT_URI = "https://esi.evepc.163.com/ui/oauth2-redirect.html";
    String ESI_SSO_CLIENT_ID = "bc90aa496a404724a93f41b4f4e97761";
    String ESI_SSO_DEVICE_ID = "eve_erp";
    String ESI_SSO_STATE = "eve_erp_state";
    String ESI_SSO_SCOPE = "esi-characters.read_corporation_roles.v1 esi-corporations.read_blueprints.v1 esi-industry.read_corporation_jobs.v1 esi-skills.read_skills.v1 esi-wallet.read_corporation_wallets.v1 esi-assets.read_corporation_assets.v1 esi-planets.manage_planets.v1";

    default Integer getPages(HttpHeaders headers) {

        return Integer.parseInt(
                Objects.requireNonNull(headers.get("X-Pages"))
                        .getFirst());
    }

    default String getVarsUri(Map<String, Object> uriVariables) {

        if (uriVariables.isEmpty()) return null;

        StringBuilder paras = new StringBuilder("?");
        uriVariables.forEach((key, value) -> paras.append(key).append("={").append(key).append("}&"));
        return paras.substring(0, paras.length() - 1);
    }
}
