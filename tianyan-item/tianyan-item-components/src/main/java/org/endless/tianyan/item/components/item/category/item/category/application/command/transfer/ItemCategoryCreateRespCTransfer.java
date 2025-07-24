package org.endless.tianyan.item.components.item.category.item.category.application.command.transfer;

import org.endless.tianyan.item.common.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import org.endless.tianyan.item.components.item.category.item.category.domain.value.*;
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
 * ItemCategoryCreateRespCTransfer
 * <p>资源项分类创建命令响应传输对象
 * <p>
 * create 2025/07/24 20:15
 * <p>
 * update 2025/07/24 20:15
 *
 * @author Deng Haozhi
 * @see TianyanItemCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"itemCategoryId"})
public class ItemCategoryCreateRespCTransfer implements TianyanItemCommandTransfer {

    /**
     * 资源项分类ID
     */
    private final String itemCategoryId;

    @Override
    public ItemCategoryCreateRespCTransfer validate() {
        validateItemCategoryId();
        return this;
    }

    private void validateItemCategoryId() {
        if (!StringUtils.hasText(itemCategoryId)) {
            throw new CommandTransferValidateException("资源项分类ID不能为空");
        }
    }
}
