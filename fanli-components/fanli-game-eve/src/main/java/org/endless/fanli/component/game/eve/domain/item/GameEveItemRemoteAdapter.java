package org.endless.fanli.component.game.eve.domain.item;

import java.util.List;
import java.util.Optional;

public interface GameEveItemRemoteAdapter {

    List<String> getItemIds(Integer page);

    Integer getItemIdPages();

    Optional<GameEveItem> getItemByItemId();
}
