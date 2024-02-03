package org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi.item;

import org.endless.fanli.component.game.eve.domain.item.GameEveItem;
import org.endless.fanli.component.game.eve.domain.item.GameEveItemRemoteData;
import org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi.AbstractEsiRemoteAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GameEveItemEsiRemoteDataAdapter extends AbstractEsiRemoteAdapter
        implements GameEveItemRemoteData {

    private static final String ESI_TYPES_URI = "/universe/types";

    private final RestClient restClient;

    public GameEveItemEsiRemoteDataAdapter(
            @Qualifier("esiRestClient") RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public List<String> getItemIds(Integer page) {

        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("datasource", ESI_DATASOURCE);
        uriVariables.put("pages", page);

        List<?> result = super.get(restClient, ESI_TYPES_URI, List.class, uriVariables);

        if (result != null) {
            return result.stream().map(Object::toString).toList();
        }

        return Collections.emptyList();
    }

    public Integer getItemIdPages() {

        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("datasource", ESI_DATASOURCE);
        uriVariables.put("pages", 1);

        return getPages(restClient.get()
                .uri(ESI_TYPES_URI, uriVariables)
                .retrieve()
                .toEntity(List.class).
                getHeaders());
    }

    @Override
    public GameEveItem getItemByItemId(String itemId) {

        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("datasource", ESI_DATASOURCE);
        uriVariables.put("language", ESI_LANGUAGE);

        GameEveItemEsiData result = super.get(restClient,
                ESI_TYPES_URI + "/" + itemId + "/",
                GameEveItemEsiData.class,
                uriVariables);

        return new GameEveItem(String.valueOf(result.getType_id()));
    }

}
