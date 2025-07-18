package org.endless.fanli.component.game.eve.market.domain.model.order;


import org.endless.fanli.component.game.eve.common.domain.model.GameEveAggregate;

import java.math.BigDecimal;
import java.util.List;

/**
 * GameEveMarketAggregate
 * <p>
 * <p>
 * <p>
 * <p>create 2024/02/06 16:32
 * <p>update 2024/02/06 16:32
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
public interface GameEveMarketAggregate extends GameEveAggregate {
    BigDecimal calculateMarketAnnualSalesQuantity(List<GameEveMarketOrderHistory> histories);
}
