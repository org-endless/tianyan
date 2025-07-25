package org.endless.tianyan.sales.common.model.infrastructure.adapter.rest;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

/**
 * TianyanSalesESIRestClient
 * <p>
 * create 2025/07/25 10:15
 * <p>
 * update 2025/07/25 10:16
 *
 * @author Deng Haozhi
 * @see TianyanSalesRestClient
 * @since 2.0.0
 */
public interface TianyanSalesESIRestClient extends TianyanSalesRestClient {

    String DATASOURCE = "serenity";

    String SYSTEM_CATEGORY_NAME = "solar_system";
    String LOCATION_CATEGORY_NAME = "solar_system";

    default Long pageTotal(ResponseEntity<?> response) {
        return Long.valueOf(Optional.ofNullable(response.getHeaders().get("x-pages"))
                .orElse(List.of("0")).getFirst());
    }

}
