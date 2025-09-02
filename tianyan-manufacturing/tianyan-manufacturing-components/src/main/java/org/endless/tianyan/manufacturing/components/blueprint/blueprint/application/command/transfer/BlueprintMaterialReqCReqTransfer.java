package org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferValidateException;
import org.endless.tianyan.manufacturing.common.model.application.command.transfer.TianyanManufacturingCommandReqTransfer;
import org.springframework.util.StringUtils;

/**
 * BlueprintMaterialReqCTransfer
 * <p>蓝图物料命令请求传输对象
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
@JSONType(orders = {"itemId", "quantity"})
public class BlueprintMaterialReqCReqTransfer implements TianyanManufacturingCommandReqTransfer {

    /**
     * 资源项ID
     */
    private final String itemId;

    /**
     * 蓝图物料数量
     */
    private final Long quantity;

    @Override
    public BlueprintMaterialReqCReqTransfer validate() {
        validateItemId();
        validateQuantity();
        return this;
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new CommandReqTransferValidateException("资源项ID不能为空");
        }
    }

    private void validateQuantity() {
        if (quantity == null || quantity < 0) {
            throw new CommandReqTransferValidateException("蓝图物料数量不能为 null 或小于 0，当前值为: " + quantity);
        }
    }
}
