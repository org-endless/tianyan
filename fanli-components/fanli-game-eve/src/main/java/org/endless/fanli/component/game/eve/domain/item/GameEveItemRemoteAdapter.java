package org.endless.fanli.component.game.eve.domain.item;

import java.util.List;

public interface GameEveItemRemoteAdapter {

    List<String> getItemIds(Integer page);

    Integer getItemIdPages();

    GameEveItem getItemByItemId(String itemId);
}
