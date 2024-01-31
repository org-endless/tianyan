package org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi.type;

import java.util.Collection;
import lombok.Getter;
import lombok.ToString;

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
