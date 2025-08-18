package org.endless.tianyan.finance.components.cost.type.application.command.handler.impl;

import org.endless.tianyan.finance.components.cost.type.application.command.handler.CostTypeCommandHandler;
import org.endless.tianyan.finance.components.cost.type.domain.anticorruption.CostTypeRepository;

/**
 * CostTypeCommandHandlerImpl
 * <p>成本类型领域命令处理器
 * <p>
 * create 2025/07/28 20:09
 * <p>
 * update 2025/07/28 20:09
 *
 * @author Deng Haozhi
 * @see CostTypeCommandHandler
 * @since 0.0.1
 */
public class CostTypeCommandHandlerImpl implements CostTypeCommandHandler {

    /**
     * 成本类型聚合仓储接口
     */
    private final CostTypeRepository costTypeRepository;

    public CostTypeCommandHandlerImpl(CostTypeRepository costTypeRepository) {
        this.costTypeRepository = costTypeRepository;
    }
}
