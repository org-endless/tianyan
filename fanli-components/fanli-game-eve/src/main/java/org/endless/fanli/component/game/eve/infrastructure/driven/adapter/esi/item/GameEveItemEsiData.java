package org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Collection;

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
@AllArgsConstructor
@Getter
@ToString
public class GameEveItemEsiData {

    private int type_id;
    private int group_id;
    private int market_group_id;
    private int icon_id;
    private int graphic_id;

    private boolean published;

    private String name;
    private String description;

    private int portion_size;
    private double mass;
    private double capacity;
    private double volume;
    private double packaged_volume;
    private double radius;

    private Collection<GameEveDogmaAttributeEsiData> dogma_attributes;
    private Collection<GameEveDogmaEffectEsiData> dogma_effects;
}
