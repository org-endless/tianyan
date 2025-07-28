package org.endless.tianyan.sales.components.market.order.game.eve.application.query.anticorruption;

import org.endless.tianyan.sales.components.market.order.game.eve.domain.anticorruption.GameEveMarketOrderDrivenAdapter;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.anticorruption.GameEveMarketOrderItemDrivenAdapter;

import java.util.List;

/**
 * GameEveMarketOrderItemQueryDrivenAdapter
 * <p>
 * create 2025/07/27 23:00
 * <p>
 * update 2025/07/27 23:00
 *
 * @author Deng Haozhi
 * @see GameEveMarketOrderDrivenAdapter
 * @since 2.0.0
 */
public interface GameEveMarketOrderItemQueryDrivenAdapter extends GameEveMarketOrderItemDrivenAdapter {

    List<String> fetchCodes();
}
