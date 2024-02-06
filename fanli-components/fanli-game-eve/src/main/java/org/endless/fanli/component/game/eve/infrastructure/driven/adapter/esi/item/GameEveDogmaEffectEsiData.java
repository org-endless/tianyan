package org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi.item;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * GameEveDogmaEffectEsiData
 * <p>
 * <p>
 * <p>
 * <p>create 2024/02/01 16:31
 * <p>update 2024/02/01 16:31
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
public record GameEveDogmaEffectEsiData(
        @JsonProperty("effect_id") String DogmaEffectId,
        @JsonProperty("is_default") boolean isDefault) {
}
