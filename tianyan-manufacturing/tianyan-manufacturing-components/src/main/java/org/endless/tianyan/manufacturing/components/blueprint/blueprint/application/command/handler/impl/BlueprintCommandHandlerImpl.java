package org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.handler.impl;

import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.handler.*;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.handler.*;

/**
 * BlueprintCommandHandlerImpl
 * <p>蓝图领域命令处理器
 * <p>
 * create 2025/07/23 17:17
 * <p>
 * update 2025/07/23 17:17
 *
 * @author Deng Haozhi
 * @see BlueprintCommandHandler
 * @since 0.0.1
 */
public class BlueprintCommandHandlerImpl implements BlueprintCommandHandler {

    /**
     * 蓝图聚合仓储接口
     */
    private final BlueprintRepository blueprintRepository;

    public BlueprintCommandHandlerImpl(BlueprintRepository blueprintRepository) {
        this.blueprintRepository = blueprintRepository;
    }
}
