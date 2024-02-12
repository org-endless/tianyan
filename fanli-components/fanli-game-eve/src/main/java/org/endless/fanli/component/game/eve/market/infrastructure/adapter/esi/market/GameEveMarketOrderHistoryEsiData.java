package org.endless.fanli.component.game.eve.market.infrastructure.adapter.esi.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.endless.fanli.component.game.eve.domain.common.type.RemoteData;
import org.endless.fanli.component.game.eve.market.domain.model.order.GameEveMarketOrderHistory;
import org.endless.spring.boot.common.utility.decimal.Decimal;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * GameEveMarketOrderHistoryEsiData
 * <p>
 * <p>
 * <p>
 * <p>create 2024/02/06 15:16
 * <p>update 2024/02/06 15:16
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
public record GameEveMarketOrderHistoryEsiData(
        @JsonProperty("date") LocalDate orderDate,
        @JsonProperty("average") BigDecimal averagePrice,
        @JsonProperty("highest") BigDecimal highestPrice,
        @JsonProperty("lowest") BigDecimal lowestPrice,
        @JsonProperty("order_count") BigDecimal orderQuantity,
        @JsonProperty("volume") BigDecimal itemQuantity

) implements RemoteData<GameEveMarketOrderHistory> {
    @Override
    public GameEveMarketOrderHistory toEntity() {
        return GameEveMarketOrderHistory.builder()
                .orderDate(orderDate())
                .averagePrice(Decimal.format(averagePrice()))
                .highestPrice(Decimal.format(highestPrice()))
                .lowestPrice(Decimal.format(lowestPrice()))
                .orderQuantity(Decimal.format(orderQuantity()))
                .itemQuantity(Decimal.format(itemQuantity()))
                .build();
    }
}
