package org.endless.fanli.component.game.eve.metadata.presentation.api.rest;

import org.endless.fanli.component.game.eve.common.infrastructure.adapter.esi.market.GameEveMarketEsiDataAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GameEveMarketOrderController
 * <p>
 * <p>
 * <p>
 * <p>create 2024/2/3 20:48
 * <p>update 2024/2/3 20:48
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
@RestController
@RequestMapping("/game/eve/marker/order")
public class GameEveMarketOrderController {

    private final GameEveMarketEsiDataAdapter adapter;

    public GameEveMarketOrderController(GameEveMarketEsiDataAdapter adapter) {
        this.adapter = adapter;
    }

    @GetMapping("/load")
    @PostMapping("/load")
    public String load() {
        return adapter.getRegionMarketOrdersByItemId("33818", "10000002").toString();
        // return "success";
    }
}
