package org.endless.tianyan.sales.components.market.trade.history.domain.value;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.domain.value.ValueValidateException;
import org.endless.tianyan.sales.common.model.domain.value.TianyanSalesValue;

import java.math.BigDecimal;

/**
 * MarketTradeHistoryPriceValue
 * <p>市场交易历史成交价格
 * <p>
 * create 2025/07/26 18:57
 * <p>
 * update 2025/07/26 18:57
 *
 * @author Deng Haozhi
 * @see TianyanSalesValue
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class MarketTradeHistoryPriceValue implements TianyanSalesValue {

    /**
     * 市场交易历史平均成交价格(17, 2)
     */
    private final BigDecimal average;

    /**
     * 市场交易历史最高成交价格(17, 2)
     */
    private final BigDecimal highest;

    /**
     * 市场交易历史最低成交价格(17, 2)
     */
    private final BigDecimal lowest;

    public static MarketTradeHistoryPriceValue create(MarketTradeHistoryPriceValueBuilder builder) {
        return builder
                .innerBuild()
                .validate();
    }

    @Override
    public MarketTradeHistoryPriceValue validate() {
        validateAverage();
        validateHighest();
        validateLowest();
        return this;
    }

    private void validateAverage() {
        if (average == null) {
            throw new ValueValidateException("市场交易历史平均成交价格(17, 2)不能为 null ");
        }
    }

    private void validateHighest() {
        if (highest == null) {
            throw new ValueValidateException("市场交易历史最高成交价格(17, 2)不能为 null ");
        }
    }

    private void validateLowest() {
        if (lowest == null) {
            throw new ValueValidateException("市场交易历史最低成交价格(17, 2)不能为 null ");
        }
    }
}
