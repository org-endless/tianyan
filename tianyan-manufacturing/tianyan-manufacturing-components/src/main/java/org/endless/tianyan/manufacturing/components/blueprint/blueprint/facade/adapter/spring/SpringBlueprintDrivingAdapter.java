package org.endless.tianyan.manufacturing.components.blueprint.blueprint.facade.adapter.spring;

import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.handler.BlueprintCommandHandler;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.transfer.BlueprintCreateReqCTransfer;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.transfer.BlueprintCreateRespCTransfer;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.query.handler.BlueprintQueryHandler;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.facade.adapter.BlueprintDrivingAdapter;

/**
 * SpringBlueprintDrivingAdapter
 * <p>蓝图领域主动适配器Spring实现类
 * <p>
 * create 2025/07/23 17:17
 * <p>
 * update 2025/07/23 17:17
 *
 * @author Deng Haozhi
 * @see BlueprintDrivingAdapter
 * @since 0.0.1
 */
public class SpringBlueprintDrivingAdapter implements BlueprintDrivingAdapter {

    /**
     * 蓝图领域命令处理器
     */
    private final BlueprintCommandHandler blueprintCommandHandler;

    /**
     * 蓝图领域查询处理器
     */
    private final BlueprintQueryHandler blueprintQueryHandler;

    public SpringBlueprintDrivingAdapter(BlueprintCommandHandler blueprintCommandHandler, BlueprintQueryHandler blueprintQueryHandler) {
        this.blueprintCommandHandler = blueprintCommandHandler;
        this.blueprintQueryHandler = blueprintQueryHandler;
    }

    @Override
    public BlueprintCreateRespCTransfer create(BlueprintCreateReqCTransfer command) {
        return blueprintCommandHandler.create(command);
    }
}
