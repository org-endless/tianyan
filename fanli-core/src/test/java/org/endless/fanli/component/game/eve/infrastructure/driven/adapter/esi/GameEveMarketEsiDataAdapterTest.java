package org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi;

import org.endless.fanli.component.game.eve.common.infrastructure.adapter.esi.market.GameEveMarketEsiDataAdapter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GameEveMarketEsiDataAdapterTest {

    @Autowired
    GameEveMarketEsiDataAdapter adapter;

    @Test
    void getRegionMarketOrdersByItemId() {
        System.out.println(adapter.getRegionMarketOrdersByItemId("74525", "10000002").getFirst().toString());
    }

    @Test
    void getRegionMarketOrderHistoryByItemId() {
        System.out.println(adapter.getRegionMarketOrderHistoryByItemId("74525", "10000002").getFirst().toString());
    }
}
