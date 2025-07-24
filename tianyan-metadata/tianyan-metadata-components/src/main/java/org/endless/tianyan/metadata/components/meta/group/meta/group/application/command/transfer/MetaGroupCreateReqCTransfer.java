package org.endless.tianyan.metadata.components.meta.group.meta.group.application.command.transfer;

import org.endless.tianyan.metadata.common.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import org.endless.tianyan.metadata.components.meta.group.meta.group.domain.value.*;
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
 * MetaGroupCreateReqCTransfer
 * <p>元分组创建命令请求传输对象
 * <p>
 * create 2025/07/24 11:29
 * <p>
 * update 2025/07/24 11:29
 *
 * @author Deng Haozhi
 * @see TianyanMetadataCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"fullNameZh", "fullNameEn", "createUserId"})
public class MetaGroupCreateReqCTransfer implements TianyanMetadataCommandTransfer {

    /**
     * 中文全称
     */
    private final String fullNameZh;

    /**
     * 英文全称
     */
    private final String fullNameEn;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    @Override
    public MetaGroupCreateReqCTransfer validate() {
        validateFullNameZh();
        validateFullNameEn();
        validateCreateUserId();
        return this;
    }

    private void validateFullNameZh() {
        if (!StringUtils.hasText(fullNameZh)) {
            throw new CommandTransferValidateException("中文全称不能为空");
        }
    }

    private void validateFullNameEn() {
        if (!StringUtils.hasText(fullNameEn)) {
            throw new CommandTransferValidateException("英文全称不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandTransferValidateException("创建用户ID不能为空");
        }
    }
}
