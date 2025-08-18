package org.endless.fanli.component.game.eve.market.domain.model.order;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.fanli.component.game.eve.common.domain.model.GameEveAggregateRoot;
import org.endless.spring.boot.common.utility.decimal.DecimalTools;

import java.math.BigDecimal;
import java.util.List;

/**
 * Market
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
public class Market implements GameEveMarketAggregate, GameEveAggregateRoot {

    private final String itemId;

    private CurrentPrice currentPrice;

    private BigDecimal marketAnnualSalesQuantity;

    private List<Order> orders;

    private List<Order> marketOrders;

    @Override
    public BigDecimal calculateMarketAnnualSalesQuantity(List<GameEveMarketOrderHistory> histories) {

        return histories.stream()
                .map(GameEveMarketOrderHistory::getItemQuantity)
                .reduce(BigDecimal.ZERO, DecimalTools::add);
    }
}
