package org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi.market;

import lombok.extern.slf4j.Slf4j;
import org.endless.fanli.component.game.eve.domain.market.order.GameEveMarketOrder;
import org.endless.fanli.component.game.eve.domain.market.order.GameEveMarketOrderRemoteData;
import org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi.AbstractEsiRemoteAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GameEveMarketOrderEsiRemoteDataAdapter
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
public class GameEveMarketOrderEsiRemoteDataAdapter extends AbstractEsiRemoteAdapter implements GameEveMarketOrderRemoteData {

    private static final String ESI_MARKET_ORDER_URI = "/markets/{region_id}/orders";

    private final RestClient restClient;

    public GameEveMarketOrderEsiRemoteDataAdapter(
            @Qualifier("esiRestClient") RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public List<GameEveMarketOrder> getRegionMarketOrdersByItemId(String itemId, String regionId) {

        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("datasource", ESI_DATASOURCE);
        uriVariables.put("order_type", "sell");
        uriVariables.put("type_id", "0");
        ParameterizedTypeReference<List<GameEveMarketOrderEsiData>> test = new ParameterizedTypeReference<>() {
        };
        List<GameEveMarketOrderEsiData> result = restClient.get()
                .uri("/markets/10000002/orders", uriVariables)
                .retrieve().body(test);

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
}
