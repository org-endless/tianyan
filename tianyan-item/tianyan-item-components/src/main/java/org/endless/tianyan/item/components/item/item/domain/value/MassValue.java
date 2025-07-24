package org.endless.tianyan.item.components.item.item.domain.value;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.exception.model.domain.value.ValueValidateException;
import org.endless.ddd.simplified.starter.common.model.domain.type.MassUnitEnum;
import org.endless.tianyan.item.common.model.domain.value.TianyanItemValue;

import java.math.BigDecimal;

/**
 * MassValue
 * <p>质量
 * <p>
 * create 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see TianyanItemValue
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class MassValue implements TianyanItemValue {

    /**
     * 质量数量是否科学计数
     */
    private final Boolean isScientific;

    /**
     * 质量数量(20, 5)
     */
    private final BigDecimal quantity;

    /**
     * 质量数量科学计数
     */
    private final String scientific;

    /**
     * 质量单位
     */
    private final MassUnitEnum unit;

    public static MassValue create(MassValueBuilder builder) {
        return builder
                .isScientific(builder.isScientific)
                .unit(builder.unit)
                .innerBuild()
                .validate();
    }

    @Override
    public MassValue validate() {
        validateIsScientific();
        validateUnit();
        return this;
    }

    private void validateIsScientific() {
        if (isScientific == null) {
            throw new ValueValidateException("质量数量是否科学计数不能为 null ");
        }
    }

    private void validateUnit() {
        if (unit == null) {
            throw new ValueValidateException("质量单位不能为 null ");
        }
    }
}
