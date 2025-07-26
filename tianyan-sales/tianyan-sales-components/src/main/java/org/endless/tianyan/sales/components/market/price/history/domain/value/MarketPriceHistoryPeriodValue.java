package org.endless.tianyan.sales.components.market.price.history.domain.value;

import org.endless.tianyan.sales.common.model.domain.value.*;
import org.endless.ddd.simplified.starter.common.exception.model.domain.value.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * MarketPriceHistoryPeriodValue
 * <p>市场价格历史范围
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
public class MarketPriceHistoryPeriodValue implements TianyanSalesValue {

    /**
     * 市场价格历史范围开始时间
     */
    private final Long periodStartAt;

    /**
     * 市场价格历史范围结束时间
     */
    private final Long periodEndAt;

    public static MarketPriceHistoryPeriodValue create(MarketPriceHistoryPeriodValueBuilder builder) {
        return builder
            .innerBuild()
            .validate();
    }

    @Override
    public MarketPriceHistoryPeriodValue validate() {
        validatePeriodStartAt();
        validatePeriodEndAt();
        return this;
    }

    private void validatePeriodStartAt() {
        if (periodStartAt == null || periodStartAt < 0) {
            throw new ValueValidateException("市场价格历史范围开始时间不能为 null 或小于 0，当前值为: " + periodStartAt);
        }
    }

    private void validatePeriodEndAt() {
        if (periodEndAt == null || periodEndAt < 0) {
            throw new ValueValidateException("市场价格历史范围结束时间不能为 null 或小于 0，当前值为: " + periodEndAt);
        }
    }
}
