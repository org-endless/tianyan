package org.endless.fanli.component.game.eve.domain.common.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * TradeType
 * <p>
 * <p>
 * <p>
 * <p>create 2024/2/4 0:20
 * <p>update 2024/2/4 0:20
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
@Getter
@AllArgsConstructor
public enum TradeType {
    BUY("0", "Buy", "买入"),
    SELL("1", "Sell", "卖出");

    private final String tradeId;
    private final String enDescription;
    private final String zhDescription;
}
