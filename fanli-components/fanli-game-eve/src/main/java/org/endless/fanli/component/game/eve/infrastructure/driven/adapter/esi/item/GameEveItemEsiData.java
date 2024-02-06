package org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.endless.fanli.component.game.eve.domain.common.type.RemoteData;
import org.endless.fanli.component.game.eve.domain.item.GameEveItem;

import java.math.BigDecimal;

/**
 * GameEveItemEsiData
 * <p>
 * <p>
 * <p>
 * <p>create 2024/02/01 16:39
 * <p>update 2024/02/01 16:39
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
public record GameEveItemEsiData(
        @JsonProperty("type_id") String itemId,
        @JsonProperty("group_id") String groupId,
        @JsonProperty("market_group_id") String marketGroupId,
        @JsonProperty("published") boolean published,
        @JsonProperty("name") String name,
        @JsonProperty("description") String description,
        @JsonProperty("portion_size") BigDecimal portionSize,
        @JsonProperty("mass") BigDecimal mass,
        @JsonProperty("capacity") BigDecimal capacity,
        @JsonProperty("volume") BigDecimal volume,
        @JsonProperty("packaged_volume") BigDecimal packagedVolume,
        @JsonProperty("radius") BigDecimal radius,
        @JsonProperty("icon_id") String iconId,
        @JsonProperty("graphic_id") String graphicId
        // @JsonProperty("dogma_attributes") Collection<GameEveDogmaAttributeEsiData> dogmaAttributes,
        // @JsonProperty("dogma_effects") Collection<GameEveDogmaEffectEsiData> dogmaEffects
) implements RemoteData<GameEveItem> {
    @Override
    public GameEveItem toEntity() {
        return null;
    }
}
