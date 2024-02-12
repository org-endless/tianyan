package org.endless.fanli.component.game.eve.market.domain.model.order;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.fanli.component.game.eve.domain.common.type.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * GameEveMarketOrderHistory
 * <p>
 * <p>
 * <p>
 * <p>create 2024/02/06 15:26
 * <p>update 2024/02/06 15:26
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
@Getter
@Builder
@ToString
public class GameEveMarketOrderHistory implements Entity {

    private LocalDate orderDate;
    private BigDecimal averagePrice;
    private BigDecimal highestPrice;
    private BigDecimal lowestPrice;
    private BigDecimal orderQuantity;
    private BigDecimal itemQuantity;
}
