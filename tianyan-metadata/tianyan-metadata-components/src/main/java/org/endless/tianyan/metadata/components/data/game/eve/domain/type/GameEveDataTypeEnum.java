package org.endless.tianyan.metadata.components.data.game.eve.domain.type;

import org.endless.tianyan.metadata.common.model.domain.type.*;
import org.endless.ddd.simplified.starter.common.exception.model.domain.type.*;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * GameEveDataTypeEnum
 * <p>游戏EVE数据类型枚举
 * <p>
 * create 2025/07/20 23:05
 * <p>
 * update 2025/07/20 23:05
 *
 * @author Deng Haozhi
 * @see TianyanMetadataEnum
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
@ToString
public enum GameEveDataTypeEnum implements TianyanMetadataEnum {

    ITEM("ITEM", "物品"),
    ITEM_CATEGORY("ITEM_CATEGORY", "物品分类"),
    ITEM_GROUP("ITEM_GROUP", "物品分组");

    private final String code;

    private final String description;

    public static GameEveDataTypeEnum fromCode(String code) {
        for (GameEveDataTypeEnum type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new EnumException("未知的游戏EVE数据类型枚举: " + code);
    }
}
