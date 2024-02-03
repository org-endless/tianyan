package org.endless.fanli.component.game.eve.infrastructure.driven.adapter.esi.market;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * GameEveMarketOrderEsiData
 * <p>
 * <p>
 * <p>
 * <p>create 2024/2/3 20:20
 * <p>update 2024/2/3 20:20
 *
 * @param orderDuration Order duration in days.
 * @param issuedDate    LocalDate
 * @author Deng Haozhi
 * @since 0.0.6
 */
public record GameEveMarketOrderEsiData
        (@JsonProperty("type_id") String itemId,
         @JsonProperty("order_id") String orderId,
         @JsonProperty("price") BigDecimal price,
         @JsonProperty("min_volume") BigDecimal minTransQuantity,
         @JsonProperty("volume_remain") BigDecimal remainQuantity,
         @JsonProperty("volume_total") BigDecimal totalQuantity,
         @JsonProperty("duration") BigDecimal orderDuration,
         @JsonProperty("is_buy_order") boolean isBuyOrder,
         @JsonProperty("issued") LocalDateTime issuedDate,
         @JsonProperty("system_id") String universeSystemId,
         @JsonProperty("location_id") String universeLocationId,
         @JsonProperty("range") String universeRange) {

}
