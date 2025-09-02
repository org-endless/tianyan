package org.endless.tianyan.metadata.components.metagroup.metagroup.domain.value;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Value;
import org.endless.tianyan.metadata.common.model.domain.value.TianyanMetadataValue;

/**
 * NameValue
 * <p>名称
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @param fullName     全称
 * @param alias        别名
 * @param abbreviation 简称
 * @author Deng Haozhi
 * @see TianyanMetadataValue
 * @since 0.0.1
 */
@Value
@Builder(buildMethodName = "innerBuild")
public record NameValue(
        @NotBlank(message = "全称不能为空") String fullName,
        String alias,
        String abbreviation
) implements TianyanMetadataValue {

    @NotNull(message = "名称值对象创建方法返回对象不能为空")
    public static @Valid NameValue create(
            @NotNull(message = "名称值对象构造器不能为空")
            NameValueBuilder builder) {
        return builder.innerBuild().validate();
    }

    @Override
    public NameValue validate() {
        return this;
    }
}
