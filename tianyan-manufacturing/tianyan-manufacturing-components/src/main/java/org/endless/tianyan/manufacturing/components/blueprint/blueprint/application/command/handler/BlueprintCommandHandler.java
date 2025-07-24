package org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.handler;

import org.endless.tianyan.manufacturing.common.model.application.command.handler.TianyanManufacturingCommandHandler;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.transfer.BlueprintCreateReqCTransfer;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.transfer.BlueprintCreateRespCTransfer;
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

    BlueprintCreateRespCTransfer create(BlueprintCreateReqCTransfer command);

}
