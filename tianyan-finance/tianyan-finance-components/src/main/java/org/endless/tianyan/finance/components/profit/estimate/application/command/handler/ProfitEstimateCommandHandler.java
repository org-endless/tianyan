package org.endless.tianyan.finance.components.profit.estimate.application.command.handler;

import org.endless.tianyan.finance.common.model.application.command.handler.TianyanFinanceCommandHandler;
import org.endless.tianyan.finance.components.profit.estimate.application.command.transfer.ProfitEstimateGenerateReqCTransfer;
import org.endless.tianyan.finance.components.profit.estimate.domain.entity.ProfitEstimateAggregate;

/**
 * ProfitEstimateCommandHandler
 * <p>预估利润领域命令处理器
 * <p>
 * create 2025/07/28 19:36
 * <p>
 * update 2025/07/28 19:36
 *
 * @author Deng Haozhi
 * @see TianyanFinanceCommandHandler<ProfitEstimateAggregate>
 * @since 0.0.1
 */
public interface ProfitEstimateCommandHandler extends TianyanFinanceCommandHandler<ProfitEstimateAggregate> {

    void generate(ProfitEstimateGenerateReqCTransfer command);
}
