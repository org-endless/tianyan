package org.endless.tianyan.sales.components.market.order.domain.value;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.annotation.validate.ddd.Value;
import org.endless.tianyan.sales.common.model.domain.value.TianyanSalesValue;
import org.springframework.validation.annotation.Validated;

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
@Value
@Validated
@Builder(buildMethodName = "innerBuild")
public class MarketOrderItemQuantityValue implements TianyanSalesValue {

    /**
     * 市场订单资源项总数(20, 5)
     */
    @NotNull(message = "市场订单资源项总数不能为空")
    private final BigDecimal total;

    /**
     * 市场订单资源项剩余数量(20, 5)
     */
    @NotNull(message = "市场订单资源项剩余数量不能为空")
    private final BigDecimal remain;

    /**
     * 市场订单资源项最小交易数量(20, 5)
     */
    @NotNull(message = "市场订单资源项最小交易数量不能为空")
    private final BigDecimal min;


    @NotNull(message = "市场订单资源项数量值对象创建方法返回不能为空")
    public static @Valid MarketOrderItemQuantityValue create(
            @NotNull(message = "市场订单资源项数量值对象构造器不能为空")
            MarketOrderItemQuantityValueBuilder builder) {
        return builder.innerBuild();
    }

    @Override
    public MarketOrderItemQuantityValue validate() {
        return this;
    }
}
