package org.endless.fanli.component.game.eve.domain.item;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.fanli.component.game.eve.domain.common.type.Entity;

import java.math.BigDecimal;

/**
 * GameEveItem
 * <p>
 * <p>
 * <p>
 * <p>create 2024/02/01 17:04
 * <p>update 2024/02/01 17:04
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
@Getter
@Builder
@ToString
public class GameEveItem implements Entity {

    private String itemId;
    private String groupId;
    private String marketGroupId;
    private boolean published;
    private String name;
    private String description;
    private BigDecimal portionSize;
    private BigDecimal mass;
    private BigDecimal capacity;
    private BigDecimal volume;
    private BigDecimal packagedVolume;
    private BigDecimal radius;
    private String iconId;
    private String graphicId;
}
