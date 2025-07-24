package org.endless.tianyan.item.components.item.item.domain.value;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.exception.model.domain.value.ValueValidateException;
import org.endless.ddd.simplified.starter.common.model.domain.type.VolumeUnitEnum;
import org.endless.tianyan.item.common.model.domain.value.TianyanItemValue;

import java.math.BigDecimal;

/**
 * VolumeValue
 * <p>体积
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
public class VolumeValue implements TianyanItemValue {

    /**
     * 体积数量是否科学计数
     */
    private final Boolean isScientific;

    /**
     * 体积数量(20, 5)
     */
    private final BigDecimal quantity;

    /**
     * 体积数量科学计数
     */
    private final String scientific;

    /**
     * 体积单位
     */
    private final VolumeUnitEnum unit;

    public static VolumeValue create(VolumeValueBuilder builder) {
        return builder
                .isScientific(builder.isScientific)
                .unit(builder.unit)
                .innerBuild()
                .validate();
    }

    @Override
    public VolumeValue validate() {
        validateIsScientific();
        validateUnit();
        return this;
    }

    private void validateIsScientific() {
        if (isScientific == null) {
            throw new ValueValidateException("体积数量是否科学计数不能为 null ");
        }
    }

    private void validateUnit() {
        if (unit == null) {
            throw new ValueValidateException("体积单位不能为 null ");
        }
    }
}
