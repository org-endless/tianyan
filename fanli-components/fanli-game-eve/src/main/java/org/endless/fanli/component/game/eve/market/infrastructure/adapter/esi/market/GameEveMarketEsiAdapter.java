package org.endless.fanli.component.game.eve.market.infrastructure.adapter.esi.market;

import lombok.extern.slf4j.Slf4j;
import org.endless.fanli.component.game.eve.common.infrastructure.adapter.esi.AbstractGameEveEsiAdapter;
import org.endless.fanli.component.game.eve.market.domain.model.order.GameEveMarketOrderHistory;
import org.endless.fanli.component.game.eve.market.domain.model.order.GameEveMarketRemoteDataAdapter;
import org.endless.fanli.component.game.eve.market.domain.model.order.Order;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * GameEveMarketEsiAdapter
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
public class GameEveMarketEsiAdapter
        implements GameEveMarketRemoteDataAdapter, AbstractGameEveEsiAdapter {

    private final RestClient restClient;

    public GameEveMarketEsiAdapter(
            @Qualifier("esiRestClient") RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public List<Order> getRegionMarketOrdersByItemId(String itemId, String regionId) {

        Map<String, Object> uriVariables = new HashMap<>(ESI_DATASOURCE);
        uriVariables.put("type_id", itemId);
        uriVariables.put("order_type", "all");

        String uri = ESI_MARKET_URI + "/" + regionId + ESI_ORDER_URI + getVarsUri(uriVariables);

        return Objects.requireNonNull(restClient.get()
                        .uri(uri, uriVariables)
                        .retrieve()
                        .body(new ParameterizedTypeReference<List<GameEveMarketOrderEsiData>>() {
                        }))
                .stream()
                .map(GameEveMarketOrderEsiData::toEntity)
                .toList();
    }

    @Override
    public List<GameEveMarketOrderHistory> getRegionMarketOrderHistoryByItemId(String itemId, String regionId) {

        Map<String, Object> uriVariables = new HashMap<>(ESI_DATASOURCE);
        uriVariables.put("type_id", itemId);

        String uri = ESI_MARKET_URI + "/" + regionId + ESI_HISTORY_URI + getVarsUri(uriVariables);

        return Objects.requireNonNull(restClient.get()
                        .uri(uri, uriVariables)
                        .retrieve()
                        .body(new ParameterizedTypeReference<List<GameEveMarketOrderHistoryEsiData>>() {
                        }))
                .stream()
                .map(GameEveMarketOrderHistoryEsiData::toEntity)
                .toList();
    }
}
