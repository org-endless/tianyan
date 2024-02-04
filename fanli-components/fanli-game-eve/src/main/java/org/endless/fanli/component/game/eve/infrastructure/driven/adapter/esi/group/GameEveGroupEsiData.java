package org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi.group;

import com.fasterxml.jackson.annotation.JsonProperty;

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
) {
}
