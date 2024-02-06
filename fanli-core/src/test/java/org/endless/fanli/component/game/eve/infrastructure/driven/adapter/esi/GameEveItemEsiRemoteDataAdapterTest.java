package org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi;

import org.endless.fanli.component.game.eve.domain.item.GameEveItem;
import org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi.item.GameEveItemEsiDataAdapter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class GameEveItemEsiRemoteDataAdapterTest {

    @Autowired
    GameEveItemEsiDataAdapter adapter;

    @Test
    void getItemIds() {

        adapter.getItemIds(2).forEach(System.out::println);
    }

    @Test
    void getItemIdPages() {

    }

    @Test
    void getItemByItemId() {
        GameEveItem gameEveItem = adapter.getItemByItemId("74525");
        Assert.isNull(gameEveItem, "结果为空");
        System.out.println(gameEveItem.toString());
        Assert.isTrue(true, "测试通过");
    }

}
