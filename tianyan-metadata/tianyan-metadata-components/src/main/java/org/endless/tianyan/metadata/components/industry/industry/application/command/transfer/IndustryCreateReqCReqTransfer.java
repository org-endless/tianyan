package org.endless.tianyan.metadata.components.industry.industry.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferValidateException;
import org.endless.tianyan.metadata.common.model.application.command.transfer.TianyanMetadataCommandReqTransfer;
import org.springframework.util.StringUtils;

/**
 * IndustryCreateReqCTransfer
 * <p>行业创建命令请求传输对象
 * <p>
 * create 2025/07/28 19:14
 * <p>
 * update 2025/07/28 19:14
 *
 * @author Deng Haozhi
 * @see TianyanMetadataCommandReqTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"industryCategoryId", "code", "nameZh", "nameEn", "description", "createUserId"})
public class IndustryCreateReqCReqTransfer implements TianyanMetadataCommandReqTransfer {

    /**
     * 行业分类ID
     */
    private final String industryCategoryId;

    /**
     * 行业编码
     */
    private final String code;

    /**
     * 行业中文名称
     */
    private final String nameZh;

    /**
     * 行业英文名称
     */
    private final String nameEn;

    /**
     * 行业描述
     */
    private final String description;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    @Override
    public IndustryCreateReqCReqTransfer validate() {
        validateIndustryCategoryId();
        validateCode();
        validateNameZh();
        validateCreateUserId();
        return this;
    }

    private void validateIndustryCategoryId() {
        if (!StringUtils.hasText(industryCategoryId)) {
            throw new CommandReqTransferValidateException("行业分类ID不能为空");
        }
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new CommandReqTransferValidateException("行业编码不能为空");
        }
    }

    private void validateNameZh() {
        if (!StringUtils.hasText(nameZh)) {
            throw new CommandReqTransferValidateException("行业中文名称不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandReqTransferValidateException("创建用户ID不能为空");
        }
    }
}
