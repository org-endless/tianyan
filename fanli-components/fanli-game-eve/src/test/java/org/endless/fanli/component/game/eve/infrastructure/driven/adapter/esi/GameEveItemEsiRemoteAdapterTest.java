package org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GameEveItemEsiRemoteAdapterTest {

    final GameEveItemEsiRemoteAdapter adapter;

    GameEveItemEsiRemoteAdapterTest(GameEveItemEsiRemoteAdapter adapter) {
        this.adapter = adapter;
    }

    @Test
    void test() {
        adapter.getItemIds(1);

    }

}
