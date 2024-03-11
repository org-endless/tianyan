package org.endless.fanli.component.game.eve.market.domain.model.order;

import org.endless.fanli.common.domain.type.TradeType;
import org.endless.fanli.component.game.eve.common.domain.model.GameEveValue;

import java.math.BigDecimal;

/**
 * Order
 * <p>
 * <p>
 * <p>
 * <p>create 2024/2/3 20:01
 * <p>update 2024/2/3 20:01
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */

public record Order(
        String itemId,
        BigDecimal price,
        TradeType tradeType

) implements GameEveValue {
}
