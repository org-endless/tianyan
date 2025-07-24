package org.endless.fanli.domain.game.eve.item;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.endless.fanli.common.constant.Regular;
import org.endless.fanli.common.type.item.Item;
import org.springframework.validation.annotation.Validated;

/**
 * GameEveItem
 * <p>游戏EVE资源项/商品实体类
 * <p>Game EVE item entities class.
 * <p>
 * <p>create 2023/03/07 1:28
 * <p>update 2024/01/21 22:17
 *
 * @author Deng Haozhi
 * @see Item
 * @since 0.0.6
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class GameEveItem extends Item {

    /**
     * EVE分组编号
     */
    @Pattern(regexp = Regular.ID, message = Regular.ID_MESSAGE)
    private String eveGroupId;

    /**
     * EVE市场分组编号
     */
    @Pattern(regexp = Regular.ID, message = Regular.ID_MESSAGE)
    private String eveMarketGroupId;

    /**
     * EVE类型分组编号
     */
    @Pattern(regexp = Regular.ID, message = Regular.ID_MESSAGE)
    private String eveMetaGroupId;
}
