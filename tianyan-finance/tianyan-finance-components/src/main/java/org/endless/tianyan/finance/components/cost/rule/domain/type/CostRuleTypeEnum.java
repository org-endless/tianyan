package org.endless.tianyan.finance.components.cost.rule.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.domain.type.EnumException;
import org.endless.tianyan.finance.common.model.domain.type.TianyanFinanceEnum;

/**
 * CostRuleTypeEnum
 * <p>成本规则类型枚举
 * <p>
 * create 2025/07/28 20:10
 * <p>
 * update 2025/07/28 20:10
 *
 * @author Deng Haozhi
 * @see TianyanFinanceEnum
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
@ToString
public enum CostRuleTypeEnum implements TianyanFinanceEnum {

    FIXED_PERCENTAGE("FIXED_PERCENTAGE", "按固定比例"),
    LADDER_PERCENTAGE("LADDER_PERCENTAGE", "按阶梯比例"),
    FIXED_AMOUNT("FIXED_AMOUNT", "按固定金额");

    private final String code;

    private final String description;

    public static CostRuleTypeEnum fromCode(String code) {
        for (CostRuleTypeEnum type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new EnumException("未知的成本规则类型枚举: " + code);
    }
}
