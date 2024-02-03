package org.endless.fanli.component.game.eve.domain.market.order;

import java.util.List;

/**
 * GameEveMarketOrderRemoteData
 * <p>
 * <p>
 * <p>
 * <p>create 2024/2/3 20:03
 * <p>update 2024/2/3 20:03
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
public interface GameEveMarketOrderRemoteData {

    List<GameEveMarketOrder> getRegionMarketOrdersByItemId(String itemId, String regionId);
}
