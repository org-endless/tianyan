package org.endless.tianyan.sales.components.market.order.market.order.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.exception.model.domain.type.EnumException;
import org.endless.tianyan.sales.common.model.domain.type.TianyanSalesEnum;

/**
 * MarketOrderTypeEnum
 * <p>市场订单类型枚举
 * <p>
 * create 2025/07/25 13:11
 * <p>
 * update 2025/07/25 13:11
 *
 * @author Deng Haozhi
 * @see TianyanSalesEnum
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
@ToString
public enum MarketOrderTypeEnum implements TianyanSalesEnum {

    BUY("BUY", "买入"),
    SELL("SELL", "卖出");

    private final String code;

    private final String description;

    public static MarketOrderTypeEnum fromCode(String code) {
        for (MarketOrderTypeEnum type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new EnumException("未知的市场订单类型枚举: " + code);
    }
}
