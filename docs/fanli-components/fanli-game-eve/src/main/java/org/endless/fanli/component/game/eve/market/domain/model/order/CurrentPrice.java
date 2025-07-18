package org.endless.fanli.component.game.eve.market.domain.model.order;

import org.endless.fanli.component.game.eve.common.domain.model.GameEveValue;

import java.math.BigDecimal;

/**
 * CurrentPrice
 * <p>
 * <p>
 * <p>
 * <p>create 2024/02/27 10:06
 * <p>update 2024/02/27 10:06
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
public class CurrentPrice implements GameEveValue {
    private BigDecimal buyPrice;
    private BigDecimal sellPrice;
}
