package org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi.adapter;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.endless.fanli.component.game.eve.domain.item.GameEveItem;
import org.endless.fanli.component.game.eve.domain.item.GameEveItemRemoteAdapter;
import org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi.AbstractEsiRemoteAdapter;
import org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi.type.GameEveItemEsiData;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class GameEveItemEsiRemoteAdapter extends AbstractEsiRemoteAdapter
        implements GameEveItemRemoteAdapter {

    private static final String ESI_TYPES_URI = "/universe/types";

    private final RestClient restClient;

    public GameEveItemEsiRemoteAdapter(@Qualifier("esiRestClient") RestClient restClient) {
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
        uriVariables.put("pages", Integer.valueOf(1));

        return super.getPages(restClient, ESI_TYPES_URI, List.class, uriVariables);
    }

    @Override
    public GameEveItem getItemByItemId(String itemID) {

        String datasource = ESI_DATASOURCE;
        String language = "zh";

        GameEveItemEsiData result = super.get(restClient,
                ESI_TYPES_URI + "/{itemID}/?datasource={datasource}&language={language}",
                GameEveItemEsiData.class, Integer.valueOf(itemID), datasource, language);

        GameEveItem gameEveItem = new GameEveItem();
        gameEveItem.setItemId(String.valueOf(result.getType_id()));

        return gameEveItem;
    }

}
