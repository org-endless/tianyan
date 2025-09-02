package org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandRespTransferValidateException;
import org.endless.tianyan.manufacturing.common.model.application.command.transfer.TianyanManufacturingCommandReqTransfer;
import org.springframework.util.StringUtils;

/**
 * BlueprintCreateRespCTransfer
 * <p>蓝图创建命令响应传输对象
 * <p>
 * create 2025/07/24 10:44
 * <p>
 * update 2025/07/24 10:44
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingCommandReqTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"blueprintId"})
public class BlueprintCreateRespCReqTransfer implements TianyanManufacturingCommandReqTransfer {

    /**
     * 蓝图ID
     */
    private final String blueprintId;

    @Override
    public BlueprintCreateRespCReqTransfer validate() {
        validateBlueprintId();
        return this;
    }

    private void validateBlueprintId() {
        if (!StringUtils.hasText(blueprintId)) {
            throw new CommandRespTransferValidateException("蓝图ID不能为空");
        }
    }
}
