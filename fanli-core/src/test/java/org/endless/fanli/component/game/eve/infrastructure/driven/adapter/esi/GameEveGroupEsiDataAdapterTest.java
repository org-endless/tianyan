package org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi;

import org.endless.fanli.component.game.eve.common.infrastructure.adapter.esi.group.GameEveGroupEsiDataAdapter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GameEveGroupEsiDataAdapterTest {

    @Autowired
    GameEveGroupEsiDataAdapter adapter;

    @Test
    void getGroupIds() {
        adapter.getGroupIds(1).forEach(System.out::println);
    }

    @Test
    void getGroupByGroupId() {
        System.out.println(adapter.getGroupByGroupId("764").toString());
    }
}
