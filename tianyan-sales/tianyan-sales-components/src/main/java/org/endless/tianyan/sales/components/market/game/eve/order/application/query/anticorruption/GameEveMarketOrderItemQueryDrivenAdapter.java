package org.endless.tianyan.sales.components.market.game.eve.order.application.query.anticorruption;

import org.endless.tianyan.sales.components.market.game.eve.order.domain.anticorruption.GameEveMarketOrderDrivenAdapter;
import org.endless.tianyan.sales.components.market.game.eve.order.domain.anticorruption.GameEveMarketOrderItemDrivenAdapter;

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

    /**
     * 获取游戏EVE市场资源项编码列表
     *
     * @return {@link List }<{@link String }>
     */
    List<String> fetchCodes();
}
