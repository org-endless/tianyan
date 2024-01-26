// package org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi;
//
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.http.HttpHeaders;
// import org.springframework.stereotype.Component;
// import org.springframework.web.client.HttpClientErrorException;
// import org.springframework.web.client.RestClient;
//
// import java.util.Arrays;
// import java.util.List;
// import java.util.Map;
// import java.util.Objects;
//
// /**
//  * AbstractEsiRemoteAdapter
//  *
//  * @author Deng Haozhi
//  * @date 2023/4/23 16:59
//  * @since 0.0.2
//  */
// @Slf4j
// @Component
// public abstract class AbstractEsiRemoteAdapter implements EsiRemoteAdapter {
//
//     protected static final String ESI_URI = "https:/ali-esi.evepc.163.com/latest/";
//
//     protected static final String ESI_SSO_URI = "https://login.evepc.163.com/v2/oauth/authorize/";
//
//     protected static final String ESI_SSO_CACHE_URI = "https://login.evepc.163.com/account/logoff";
//
//     protected static final String ESI_SSO_REDIRECT_URI = "https://esi.evepc.163.com/ui/oauth2-redirect.html";
//
//     protected static final String ESI_SSO_CLIENT_ID = "bc90aa496a404724a93f41b4f4e97761";
//
//     protected static final String ESI_SSO_DEVICE_ID = "eve_erp";
//
//     protected static final String ESI_SSO_STATE = "eve_erp_state";
//
//     protected static final String ESI_SSO_SCOPE = "esi-characters.read_corporation_roles.v1 esi-corporations.read_blueprints.v1 esi-industry.read_corporation_jobs.v1 esi-skills.read_skills.v1 esi-wallet.read_corporation_wallets.v1 esi-assets.read_corporation_assets.v1 esi-planets.manage_planets.v1";
//
//     private final RestClient esiRestClient;
//
//     private final RestClient esiAuthorizeRestClient;
//
//     protected AbstractEsiRemoteAdapter(
//             @Qualifier("esiRestClient") RestClient esiRestClient,
//             @Qualifier("esiAuthorizeRestClient") RestClient esiAuthorizeRestClient) {
//         this.esiRestClient = esiRestClient;
//         this.esiAuthorizeRestClient = esiAuthorizeRestClient;
//     }
//
//
//     public HttpHeaders getHeader(String service, String scenes) {
//
//         String url = getUrl(service, scenes);
//
//         try {
//             return restTemplate.headForHeaders(url);
//
//         } catch (Exception e) {
//             log.error(e.getMessage());
//             log.trace(Arrays.toString(e.getStackTrace()));
//             return null;
//         }
//     }
//
//     public Integer getPages(String service, String scenes) {
//
//         try {
//
//             return Integer.parseInt(
//                     Objects.requireNonNull(getHeader(service, scenes).get("X-Pages")).get(0));
//
//         } catch (Exception e) {
//
//             log.error(e.getMessage());
//             log.trace(Arrays.toString(e.getStackTrace()));
//             return 0;
//         }
//     }
//
//     public List<?> get(String service, String scenes, Map<String, String> paras) {
//
//         String url = getUrl(service, scenes);
//
//         url = url + UrlFormatter.para(paras);
//
//         try {
//
//             return restTemplate.getForObject(url, List.class, paras);
//
//         } catch (HttpClientErrorException.NotFound e) {
//             return null;
//         } catch (Exception e) {
//             log.error(e.getMessage());
//             log.trace(Arrays.toString(e.getStackTrace()));
//             return null;
//         }
//     }
//
//     protected String getUrl(String service, String scenes) {
//         return ESI_URI + service + "/" + ConstantResource.REGION_ID + "/" + scenes;
//     }
// }
