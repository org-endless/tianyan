package org.endless.tianyan.sales.components.market.order.game.eve.domain.anticorruption;

import org.endless.tianyan.sales.common.model.domain.anticorruption.TianyanSalesDrivenAdapter;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.entity.GameEveMarketOrderAggregate;

import java.util.List;

/**
 * GameEveMarketOrderDrivenAdapter
 * <p>
 * create 2025/07/25 12:15
 * <p>
 * update 2025/07/25 12:16
 *
 * @author Deng Haozhi
 * @see TianyanSalesDrivenAdapter
 * @since 2.0.0
 */
public interface GameEveMarketOrderDrivenAdapter extends TianyanSalesDrivenAdapter {

    List<GameEveMarketOrderAggregate> fetch(List<GameEveMarketOrderAggregate> existedAggregates, String gameEveItemCode, String createUserId);

}
