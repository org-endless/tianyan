package org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.query.handler.impl;

import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.query.handler.*;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.query.anticorruption.*;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.handler.*;

/**
 * BlueprintQueryHandlerImpl
 * <p>蓝图领域查询处理器
 * <p>
 * create 2025/07/23 17:17
 * <p>
 * update 2025/07/23 17:17
 *
 * @author Deng Haozhi
 * @see BlueprintQueryHandler
 * @since 0.0.1
 */
public class BlueprintQueryHandlerImpl implements BlueprintQueryHandler {

    /**
     * 蓝图聚合查询仓储接口
     */
    private final BlueprintQueryRepository blueprintQueryRepository;

    /**
     * 蓝图物料实体查询仓储接口
     */
    private final BlueprintMaterialQueryRepository blueprintMaterialQueryRepository;

    /**
     * 蓝图产品实体查询仓储接口
     */
    private final BlueprintProductQueryRepository blueprintProductQueryRepository;

    /**
     * 蓝图技能实体查询仓储接口
     */
    private final BlueprintSkillQueryRepository blueprintSkillQueryRepository;

    public BlueprintQueryHandlerImpl(BlueprintQueryRepository blueprintQueryRepository, BlueprintMaterialQueryRepository blueprintMaterialQueryRepository, BlueprintProductQueryRepository blueprintProductQueryRepository, BlueprintSkillQueryRepository blueprintSkillQueryRepository) {
        this.blueprintQueryRepository = blueprintQueryRepository;
        this.blueprintMaterialQueryRepository = blueprintMaterialQueryRepository;
        this.blueprintProductQueryRepository = blueprintProductQueryRepository;
        this.blueprintSkillQueryRepository = blueprintSkillQueryRepository;
    }
}
