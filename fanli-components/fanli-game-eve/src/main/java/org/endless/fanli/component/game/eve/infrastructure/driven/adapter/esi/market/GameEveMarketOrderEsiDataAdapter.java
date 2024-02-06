package org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi.market;

import lombok.extern.slf4j.Slf4j;
import org.endless.fanli.component.game.eve.domain.market.order.GameEveMarketOrder;
import org.endless.fanli.component.game.eve.domain.market.order.GameEveMarketOrderRemoteData;
import org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi.AbstractGameEveRemoteDataAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GameEveMarketOrderEsiDataAdapter
 * <p>
 * <p>
 * <p>
 * <p>create 2024/2/3 19:49
 * <p>update 2024/2/3 19:49
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
@Slf4j
@Component
public class GameEveMarketOrderEsiDataAdapter
        extends AbstractGameEveRemoteDataAdapter<GameEveMarketOrder, GameEveMarketOrderEsiData>
        implements GameEveMarketOrderRemoteData {

    private static final String ESI_MARKET_URI = "/markets";
    private static final String ESI_ORDER_URI = "/orders";

    private final RestClient restClient;

    public GameEveMarketOrderEsiDataAdapter(
            @Qualifier("esiRestClient") RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public List<GameEveMarketOrder> getRegionMarketOrdersByItemId(String itemId, String regionId) {

        Map<String, Object> uriVariables = new HashMap<>(ESI_DATASOURCE);
        uriVariables.put("type_id", itemId);
        uriVariables.put("order_type", "all");

        regionId = "/" + regionId;

        List<GameEveMarketOrderEsiData> result = restClient.get()
                .uri(ESI_MARKET_URI + regionId + ESI_ORDER_URI, uriVariables)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });

        if (result != null) {
            return result.stream()
                    .map(data -> GameEveMarketOrder.builder()
                            .itemId(data.itemId())
                            .build())
                    .toList();
        } else {
            throw new NullPointerException();
        }
    }


    @Override
    public GameEveMarketOrder toEntity(GameEveMarketOrderEsiData data) {
        return null;
    }
}
