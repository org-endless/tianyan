package org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi.item;

import org.endless.fanli.component.game.eve.domain.item.GameEveItem;
import org.endless.fanli.component.game.eve.domain.item.GameEveItemRemoteDataAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GameEveItemEsiDataAdapter
        implements GameEveItemRemoteDataAdapter {

    private static final String ESI_TYPES_URI = "/universe/types";

    private final RestClient restClient;

    public GameEveItemEsiDataAdapter(
            @Qualifier("esiRestClient") RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public List<String> getItemIds(Integer page) {

        Map<String, Object> uriVariables = new HashMap<>(ESI_DATASOURCE);
        uriVariables.put("page", page);

        return restClient.get()
                .uri(ESI_TYPES_URI + getVariablesUri(uriVariables), uriVariables)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public Integer getItemIdPages() {

        Map<String, Object> uriVariables = new HashMap<>(ESI_DATASOURCE);
        uriVariables.put("page", 1);

        return getPages(restClient.get()
                .uri(ESI_TYPES_URI, getVariablesUri(uriVariables))
                .retrieve()
                .toEntity(List.class).
                getHeaders());
    }

    @Override
    public GameEveItem getItemByItemId(String itemId) {

        Map<String, Object> uriVariables = new HashMap<>(ESI_DATASOURCE);
        uriVariables.put("language", ESI_LANGUAGE);

        String uri = ESI_TYPES_URI + "/" + itemId + getVariablesUri(uriVariables);

        GameEveItemEsiData result = restClient.get()
                .uri(uri, uriVariables)
                .retrieve()
                .body(GameEveItemEsiData.class);

        if (result != null) {
            return toEntity(result);
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public GameEveItem toEntity(GameEveItemEsiData data) {

        return GameEveItem.builder()
                .itemId(data.itemId())
                .groupId(data.groupId())
                .marketGroupId(data.marketGroupId())
                .published(data.published())
                .name(data.name())
                .description(data.description())
                .portionSize(data.portionSize())
                .mass(data.mass())
                .capacity(data.capacity())
                .volume(data.volume())
                .packagedVolume(data.packagedVolume())
                .radius(data.radius())
                .iconId(data.iconId())
                .graphicId(data.graphicId())
                .build();
    }
}
