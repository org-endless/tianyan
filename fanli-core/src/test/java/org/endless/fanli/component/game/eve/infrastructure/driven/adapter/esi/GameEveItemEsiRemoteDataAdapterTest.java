package org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi;

import org.endless.fanli.component.game.eve.domain.item.GameEveItem;
import org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi.item.GameEveItemEsiDataAdapter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GameEveItemEsiRemoteDataAdapterTest {

    @Autowired
    GameEveItemEsiDataAdapter adapter;

    @Test
    void getItemIds() {

        System.out.println(adapter.getItemIds(2).getFirst());
    }

    @Test
    void getItemIdPages() {

    }

    @Test
    void getItemByItemId() {
        GameEveItem gameEveItem = adapter.getItemByItemId("74525");
        System.out.println(gameEveItem.toString());
    }

}
