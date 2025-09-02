package org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferValidateException;
import org.endless.tianyan.manufacturing.common.model.application.command.transfer.TianyanManufacturingCommandReqTransfer;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * BlueprintCreateReqCTransfer
 * <p>蓝图创建命令请求传输对象
 * <p>
 * create 2025/07/24 10:44
 * <p>
 * update 2025/07/24 10:44
 *
 * @param itemId       资源项ID
 * @param type         蓝图类型
 * @param materials    蓝图物料列表
 * @param products     蓝图产品列表
 * @param skills       蓝图技能列表
 * @param cycle        蓝图周期
 * @param createUserId 创建用户ID
 * @author Deng Haozhi
 * @see TianyanManufacturingCommandReqTransfer
 * @since 0.0.1
 */
@Builder
@JSONType(orders = {"itemId", "type", "materials", "products", "skills", "cycle", "createUserId"})
public record BlueprintCreateReqCReqTransfer(
        String itemId, String type, List<BlueprintMaterialReqCReqTransfer> materials,
        List<BlueprintProductReqCReqTransfer> products,
        List<BlueprintSkillReqCReqTransfer> skills, Long cycle,
        String createUserId
) implements TianyanManufacturingCommandReqTransfer {

    @Override
    public BlueprintCreateReqCReqTransfer validate() {
        validateItemId();
        validateType();
        validateCycle();
        validateCreateUserId();
        return this;
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new CommandReqTransferValidateException("资源项ID不能为空");
        }
    }

    private void validateType() {
        if (!StringUtils.hasText(type)) {
            throw new CommandReqTransferValidateException("蓝图类型不能为空");
        }
    }

    private void validateCycle() {
        if (cycle == null || cycle < 0) {
            throw new CommandReqTransferValidateException("蓝图周期不能为 null 或小于 0，当前值为: " + cycle);
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandReqTransferValidateException("创建用户ID不能为空");
        }
    }
}
