package org.endless.fanli.component.game.eve.metadata.infrastructure.adapter.esi.item;

import org.endless.fanli.component.game.eve.common.infrastructure.adapter.esi.AbstractGameEveEsiAdapter;
import org.endless.fanli.component.game.eve.metadata.domain.model.item.GameEveItem;
import org.endless.fanli.component.game.eve.metadata.domain.model.item.GameEveItemRemoteDataAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class AbstractGameEveItemEsiAdapter
        implements GameEveItemRemoteDataAdapter, AbstractGameEveEsiAdapter {

    private static final String ESI_TYPES_URI = "/universe/types";

    private final RestClient restClient;

    public AbstractGameEveItemEsiAdapter(
            @Qualifier("esiRestClient") RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public List<String> getItemIds(Integer page) {

        Map<String, Object> uriVariables = new HashMap<>(ESI_DATASOURCE);
        uriVariables.put("page", page);

        return restClient.get()
                .uri(ESI_TYPES_URI + getVarsUri(uriVariables), uriVariables)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public Integer getItemIdPages() {

        Map<String, Object> uriVariables = new HashMap<>(ESI_DATASOURCE);
        uriVariables.put("page", 1);

        return getPages(restClient.get()
                .uri(ESI_TYPES_URI, getVarsUri(uriVariables))
                .retrieve()
                .toEntity(List.class).
                getHeaders());
    }

    @Override
    public GameEveItem getItemByItemId(String itemId) {

        Map<String, Object> uriVariables = new HashMap<>(ESI_DATASOURCE);
        uriVariables.put("language", ESI_LANGUAGE);

        String uri = ESI_TYPES_URI + "/" + itemId + getVarsUri(uriVariables);

        return Objects.requireNonNull(restClient.get()
                        .uri(uri, uriVariables)
                        .retrieve()
                        .body(GameEveItemEsiData.class))
                .toEntity();
    }
}
