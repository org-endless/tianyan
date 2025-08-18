package org.endless.tianyan.finance.components.profit.estimate.application.query.handler.impl;

import org.endless.tianyan.finance.components.profit.estimate.application.query.anticorruption.ProfitEstimateQueryRepository;
import org.endless.tianyan.finance.components.profit.estimate.application.query.anticorruption.ProfitMetricQueryRepository;
import org.endless.tianyan.finance.components.profit.estimate.application.query.handler.ProfitEstimateQueryHandler;

/**
 * ProfitEstimateQueryHandlerImpl
 * <p>预估利润领域查询处理器
 * <p>
 * create 2025/07/28 19:36
 * <p>
 * update 2025/07/28 19:36
 *
 * @author Deng Haozhi
 * @see ProfitEstimateQueryHandler
 * @since 0.0.1
 */
public class ProfitEstimateQueryHandlerImpl implements ProfitEstimateQueryHandler {

    /**
     * 预估利润聚合查询仓储接口
     */
    private final ProfitEstimateQueryRepository profitEstimateQueryRepository;

    /**
     * 利润指标实体查询仓储接口
     */
    private final ProfitMetricQueryRepository profitMetricQueryRepository;

    public ProfitEstimateQueryHandlerImpl(ProfitEstimateQueryRepository profitEstimateQueryRepository, ProfitMetricQueryRepository profitMetricQueryRepository) {
        this.profitEstimateQueryRepository = profitEstimateQueryRepository;
        this.profitMetricQueryRepository = profitMetricQueryRepository;
    }
}
