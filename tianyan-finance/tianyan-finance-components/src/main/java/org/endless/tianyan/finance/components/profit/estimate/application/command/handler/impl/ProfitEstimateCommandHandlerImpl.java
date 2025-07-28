package org.endless.tianyan.finance.components.profit.estimate.application.command.handler.impl;

import org.endless.tianyan.finance.components.profit.estimate.application.command.handler.*;
import org.endless.tianyan.finance.components.profit.estimate.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.handler.*;

/**
 * ProfitEstimateCommandHandlerImpl
 * <p>预估利润领域命令处理器
 * <p>
 * create 2025/07/28 19:36
 * <p>
 * update 2025/07/28 19:36
 *
 * @author Deng Haozhi
 * @see ProfitEstimateCommandHandler
 * @since 0.0.1
 */
public class ProfitEstimateCommandHandlerImpl implements ProfitEstimateCommandHandler {

    /**
     * 预估利润聚合仓储接口
     */
    private final ProfitEstimateRepository profitEstimateRepository;

    public ProfitEstimateCommandHandlerImpl(ProfitEstimateRepository profitEstimateRepository) {
        this.profitEstimateRepository = profitEstimateRepository;
    }
}
