package org.endless.fanli.component.game.eve.market.domain.model.order;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.fanli.component.game.eve.domain.common.type.Entity;
import org.endless.fanli.component.game.eve.domain.common.type.TradeType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * GameEveMarketOrder
 * <p>
 * <p>
 * <p>
 * <p>create 2024/2/3 20:01
 * <p>update 2024/2/3 20:01
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */

@Getter
@Builder
@ToString
public class GameEveMarketOrder implements Entity {

    private String itemId;
    private String orderId;
    private BigDecimal price;
    private BigDecimal minTransQuantity;
    private BigDecimal remainQuantity;
    private BigDecimal totalQuantity;
    private BigDecimal orderDuration;
    private TradeType tradeType;
    private LocalDateTime issuedDate;
    private String universeSystemId;
    private String universeLocationId;
    private String universeRange;

}
