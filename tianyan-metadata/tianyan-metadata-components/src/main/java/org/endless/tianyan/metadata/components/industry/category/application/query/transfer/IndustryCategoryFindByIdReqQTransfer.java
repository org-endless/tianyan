package org.endless.tianyan.metadata.components.industry.category.application.query.transfer;

import org.endless.tianyan.metadata.common.model.application.query.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.transfer.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import org.endless.tianyan.metadata.components.industry.category.domain.value.*;
import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * IndustryCategoryFindByIdReqQTransfer
 * <p>行业分类根据ID查询请求传输对象
 * <p>
 * create 2025/07/28 19:23
 * <p>
 * update 2025/07/28 19:23
 *
 * @author Deng Haozhi
 * @see TianyanMetadataQueryTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"industryCategoryId"})
public class IndustryCategoryFindByIdReqQTransfer implements TianyanMetadataQueryTransfer {

    /**
     * 行业分类ID
     */
    private final String industryCategoryId;

    @Override
    public IndustryCategoryFindByIdReqQTransfer validate() {
        validateIndustryCategoryId();
        return this;
    }

    private void validateIndustryCategoryId() {
        if (!StringUtils.hasText(industryCategoryId)) {
            throw new QueryTransferValidateException("行业分类ID不能为空");
        }
    }
}
