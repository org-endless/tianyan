package org.endless.tianyan.sales.components.market.group.domain.value;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Value;
import org.endless.tianyan.sales.common.model.domain.value.TianyanSalesValue;

/**
 * NameValue
 * <p>名称
 * <p>
 * create 2025/07/24 17:36
 * <p>
 * update 2025/07/24 17:36
 *
 * @author Deng Haozhi
 * @see TianyanSalesValue
 * @since 0.0.1
 */
@Value
@Builder(buildMethodName = "innerBuild")
public record NameValue(
        @NotBlank(message = "全称不能为空") String fullName,
        String alias,
        String abbreviation
) implements TianyanSalesValue {

    @NotNull(message = "名称值对象创建方法返回对象不能为空")
    public static @Valid NameValue create(
            @NotNull(message = "名称值对象构造器不能为空") NameValueBuilder builder) {
        return builder.innerBuild().validate();
    }

    @Override
    public NameValue validate() {
        return this;
    }
}
