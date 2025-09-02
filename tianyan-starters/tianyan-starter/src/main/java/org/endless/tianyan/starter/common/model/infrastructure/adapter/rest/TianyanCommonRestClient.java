package org.endless.tianyan.starter.common.model.infrastructure.adapter.rest;

import org.endless.ddd.starter.common.ddd.infrastructure.adapter.rest.RestClientAdapter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.function.Consumer;

/**
 * TianyanCommonRestRestClient
 * <p>
 * create 2025/08/23 00:01
 * <p>
 * update 2025/08/23 00:13
 *
 * @author Deng Haozhi
 * @see RestClientAdapter
 * @since 1.0.0
 */
public interface TianyanCommonRestClient extends RestClientAdapter {

    Consumer<HttpHeaders> DEFAULT_HEADERS_FOR_JSON_UTF8 = httpHeaders -> {
        httpHeaders.setContentType(new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8));
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
    };
}
