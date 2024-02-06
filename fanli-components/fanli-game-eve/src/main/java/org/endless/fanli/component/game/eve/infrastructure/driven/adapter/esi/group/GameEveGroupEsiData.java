package org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi.group;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.endless.fanli.component.game.eve.domain.common.type.RemoteData;
import org.endless.fanli.component.game.eve.domain.group.GameEveGroup;

import java.util.List;


/**
 * GameEveGroupEsiData
 * <p>
 * <p>
 * <p>
 * <p>create 2024/2/4 18:14
 * <p>update 2024/2/4 18:14
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
public record GameEveGroupEsiData(
        @JsonProperty("group_id") String groupId,
        @JsonProperty("category_id") String categoryId,
        @JsonProperty("name") String groupName,
        @JsonProperty("published") boolean published,
        @JsonProperty("types") List<String> items
) implements RemoteData<GameEveGroup> {
    @Override
    public GameEveGroup toEntity() {
        return GameEveGroup.builder()
                .groupId(groupId())
                .categoryId(categoryId())
                .groupName(groupName())
                .published(published())
                .items(items())
                .build();
    }
}
