package org.endless.fanli.component.game.eve.metadata.presentation.api.rest;

import org.endless.fanli.component.game.eve.common.infrastructure.adapter.esi.item.GameEveItemEsiDataAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GameEveItemController
 * <p>
 * <p>
 * <p>
 * <p>create 2024/1/30 9:24
 * <p>update 2024/1/30 9:24
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
@RestController
@RequestMapping("/game/eve/item")
public class GameEveItemController {

    private final GameEveItemEsiDataAdapter gameEveItemRemoteAdapter;

    public GameEveItemController(GameEveItemEsiDataAdapter gameEveItemRemoteAdapter) {
        this.gameEveItemRemoteAdapter = gameEveItemRemoteAdapter;
    }

    @GetMapping("/load")
    @PostMapping("/load")
    public String load() {

        return gameEveItemRemoteAdapter.getItemByItemId("10").toString();
    }
}
