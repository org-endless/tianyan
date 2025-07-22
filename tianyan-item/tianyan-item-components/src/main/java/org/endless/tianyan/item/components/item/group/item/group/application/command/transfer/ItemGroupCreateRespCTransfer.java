package org.endless.tianyan.item.components.item.group.item.group.application.command.transfer;

import org.endless.tianyan.item.common.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import org.endless.tianyan.item.components.item.group.item.group.domain.value.*;
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
 * ItemGroupCreateRespCTransfer
 * <p>物品分组创建命令响应传输对象
 * <p>
 * create 2025/07/21 16:19
 * <p>
 * update 2025/07/21 16:19
 *
 * @author Deng Haozhi
 * @see TianyanItemCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"itemGroupId"})
public class ItemGroupCreateRespCTransfer implements TianyanItemCommandTransfer {

    /**
     * 物品分组ID
     */
    private final String itemGroupId;

    @Override
    public ItemGroupCreateRespCTransfer validate() {
        validateItemGroupId();
        return this;
    }

    private void validateItemGroupId() {
        if (!StringUtils.hasText(itemGroupId)) {
            throw new CommandTransferValidateException("物品分组ID不能为空");
        }
    }
}
