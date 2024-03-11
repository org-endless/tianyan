package org.endless.fanli.component.game.eve.market.infrastructure.persistence.market;

import lombok.Builder;
import lombok.Getter;
import org.endless.fanli.component.game.eve.domain.common.type.PersistenceData;
import org.endless.fanli.component.game.eve.market.domain.model.order.Market;
import org.endless.fanli.component.game.eve.market.domain.model.order.Order;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.util.List;

/**
 * GameEveMarketDocument
 * <p>
 * <p>
 * <p>
 * <p>create 2024/02/06 18:58
 * <p>update 2024/02/06 18:58
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
@Getter
@Builder
@Document("game.eve.market")
public class GameEveMarketDocument implements PersistenceData<Market> {
    @Id
    @Field("itemId")
    private String itemId;
    private BigDecimal averagePrice;
    private BigDecimal highestPrice;
    private BigDecimal lowestPrice;
    private BigDecimal marketAnnualSalesQuantity;

    private List<Order> marketOrders;

    @Override
    public Market toEntity() {
        return Market.builder()
                .itemId(getItemId())
                .averagePrice(getAveragePrice())
                .highestPrice(getHighestPrice())
                .lowestPrice(getLowestPrice())
                .marketAnnualSalesQuantity(getMarketAnnualSalesQuantity())
                .marketOrders(getMarketOrders())
                .build();
    }

    @Override
    public GameEveMarketDocument fromEntity(Market entity) {

        itemId = entity.getItemId();
        averagePrice = entity.getAveragePrice();
        highestPrice = entity.getHighestPrice();
        lowestPrice = entity.getLowestPrice();
        marketAnnualSalesQuantity = entity.getMarketAnnualSalesQuantity();
        marketOrders = entity.getMarketOrders();

        return this;

    }


}
