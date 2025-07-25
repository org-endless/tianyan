package org.endless.tianyan.sales.common.model.infrastructure.adapter.rest;

import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.manager.DrivenAdapterManagerException;
import org.endless.tianyan.sales.common.model.infrastructure.adapter.rest.transfer.TianyanSalesESIExchangeTransfer;
import org.endless.tianyan.sales.common.model.infrastructure.adapter.rest.transfer.TianyanSalesESIFindUniverseItemNameRespDTransfer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

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
 * @since 0.0.1
 */
public interface TianyanSalesESIRestClient extends TianyanSalesRestClient {

    String DATASOURCE = "serenity";

    String DEFAULT_REGION_ID = "10000002";

    String SYSTEM_CATEGORY_NAME = "solar_system";

    String LOCATION_CATEGORY_NAME = "solar_system";

    default Long pageTotal(ResponseEntity<?> response) {
        return Long.valueOf(Optional.ofNullable(response.getHeaders().get("x-pages"))
                .orElse(List.of("0")).getFirst());
    }


    default String findUniverseItemNameByCode(RestClient restClient, String itemCode, String datasource, String categoryName) {
        return Optional.ofNullable(exchange(restClient, TianyanSalesESIExchangeTransfer.class)
                        .findUniverseItemNameByCode(datasource, List.of(itemCode)))
                .orElseThrow(() -> new DrivenAdapterManagerException("未找到相关的宇宙资源项信息"))
                .stream()
                .filter(system -> system.getCategory().equals(categoryName))
                .findFirst()
                .map(TianyanSalesESIFindUniverseItemNameRespDTransfer::getName)
                .orElseThrow(() -> new DrivenAdapterManagerException("未找到相关的宇宙资源项名称"));
    }

}
