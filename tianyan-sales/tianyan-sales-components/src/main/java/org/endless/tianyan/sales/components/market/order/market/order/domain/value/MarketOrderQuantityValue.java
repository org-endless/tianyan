package org.endless.tianyan.sales.components.market.order.market.order.domain.value;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.exception.model.domain.value.ValueValidateException;
import org.endless.tianyan.sales.common.model.domain.value.TianyanSalesValue;

import java.math.BigDecimal;

/**
 * MarketOrderQuantityValue
 * <p>市场订单数量
 * <p>
 * create 2025/07/25 13:28
 * <p>
 * update 2025/07/25 13:28
 *
 * @author Deng Haozhi
 * @see TianyanSalesValue
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class MarketOrderQuantityValue implements TianyanSalesValue {

    /**
     * 市场订单总数(20, 5)
     */
    private final BigDecimal total;

    /**
     * 市场订单剩余数量(20, 5)
     */
    private final BigDecimal remain;

    /**
     * 市场订单最小交易数量(20, 5)
     */
    private final BigDecimal min;

    public static MarketOrderQuantityValue create(MarketOrderQuantityValueBuilder builder) {
        return builder
            .innerBuild()
            .validate();
    }

    @Override
    public MarketOrderQuantityValue validate() {
        validateTotal();
        validateRemain();
        validateMin();
        return this;
    }

    private void validateTotal() {
        if (total == null) {
            throw new ValueValidateException("市场订单总数(20, 5)不能为 null ");
        }
    }

    private void validateRemain() {
        if (remain == null) {
            throw new ValueValidateException("市场订单剩余数量(20, 5)不能为 null ");
        }
    }

    private void validateMin() {
        if (min == null) {
            throw new ValueValidateException("市场订单最小交易数量(20, 5)不能为 null ");
        }
    }
}
