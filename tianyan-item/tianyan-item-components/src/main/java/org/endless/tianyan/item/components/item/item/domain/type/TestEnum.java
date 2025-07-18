package org.endless.tianyan.item.components.item.item.domain.type;

import org.endless.tianyan.item.common.model.domain.type.*;
import org.endless.ddd.simplified.starter.common.exception.model.domain.type.*;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * TestEnum
 * <p>测试枚举
 * <p>
 * create 2025/07/19 07:15
 * <p>
 * update 2025/07/19 07:15
 *
 * @author Deng Haozhi
 * @see TianyanItemEnum
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
@ToString
public enum TestEnum implements TianyanItemEnum {

    TEST("TEST", "TEST"),
    TEST1("TEST1", "TEST11");

    private final String code;

    private final String description;

    public static TestEnum fromCode(String code) {
        for (TestEnum type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new EnumException("未知的测试枚举: " + code);
    }
}
