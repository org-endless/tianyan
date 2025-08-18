package org.endless.tianyan.finance.components.taxation.tax.rule.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.domain.type.EnumException;
import org.endless.tianyan.finance.common.model.domain.type.TianyanFinanceEnum;

/**
 * TaxRuleTypeEnum
 * <p>税务规则类型枚举
 * <p>
 * create 2025/07/28 18:34
 * <p>
 * update 2025/07/28 18:34
 *
 * @author Deng Haozhi
 * @see TianyanFinanceEnum
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
@ToString
public enum TaxRuleTypeEnum implements TianyanFinanceEnum {

    FIXED_PERCENTAGE("FIXED_PERCENTAGE", "按固定比例"),
    LADDER_PERCENTAGE("LADDER_PERCENTAGE", "按阶梯比例"),
    FIXED_AMOUNT("FIXED_AMOUNT", "按固定金额");

    private final String code;

    private final String description;

    public static TaxRuleTypeEnum fromCode(String code) {
        for (TaxRuleTypeEnum type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new EnumException("未知的税务规则类型枚举: " + code);
    }
}
