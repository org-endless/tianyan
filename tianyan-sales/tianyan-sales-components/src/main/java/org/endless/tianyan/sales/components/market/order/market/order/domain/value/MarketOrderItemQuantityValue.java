package org.endless.tianyan.sales.components.market.order.market.order.domain.value;

import org.endless.tianyan.sales.common.model.domain.value.*;
import org.endless.tianyan.sales.components.market.order.market.order.domain.type.*;
import org.endless.ddd.simplified.starter.common.exception.model.domain.value.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * MarketOrderItemQuantityValue
 * <p>市场订单资源项数量
 * <p>
 * create 2025/07/26 18:16
 * <p>
 * update 2025/07/26 18:16
 *
 * @author Deng Haozhi
 * @see TianyanSalesValue
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class MarketOrderItemQuantityValue implements TianyanSalesValue {

    /**
     * 市场订单资源项总数(20, 5)
     */
    private final BigDecimal total;

    /**
     * 市场订单资源项剩余数量(20, 5)
     */
    private final BigDecimal remain;

    /**
     * 市场订单资源项最小交易数量(20, 5)
     */
    private final BigDecimal min;

    public static MarketOrderItemQuantityValue create(MarketOrderItemQuantityValueBuilder builder) {
        return builder
            .innerBuild()
            .validate();
    }

    @Override
    public MarketOrderItemQuantityValue validate() {
        validateTotal();
        validateRemain();
        validateMin();
        return this;
    }

    private void validateTotal() {
        if (total == null) {
            throw new ValueValidateException("市场订单资源项总数(20, 5)不能为 null ");
        }
    }

    private void validateRemain() {
        if (remain == null) {
            throw new ValueValidateException("市场订单资源项剩余数量(20, 5)不能为 null ");
        }
    }

    private void validateMin() {
        if (min == null) {
            throw new ValueValidateException("市场订单资源项最小交易数量(20, 5)不能为 null ");
        }
    }
}
