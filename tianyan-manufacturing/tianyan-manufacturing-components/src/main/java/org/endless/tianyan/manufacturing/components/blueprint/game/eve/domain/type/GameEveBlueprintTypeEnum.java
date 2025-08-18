package org.endless.tianyan.manufacturing.components.blueprint.game.eve.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.domain.type.EnumException;
import org.endless.tianyan.manufacturing.common.model.domain.type.TianyanManufacturingEnum;

/**
 * GameEveBlueprintTypeEnum
 * <p>游戏EVE蓝图类型枚举
 * <p>
 * create 2025/07/24 09:18
 * <p>
 * update 2025/07/24 09:18
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingEnum
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
@ToString
public enum GameEveBlueprintTypeEnum implements TianyanManufacturingEnum {

    PRODUCTION("PRODUCTION", "生产"),
    INVENTION("INVENTION", "发明"),
    BLUEPRINT_COPYING("BLUEPRINT_COPYING", "蓝图复制"),
    BLUEPRINT_MATERIAL_IMPROVEMENT("BLUEPRINT_MATERIAL_IMPROVEMENT", "蓝图材料优化"),
    BLUEPRINT_CYCLE_IMPROVEMENT("BLUEPRINT_CYCLE_IMPROVEMENT", "蓝图周期优化");

    private final String code;

    private final String description;

    public static GameEveBlueprintTypeEnum fromCode(String code) {
        for (GameEveBlueprintTypeEnum type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new EnumException("未知的游戏EVE蓝图类型枚举: " + code);
    }
}
