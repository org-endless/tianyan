package org.endless.tianyan.finance.components.profit.estimate.facade.adapter.spring;

import org.endless.tianyan.finance.components.profit.estimate.application.command.handler.ProfitEstimateCommandHandler;
import org.endless.tianyan.finance.components.profit.estimate.application.command.transfer.ProfitEstimateGenerateReqCTransfer;
import org.endless.tianyan.finance.components.profit.estimate.application.query.handler.ProfitEstimateQueryHandler;
import org.endless.tianyan.finance.components.profit.estimate.facade.adapter.ProfitEstimateDrivingAdapter;

/**
 * SpringProfitEstimateDrivingAdapter
 * <p>预估利润领域主动适配器Spring实现类
 * <p>
 * create 2025/07/28 19:36
 * <p>
 * update 2025/07/28 19:36
 *
 * @author Deng Haozhi
 * @see ProfitEstimateDrivingAdapter
 * @since 0.0.1
 */
public class SpringProfitEstimateDrivingAdapter implements ProfitEstimateDrivingAdapter {

    /**
     * 预估利润领域命令处理器
     */
    private final ProfitEstimateCommandHandler profitEstimateCommandHandler;

    /**
     * 预估利润领域查询处理器
     */
    private final ProfitEstimateQueryHandler profitEstimateQueryHandler;

    public SpringProfitEstimateDrivingAdapter(ProfitEstimateCommandHandler profitEstimateCommandHandler, ProfitEstimateQueryHandler profitEstimateQueryHandler) {
        this.profitEstimateCommandHandler = profitEstimateCommandHandler;
        this.profitEstimateQueryHandler = profitEstimateQueryHandler;
    }

    @Override
    public void generate(ProfitEstimateGenerateReqCTransfer command) {
        profitEstimateCommandHandler.generate(command);
    }
}
