package org.endless.tianyan.metadata.components.event.type.domain.value;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.domain.value.ValueValidateException;
import org.endless.tianyan.metadata.common.model.domain.value.TianyanMetadataValue;
import org.springframework.util.StringUtils;

/**
 * EventTypeNameValue
 * <p>事件类型名称
 * <p>
 * create 2025/07/28 18:41
 * <p>
 * update 2025/07/28 18:41
 *
 * @author Deng Haozhi
 * @see TianyanMetadataValue
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class EventTypeNameValue implements TianyanMetadataValue {

    /**
     * 事件类型中文名称
     */
    private final String nameZh;

    /**
     * 事件类型英文名称
     */
    private final String nameEn;

    public static EventTypeNameValue create(EventTypeNameValueBuilder builder) {
        return builder
                .innerBuild()
                .validate();
    }

    @Override
    public EventTypeNameValue validate() {
        validateNameZh();
        return this;
    }

    private void validateNameZh() {
        if (!StringUtils.hasText(nameZh)) {
            throw new ValueValidateException("事件类型中文名称不能为空");
        }
    }
}
