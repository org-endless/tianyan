package org.endless.tianyan.metadata.components.industry.industry.domain.value;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.domain.value.ValueValidateException;
import org.endless.tianyan.metadata.common.model.domain.value.TianyanMetadataValue;
import org.springframework.util.StringUtils;

/**
 * IndustryNameValue
 * <p>行业名称
 * <p>
 * create 2025/07/28 19:04
 * <p>
 * update 2025/07/28 19:04
 *
 * @author Deng Haozhi
 * @see TianyanMetadataValue
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class IndustryNameValue implements TianyanMetadataValue {

    /**
     * 行业中文名称
     */
    private final String nameZh;

    /**
     * 行业英文名称
     */
    private final String nameEn;

    public static IndustryNameValue create(IndustryNameValueBuilder builder) {
        return builder
                .innerBuild()
                .validate();
    }

    @Override
    public IndustryNameValue validate() {
        validateNameZh();
        return this;
    }

    private void validateNameZh() {
        if (!StringUtils.hasText(nameZh)) {
            throw new ValueValidateException("行业中文名称不能为空");
        }
    }
}
