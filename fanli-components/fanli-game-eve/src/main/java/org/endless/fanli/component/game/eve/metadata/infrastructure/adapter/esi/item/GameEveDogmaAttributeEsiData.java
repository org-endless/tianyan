package org.endless.fanli.component.game.eve.metadata.infrastructure.adapter.esi.item;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * GameEveDogmaAttributeEsiData
 * <p>
 * <p>
 * <p>
 * <p>
 * create 2024/02/01 16:31
 * <p>
 * update 2024/02/01 16:31
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
public record GameEveDogmaAttributeEsiData(
        @JsonProperty("attribute_id") String DogmaAttributeId,
        @JsonProperty("value") boolean DogmaAttributeValue) {

}
