package org.endless.fanli.component.game.eve.domain.market;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.fanli.component.game.eve.domain.common.type.GameEveEntity;
import org.endless.spring.boot.common.utility.decimal.Decimal;

import java.math.BigDecimal;
import java.util.List;

/**
 * GameEveMarketEntity
 * <p>
 * <p>
 * <p>
 * <p>create 2024/02/06 16:31
 * <p>update 2024/02/06 16:31
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
@Getter
@Builder
@ToString
public class GameEveMarketEntity implements GameEveMarketAggregate, GameEveEntity {

    private final String itemId;
    private BigDecimal averagePrice;
    private BigDecimal highestPrice;
    private BigDecimal lowestPrice;
    private BigDecimal marketAnnualSalesQuantity;

    private List<GameEveMarketOrder> marketOrders;

    @Override
    public BigDecimal calculateMarketAnnualSalesQuantity(List<GameEveMarketOrderHistory> histories) {

        return histories.stream()
                .map(GameEveMarketOrderHistory::getItemQuantity)
                .reduce(BigDecimal.ZERO, Decimal::add);
    }
}
