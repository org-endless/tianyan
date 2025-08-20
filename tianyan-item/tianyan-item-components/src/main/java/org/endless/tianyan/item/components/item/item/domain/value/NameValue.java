package org.endless.tianyan.item.components.item.item.domain.value;

import lombok.Builder;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
import org.endless.ddd.starter.common.annotation.validate.ddd.Value;
import org.endless.ddd.starter.common.utils.model.object.ObjectTools;
import org.endless.tianyan.item.common.model.domain.value.TianyanItemValue;

/**
 * NameValue
 * <p>名称
 * <p>
 * itemCreate 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @param fullName     全称
 * @param alias        别名
 * @param abbreviation 简称
 * @author Deng Haozhi
 * @see TianyanItemValue
 * @since 0.0.1
 */
@Value
@Builder(buildMethodName = "innerBuild")
public record NameValue(
        @NotBlank(message = "全称不能为空") String fullName,
        String alias,
        String abbreviation
) implements TianyanItemValue {

    public static NameValue create(NameValueBuilder builder) {
        return ObjectTools.JSRValidate(builder.innerBuild()).validate();
    }

    @Override
    public NameValue validate() {
        return this;
    }
}
