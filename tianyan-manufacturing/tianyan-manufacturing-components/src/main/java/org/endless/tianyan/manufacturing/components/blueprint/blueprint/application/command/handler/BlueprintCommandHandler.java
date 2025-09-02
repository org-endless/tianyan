package org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.handler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.manufacturing.common.model.application.command.handler.TianyanManufacturingCommandHandler;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.transfer.BlueprintCreateReqCReqTransfer;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.transfer.BlueprintCreateRespCReqTransfer;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.entity.BlueprintAggregate;

/**
 * BlueprintCommandHandler
 * <p>蓝图领域命令处理器
 * <p>
 * create 2025/07/23 17:17
 * <p>
 * update 2025/07/23 17:17
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingCommandHandler<BlueprintAggregate>
 * @since 0.0.1
 */
public interface BlueprintCommandHandler extends TianyanManufacturingCommandHandler<BlueprintAggregate> {

    /**
     * 蓝图创建命令
     *
     * @param command 蓝图创建命令请求传输对象
     * @return {@link BlueprintCreateRespCReqTransfer }
     */
    @Valid
    @NotNull(message = "蓝图创建命令响应传输对象不能为空")
    BlueprintCreateRespCReqTransfer create(
            @NotNull(message = "蓝图创建命令请求传输对象不能为空")
            @Valid BlueprintCreateReqCReqTransfer command);

}
