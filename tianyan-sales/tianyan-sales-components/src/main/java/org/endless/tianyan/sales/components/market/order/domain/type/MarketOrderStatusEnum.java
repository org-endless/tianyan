package org.endless.tianyan.sales.components.market.order.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.domain.type.EnumException;
import org.endless.tianyan.sales.common.model.domain.type.TianyanSalesEnum;

/**
 * MarketOrderTypeEnum
 * <p>市场订单状态
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
public enum MarketOrderStatusEnum implements TianyanSalesEnum {

    TRADING("TRADING", "交易中"),
    CANCELLED("CANCELLED", "已取消"),
    EXPIRED("EXPIRED", "已过期"),
    COMPLETED("COMPLETED", "已完成");

    private final String code;

    private final String description;

    public static MarketOrderStatusEnum fromCode(String code) {
        for (MarketOrderStatusEnum type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new EnumException("未知的市场订单状态枚举: " + code);
    }
}
