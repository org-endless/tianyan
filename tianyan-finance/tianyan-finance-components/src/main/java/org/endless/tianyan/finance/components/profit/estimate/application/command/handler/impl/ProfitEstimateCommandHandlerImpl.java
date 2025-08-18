package org.endless.tianyan.finance.components.profit.estimate.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.finance.components.profit.estimate.application.command.handler.ProfitEstimateCommandHandler;
import org.endless.tianyan.finance.components.profit.estimate.application.command.transfer.ProfitEstimateGenerateReqCTransfer;
import org.endless.tianyan.finance.components.profit.estimate.domain.anticorruption.ProfitEstimateRepository;

import java.util.Optional;

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

    @Override
    @Log(message = "预估利润生成命令", value = "#command", level = LogLevel.TRACE)
    public void generate(ProfitEstimateGenerateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ProfitEstimateGenerateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("预估利润生成命令参数不能为空"));
        //     生成成本
        //     生成收入
        //     生产税务
        //     生成费用
        //     计算利润
    }
}
