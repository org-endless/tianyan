package org.endless.fanli.component.game.eve.market.domain.model.order;

import java.util.List;

/**
 * GameEveMarketRemoteDataAdapter
 * <p>
 * <p>
 * <p>
 * <p>create 2024/2/3 20:03
 * <p>update 2024/2/3 20:03
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
public interface GameEveMarketRemoteDataAdapter {

    List<GameEveMarketOrder> getRegionMarketOrdersByItemId(String itemId, String regionId);

    List<GameEveMarketOrderHistory> getRegionMarketOrderHistoryByItemId(String itemId, String regionId);
}
