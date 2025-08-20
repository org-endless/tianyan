package org.endless.tianyan.item.components.item.group.item.group.domain.value;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.domain.value.ValueValidateException;
import org.endless.tianyan.item.common.model.domain.value.TianyanItemValue;
import org.springframework.util.StringUtils;

/**
 * NameValue
 * <p>名称
 * <p>
 * itemCreate 2025/07/21 16:27
 * <p>
 * update 2025/07/21 16:27
 *
 * @author Deng Haozhi
 * @see TianyanItemValue
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class NameValue implements TianyanItemValue {

    /**
     * 全称
     */
    private final String fullName;

    /**
     * 别名
     */
    private final String alias;

    /**
     * 简称
     */
    private final String abbreviation;

    public static NameValue create(NameValueBuilder builder) {
        return builder
                .fullName(builder.fullName)
                .innerBuild()
                .validate();
    }

    @Override
    public NameValue validate() {
        validateFullName();
        return this;
    }

    private void validateFullName() {
        if (!StringUtils.hasText(fullName)) {
            throw new ValueValidateException("全称不能为空");
        }
    }
}
