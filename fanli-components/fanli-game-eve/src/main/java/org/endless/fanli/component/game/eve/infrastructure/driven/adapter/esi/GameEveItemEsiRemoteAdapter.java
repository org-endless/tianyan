package org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.endless.fanli.component.game.eve.domain.item.GameEveItem;
import org.endless.fanli.component.game.eve.domain.item.GameEveItemRemoteAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class GameEveItemEsiRemoteAdapter extends AbstractEsiRemoteAdapter
        implements GameEveItemRemoteAdapter {

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

        List<?> result = super.get(restClient, ESI_TYPES_URI, uriVariables, List.class);

        if (result != null) {
            return result.stream().map(Object::toString).toList();
        }

        return Collections.emptyList();
    }

    public Integer getItemIdPages() {

        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("datasource", ESI_DATASOURCE);
        uriVariables.put("pages", Integer.valueOf(1));

        return super.getPages(restClient, ESI_TYPES_URI, uriVariables, List.class);
    }

    @Override
    public Optional<GameEveItem> getItemByItemId() {

        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("datasource", ESI_DATASOURCE);
        uriVariables.put("language", ESI_LANGUAGE);
        return Optional.empty();
    }

}
