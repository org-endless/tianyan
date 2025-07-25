package org.endless.tianyan.metadata.common.model.infrastructure.adapter.rest;

import org.endless.ddd.simplified.starter.common.model.common.Transfer;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import java.util.Collections;
import java.util.Optional;

/**
 * TianyanMetadataSalesRestClient
 * <p>
 * create 2025/07/22 16:48
 * <p>
 * update 2025/07/22 16:48
 *
 * @author Deng Haozhi
 * @see TianyanMetadataRestClient
 * @since 0.0.1
 */
public interface TianyanMetadataSalesRestClient extends TianyanMetadataRestClient {

    default <S extends Transfer, R extends Transfer> Optional<R> post(RestClient restClient, String uri, S request, Class<R> responseClass) {
        return post(
                restClient,
                "http://127.0.0.1:10003" + uri,
                request,
                responseClass,
                headers -> {
                    headers.setContentType(MediaType.APPLICATION_JSON);
                    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                });
    }
}
