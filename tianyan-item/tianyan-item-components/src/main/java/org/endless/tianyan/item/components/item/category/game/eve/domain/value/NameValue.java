package org.endless.tianyan.item.components.item.category.game.eve.domain.value;

import org.endless.tianyan.item.common.model.domain.value.*;
import org.endless.tianyan.item.components.item.category.game.eve.domain.type.*;
import org.endless.ddd.simplified.starter.common.exception.model.domain.value.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * NameValue
 * <p>名称
 * <p>
 * create 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
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
                .alias(builder.alias)
                .abbreviation(builder.abbreviation)
            .innerBuild()
            .validate();
    }

    @Override
    public NameValue validate() {
        validateFullName();
        validateAlias();
        validateAbbreviation();
        return this;
    }

    private void validateFullName() {
        if (!StringUtils.hasText(fullName)) {
            throw new ValueValidateException("全称不能为空");
        }
    }

    private void validateAlias() {
        if (!StringUtils.hasText(alias)) {
            throw new ValueValidateException("别名不能为空");
        }
    }

    private void validateAbbreviation() {
        if (!StringUtils.hasText(abbreviation)) {
            throw new ValueValidateException("简称不能为空");
        }
    }
}
