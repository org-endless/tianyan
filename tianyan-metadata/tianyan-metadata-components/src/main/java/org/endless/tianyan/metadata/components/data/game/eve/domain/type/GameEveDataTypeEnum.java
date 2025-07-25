package org.endless.tianyan.metadata.components.data.game.eve.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.exception.model.domain.type.EnumException;
import org.endless.tianyan.metadata.common.model.domain.type.TianyanMetadataEnum;

/**
 * GameEveDataTypeEnum
 * <p>游戏EVE数据类型枚举
 * <p>
 * create 2025/07/24 11:47
 * <p>
 * update 2025/07/24 11:47
 *
 * @author Deng Haozhi
 * @see TianyanMetadataEnum
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
@ToString
public enum GameEveDataTypeEnum implements TianyanMetadataEnum {

    ITEM("ITEM", "资源项"),
    ITEM_CATEGORY("ITEM_CATEGORY", "资源项分类"),
    ITEM_GROUP("ITEM_GROUP", "资源项分组"),
    MARKET_GROUP("MARKET_GROUP", "市场分组"),
    BLUEPRINT("BLUEPRINT", "蓝图"),
    META_GROUP("META_GROUP", "元分组");

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
