package org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi;

import org.endless.fanli.component.game.eve.domain.item.GameEveItem;
import org.endless.fanli.component.game.eve.domain.item.GameEveItemRemoteAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi.EsiRestClientConfiguration.ESI_DATASOURCE;

@Component
public class GameEveItemEsiRemoteAdapter implements GameEveItemRemoteAdapter {

    private static final String ESI_TYPES_URI = "/universe/types";

    private final RestClient restClient;

    public GameEveItemEsiRemoteAdapter(
            @Qualifier("esiRestClient") RestClient restClient) {
        this.restClient = restClient;
    }


    @Override
    public List<String> getItemIds(Integer page) {

        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("datasource", ESI_DATASOURCE);
        uriVariables.put("pages", page);

        return restClient.get()
                .uri(ESI_TYPES_URI, uriVariables)
                .retrieve()
                .body(List.class);
    }

    @Override
    public Optional<GameEveItem> getItemByItemId() {
        return Optional.empty();
    }
}
