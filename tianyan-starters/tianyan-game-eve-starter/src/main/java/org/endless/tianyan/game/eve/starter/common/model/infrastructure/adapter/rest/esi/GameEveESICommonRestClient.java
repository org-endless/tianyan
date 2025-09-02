package org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi;

import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.DrivenAdapterFailedException;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.GameEveCommonRestClient;
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
 * @see GameEveCommonRestClient
 * @since 0.0.1
 */
public interface GameEveESICommonRestClient extends GameEveCommonRestClient {

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

    default <T> ResponseEntity<T> validate(ResponseEntity<T> response) {
        if (response.getStatusCode().is2xxSuccessful()) {
            return response;
        }
        throw new DrivenAdapterFailedException("游戏EVE-ESI接口调用功能失败，状态码: " + response.getStatusCode());
    }
}
