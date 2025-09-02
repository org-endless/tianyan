package org.endless.tianyan.metadata.components.event.type.domain.value;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Value;
import org.endless.tianyan.metadata.common.model.domain.value.TianyanMetadataValue;

/**
 * EventTypeNameValue
 * <p>事件类型名称
 * <p>
 * create 2025/07/28 18:41
 * <p>
 * update 2025/07/28 18:41
 *
 * @param nameZh 事件类型中文名称
 * @param nameEn 事件类型英文名称
 * @author Deng Haozhi
 * @see TianyanMetadataValue
 * @since 0.0.1
 */
@Value
@Builder(buildMethodName = "innerBuild")
public record EventTypeNameValue(
        @NotBlank(message = "事件类型中文名称不能为空") String nameZh,
        String nameEn
) implements TianyanMetadataValue {

    @NotNull(message = "事件类型名称值对象创建方法返回对象不能为空")
    public static @Valid EventTypeNameValue create(
            @NotNull(message = "事件类型名称值对象构造器不能为空")
            EventTypeNameValueBuilder builder) {
        return builder
                .innerBuild()
                .validate();
    }

    @Override
    public EventTypeNameValue validate() {
        return this;
    }
}
