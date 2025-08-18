package org.endless.tianyan.sales.common.model.infrastructure.adapter.rest;

import org.endless.ddd.starter.common.ddd.common.Transfer;
import org.endless.ddd.starter.common.ddd.infrastructure.adapter.rest.RestClientAdapter;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import java.util.Collections;
import java.util.Optional;

/**
 * TianyanSalesItemRestClient
 * <p>
 * create 2025/07/26 03:59
 * <p>
 * update 2025/07/26 04:01
 *
 * @author Deng Haozhi
 * @see RestClientAdapter
 * @since 2.0.0
 */
public interface TianyanSalesItemRestClient extends RestClientAdapter {

    default <S extends Transfer, R extends Transfer> Optional<R> post(RestClient restClient, String uri, S request, Class<R> responseClass) {
        return post(
                restClient,
                "http://127.0.0.1:10101" + uri,
                request,
                responseClass,
                headers -> {
                    headers.setContentType(MediaType.APPLICATION_JSON);
                    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                });
    }
}
