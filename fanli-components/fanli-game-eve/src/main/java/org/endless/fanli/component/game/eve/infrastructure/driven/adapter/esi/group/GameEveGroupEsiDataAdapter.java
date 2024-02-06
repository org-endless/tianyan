package org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi.group;

import org.endless.fanli.component.game.eve.domain.group.GameEveGroup;
import org.endless.fanli.component.game.eve.domain.group.GameEveGroupRemoteDataAdapter;
import org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi.GameEveEsiDataAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 * GameEveGroupEsiDataAdapter
 * <p>
 * <p>
 * <p>
 * <p>create 2024/2/4 18:16
 * <p>update 2024/2/4 18:16
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
@Component
public class GameEveGroupEsiDataAdapter
        implements GameEveEsiDataAdapter, GameEveGroupRemoteDataAdapter {

    private static final String ESI_GROUP_URI = "/universe/groups";
    private final RestClient restClient;

    public GameEveGroupEsiDataAdapter(
            @Qualifier("esiRestClient") RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public List<String> getGroupIds(Integer page) {

        Map<String, Object> uriVariables = new HashMap<>(ESI_DATASOURCE);
        uriVariables.put("page", page);

        String uri = ESI_GROUP_URI + getVarsUri(uriVariables);
        return restClient.get()
                .uri(uri, uriVariables)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public GameEveGroup getGroupByGroupId(String groupId) {

        Map<String, Object> uriVariables = new HashMap<>(ESI_DATASOURCE);
        uriVariables.put("group_id", groupId);
        uriVariables.put("language", ESI_LANGUAGE);

        String uri = ESI_GROUP_URI + "/" + groupId + getVarsUri(uriVariables);

        return Objects.requireNonNull(restClient.get()
                        .uri(uri, uriVariables)
                        .retrieve()
                        .body(GameEveGroupEsiData.class))
                .toEntity();
    }
}
