package org.endless.tianyan.sales.components.market.group.market.group.domain.value;

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
 * NameValue
 * <p>名称
 * <p>
 * create 2025/07/24 17:36
 * <p>
 * update 2025/07/24 17:36
 *
 * @author Deng Haozhi
 * @see TianyanSalesValue
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class NameValue implements TianyanSalesValue {

    /**
     * 全称
     */
    private final String fullName;

    /**
     * 别名
     */
    private final String alias;

    /**
     * 简称
     */
    private final String abbreviation;

    public static NameValue create(NameValueBuilder builder) {
        return builder
            .innerBuild()
            .validate();
    }

    @Override
    public NameValue validate() {
        validateFullName();
        return this;
    }

    private void validateFullName() {
        if (!StringUtils.hasText(fullName)) {
            throw new ValueValidateException("全称不能为空");
        }
    }
}
