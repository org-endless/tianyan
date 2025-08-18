package org.endless.tianyan.game.eve.common.model.infrastructure.adapter.rest;

import org.endless.ddd.starter.common.ddd.infrastructure.adapter.rest.RestClientAdapter;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

/**
 * TianyanGameEveESIRestClient
 * <p>
 * create 2025/07/25 10:15
 * <p>
 * update 2025/07/28 05:42
 *
 * @author Deng Haozhi
 * @see RestClientAdapter
 * @since 0.0.1
 */
public interface TianyanGameEveESIRestClient extends RestClientAdapter {

    String DATASOURCE = "serenity";

    String LANGUAGE_ZH = "zh";

    String LANGUAGE_EN = "en";

    String DEFAULT_REGION_ID = "10000002";

    String SYSTEM_CATEGORY_NAME = "solar_system";

    String LOCATION_CATEGORY_NAME = "solar_system";

    default Long pageTotal(ResponseEntity<?> response) {
        return Long.valueOf(Optional.ofNullable(response.getHeaders().get("x-pages"))
                .orElse(List.of("0")).getFirst());
    }
}
