package org.endless.tianyan.finance.components.cost.type.domain.value;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.domain.value.ValueValidateException;
import org.endless.tianyan.finance.common.model.domain.value.TianyanFinanceValue;
import org.springframework.util.StringUtils;

/**
 * CostTypeNameValue
 * <p>成本类型名称
 * <p>
 * create 2025/07/28 20:09
 * <p>
 * update 2025/07/28 20:09
 *
 * @author Deng Haozhi
 * @see TianyanFinanceValue
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class CostTypeNameValue implements TianyanFinanceValue {

    /**
     * 事件类型中文名称
     */
    private final String nameZh;

    /**
     * 事件类型英文名称
     */
    private final String nameEn;

    public static CostTypeNameValue create(CostTypeNameValueBuilder builder) {
        return builder
                .innerBuild()
                .validate();
    }

    @Override
    public CostTypeNameValue validate() {
        validateNameZh();
        return this;
    }

    private void validateNameZh() {
        if (!StringUtils.hasText(nameZh)) {
            throw new ValueValidateException("事件类型中文名称不能为空");
        }
    }
}
