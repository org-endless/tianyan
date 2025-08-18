package org.endless.tianyan.finance.components.taxation.tax.rule.domain.value;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.domain.value.ValueValidateException;
import org.endless.tianyan.finance.common.model.domain.value.TianyanFinanceValue;
import org.springframework.util.StringUtils;

/**
 * TaxRuleNameValue
 * <p>税务规则名称
 * <p>
 * create 2025/07/28 18:34
 * <p>
 * update 2025/07/28 18:34
 *
 * @author Deng Haozhi
 * @see TianyanFinanceValue
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class TaxRuleNameValue implements TianyanFinanceValue {

    /**
     * 税务规则中文名称
     */
    private final String nameZh;

    /**
     * 税务规则英文名称
     */
    private final String nameEn;

    public static TaxRuleNameValue create(TaxRuleNameValueBuilder builder) {
        return builder
                .innerBuild()
                .validate();
    }

    @Override
    public TaxRuleNameValue validate() {
        validateNameZh();
        return this;
    }

    private void validateNameZh() {
        if (!StringUtils.hasText(nameZh)) {
            throw new ValueValidateException("税务规则中文名称不能为空");
        }
    }
}
