package org.endless.tianyan.sales.components.market.trade.history.domain.value;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.domain.value.ValueValidateException;
import org.endless.tianyan.sales.common.model.domain.value.TianyanSalesValue;

/**
 * MarketTradeHistoryPeriodValue
 * <p>市场交易历史范围
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
public class MarketTradeHistoryPeriodValue implements TianyanSalesValue {

    /**
     * 市场交易历史范围开始时间
     */
    private final Long periodStartAt;

    /**
     * 市场交易历史范围结束时间
     */
    private final Long periodEndAt;

    public static MarketTradeHistoryPeriodValue create(MarketTradeHistoryPeriodValueBuilder builder) {
        return builder
                .innerBuild()
                .validate();
    }

    @Override
    public MarketTradeHistoryPeriodValue validate() {
        validatePeriodStartAt();
        validatePeriodEndAt();
        return this;
    }

    private void validatePeriodStartAt() {
        if (periodStartAt == null || periodStartAt < 0) {
            throw new ValueValidateException("市场交易历史范围开始时间不能为 null 或小于 0，当前值为: " + periodStartAt);
        }
    }

    private void validatePeriodEndAt() {
        if (periodEndAt == null || periodEndAt < 0) {
            throw new ValueValidateException("市场交易历史范围结束时间不能为 null 或小于 0，当前值为: " + periodEndAt);
        }
    }
}
