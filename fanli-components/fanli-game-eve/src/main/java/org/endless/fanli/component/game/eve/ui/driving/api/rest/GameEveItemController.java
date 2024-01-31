package org.endless.fanli.component.game.eve.ui.driving.api.rest;

import org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi.adapter.GameEveItemEsiRemoteAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GameEveItemController
 * <p>
 * <p>
 * <p>
 * <p>
 * create 2024/1/30 9:24
 * <p>
 * update 2024/1/30 9:24
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
@RestController
@RequestMapping("/game/eve/item")
public class GameEveItemController {

    private final GameEveItemEsiRemoteAdapter gameEveItemRemoteAdapter;

    public GameEveItemController(GameEveItemEsiRemoteAdapter gameEveItemRemoteAdapter) {
        this.gameEveItemRemoteAdapter = gameEveItemRemoteAdapter;
    }

    @GetMapping("/load")
    @PostMapping("/load")
    public String load() {

        // return gameEveItemRemoteAdapter.getItemIds(10).toString();

        return gameEveItemRemoteAdapter.getItemByItemId("10").toString();
    }
}
