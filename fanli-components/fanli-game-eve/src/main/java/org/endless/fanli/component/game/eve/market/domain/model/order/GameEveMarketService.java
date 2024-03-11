package org.endless.fanli.component.game.eve.market.domain.model.order;

import org.endless.fanli.component.game.eve.domain.common.type.GameEveService;
import org.endless.spring.boot.common.utility.decimal.Decimal;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * GameEveMarketService
 * <p>
 * <p>
 * <p>
 * <p>create 2024/02/06 17:50
 * <p>update 2024/02/06 17:50
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
@Service
public class GameEveMarketService implements GameEveService {

    private final GameEveMarketRemoteDataAdapter adapter;
    private final GameEveMarketRepository repository;

    public GameEveMarketService(GameEveMarketRemoteDataAdapter adapter, GameEveMarketRepository repository) {
        this.adapter = adapter;
        this.repository = repository;
    }

    public void saveMarket() {


    }

    public BigDecimal getMarketAnnualSalesQuantity(String itemId) {

        GameEveMarketAggregate aggregate = Market.builder()
                .itemId(itemId)
                .build();

        return Decimal.format(aggregate.calculateMarketAnnualSalesQuantity(
                adapter.getRegionMarketOrderHistoryByItemId(itemId, GAME_EVE_FORGE_REGION_ID)));

    }
}
