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
 * MetaGroupCreateRespCTransfer
 * <p>元分组创建命令响应传输对象
 * <p>
 * create 2025/07/24 20:25
 * <p>
 * update 2025/07/24 20:25
 *
 * @author Deng Haozhi
 * @see TianyanMetadataCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"metaGroupId"})
public class MetaGroupCreateRespCTransfer implements TianyanMetadataCommandTransfer {

    /**
     * 元分组ID
     */
    private final String metaGroupId;

    @Override
    public MetaGroupCreateRespCTransfer validate() {
        validateMetaGroupId();
        return this;
    }

    private void validateMetaGroupId() {
        if (!StringUtils.hasText(metaGroupId)) {
            throw new CommandTransferValidateException("元分组ID不能为空");
        }
    }
}
