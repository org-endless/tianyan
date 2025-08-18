package org.endless.tianyan.finance.components.cost.type.application.query.handler.impl;

import org.endless.tianyan.finance.components.cost.type.application.query.anticorruption.CostTypeQueryRepository;
import org.endless.tianyan.finance.components.cost.type.application.query.handler.CostTypeQueryHandler;

/**
 * CostTypeQueryHandlerImpl
 * <p>成本类型领域查询处理器
 * <p>
 * create 2025/07/28 20:09
 * <p>
 * update 2025/07/28 20:09
 *
 * @author Deng Haozhi
 * @see CostTypeQueryHandler
 * @since 0.0.1
 */
public class CostTypeQueryHandlerImpl implements CostTypeQueryHandler {

    /**
     * 成本类型聚合查询仓储接口
     */
    private final CostTypeQueryRepository costTypeQueryRepository;

    public CostTypeQueryHandlerImpl(CostTypeQueryRepository costTypeQueryRepository) {
        this.costTypeQueryRepository = costTypeQueryRepository;
    }
}
