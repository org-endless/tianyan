package org.endless.tianyan.metadata.components.industry.category.domain.value;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.domain.value.ValueValidateException;
import org.endless.tianyan.metadata.common.model.domain.value.TianyanMetadataValue;
import org.springframework.util.StringUtils;

/**
 * IndustryCategoryNameValue
 * <p>行业分类名称
 * <p>
 * create 2025/07/28 18:57
 * <p>
 * update 2025/07/28 18:57
 *
 * @author Deng Haozhi
 * @see TianyanMetadataValue
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class IndustryCategoryNameValue implements TianyanMetadataValue {

    /**
     * 行业分类中文名称
     */
    private final String nameZh;

    /**
     * 行业分类英文名称
     */
    private final String nameEn;

    public static IndustryCategoryNameValue create(IndustryCategoryNameValueBuilder builder) {
        return builder
                .innerBuild()
                .validate();
    }

    @Override
    public IndustryCategoryNameValue validate() {
        validateNameZh();
        return this;
    }

    private void validateNameZh() {
        if (!StringUtils.hasText(nameZh)) {
            throw new ValueValidateException("行业分类中文名称不能为空");
        }
    }
}
