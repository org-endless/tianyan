package org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.type;

import org.endless.tianyan.manufacturing.common.model.domain.type.*;
import org.endless.ddd.simplified.starter.common.exception.model.domain.type.*;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * BlueprintTypeEnum
 * <p>蓝图类型枚举
 * <p>
 * create 2025/07/24 10:42
 * <p>
 * update 2025/07/24 10:42
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingEnum
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
@ToString
public enum BlueprintTypeEnum implements TianyanManufacturingEnum {

    PRODUCTION("PRODUCTION", "生产"),
    INVENTION("INVENTION", "发明"),
    BLUEPRINT_COPYING("BLUEPRINT_COPYING", "蓝图复制"),
    BLUEPRINT_MATERIAL_IMPROVEMENT("BLUEPRINT_MATERIAL_IMPROVEMENT", "蓝图材料优化"),
    BLUEPRINT_CYCLE_IMPROVEMENT("BLUEPRINT_CYCLE_IMPROVEMENT", "蓝图周期优化");

    private final String code;

    private final String description;

    public static BlueprintTypeEnum fromCode(String code) {
        for (BlueprintTypeEnum type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new EnumException("未知的蓝图类型枚举: " + code);
    }
}
