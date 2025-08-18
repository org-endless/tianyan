package org.endless.tianyan.finance.components.profit.estimate.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.domain.type.EnumException;
import org.endless.tianyan.finance.common.model.domain.type.TianyanFinanceEnum;

/**
 * ProfitMetricTypeEnum
 * <p>利润指标类型枚举
 * <p>
 * create 2025/07/28 19:36
 * <p>
 * update 2025/07/28 19:36
 *
 * @author Deng Haozhi
 * @see TianyanFinanceEnum
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
@ToString
public enum ProfitMetricTypeEnum implements TianyanFinanceEnum {

    GROSS("GROSS", "毛利润"),
    NET("NET", "净利润");

    private final String code;

    private final String description;

    public static ProfitMetricTypeEnum fromCode(String code) {
        for (ProfitMetricTypeEnum type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new EnumException("未知的利润指标类型枚举: " + code);
    }
}
