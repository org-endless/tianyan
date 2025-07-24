package org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.transfer;

import org.endless.tianyan.manufacturing.common.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
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
 * BlueprintCreateRespCTransfer
 * <p>蓝图创建命令响应传输对象
 * <p>
 * create 2025/07/24 09:27
 * <p>
 * update 2025/07/24 09:27
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"blueprintId"})
public class BlueprintCreateRespCTransfer implements TianyanManufacturingCommandTransfer {

    /**
     * 蓝图ID
     */
    private final String blueprintId;

    @Override
    public BlueprintCreateRespCTransfer validate() {
        validateBlueprintId();
        return this;
    }

    private void validateBlueprintId() {
        if (!StringUtils.hasText(blueprintId)) {
            throw new CommandTransferValidateException("蓝图ID不能为空");
        }
    }
}
