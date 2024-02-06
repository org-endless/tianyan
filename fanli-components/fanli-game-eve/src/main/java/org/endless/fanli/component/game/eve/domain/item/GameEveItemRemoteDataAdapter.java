package org.endless.fanli.component.game.eve.domain.item;

import java.util.List;

/**
 * GameEveItemRemoteDataAdapter
 * <p>
 * <p>
 * <p>
 * <p>create 2024/02/01 17:04
 * <p>update 2024/02/01 17:04
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
public interface GameEveItemRemoteDataAdapter {

    List<String> getItemIds(Integer page);

    Integer getItemIdPages();

    GameEveItem getItemByItemId(String itemId);
}
