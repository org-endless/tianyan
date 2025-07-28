package org.endless.tianyan.metadata.components.industry.category.application.command.transfer;

import org.endless.tianyan.metadata.common.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.*;
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
 * IndustryCategoryCreateReqCTransfer
 * <p>行业分类创建命令请求传输对象
 * <p>
 * create 2025/07/28 18:57
 * <p>
 * update 2025/07/28 18:57
 *
 * @author Deng Haozhi
 * @see TianyanMetadataCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"code", "nameZh", "nameEn", "description", "createUserId"})
public class IndustryCategoryCreateReqCTransfer implements TianyanMetadataCommandTransfer {

    /**
     * 行业分类编码
     */
    private final String code;

    /**
     * 行业分类中文名称
     */
    private final String nameZh;

    /**
     * 行业分类英文名称
     */
    private final String nameEn;

    /**
     * 行业分类描述
     */
    private final String description;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    @Override
    public IndustryCategoryCreateReqCTransfer validate() {
        validateCode();
        validateNameZh();
        validateCreateUserId();
        return this;
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new CommandTransferValidateException("行业分类编码不能为空");
        }
    }

    private void validateNameZh() {
        if (!StringUtils.hasText(nameZh)) {
            throw new CommandTransferValidateException("行业分类中文名称不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandTransferValidateException("创建用户ID不能为空");
        }
    }
}
