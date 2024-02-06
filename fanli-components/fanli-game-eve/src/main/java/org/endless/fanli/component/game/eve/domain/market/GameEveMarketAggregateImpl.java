package org.endless.fanli.component.game.eve.domain.market;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

/**
 * GameEveMarketAggregateImpl
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
public class GameEveMarketAggregateImpl implements GameEveMarketAggregate {

    private final String itemId;
    private BigDecimal marketAnnualSalesQuantity;


    @Override
    public void calculateMarketAnnualSalesQuantity(List<GameEveMarketOrderHistory> histories) {


    }

}
