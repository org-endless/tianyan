package org.endless.tianyan.finance.components.cost.type.facade.adapter.spring;

import org.endless.tianyan.finance.components.cost.type.application.command.handler.CostTypeCommandHandler;
import org.endless.tianyan.finance.components.cost.type.application.query.handler.CostTypeQueryHandler;
import org.endless.tianyan.finance.components.cost.type.facade.adapter.CostTypeDrivingAdapter;

/**
 * SpringCostTypeDrivingAdapter
 * <p>成本类型领域主动适配器Spring实现类
 * <p>
 * create 2025/07/28 20:09
 * <p>
 * update 2025/07/28 20:09
 *
 * @author Deng Haozhi
 * @see CostTypeDrivingAdapter
 * @since 0.0.1
 */
public class SpringCostTypeDrivingAdapter implements CostTypeDrivingAdapter {

    /**
     * 成本类型领域命令处理器
     */
    private final CostTypeCommandHandler costTypeCommandHandler;

    /**
     * 成本类型领域查询处理器
     */
    private final CostTypeQueryHandler costTypeQueryHandler;

    public SpringCostTypeDrivingAdapter(CostTypeCommandHandler costTypeCommandHandler, CostTypeQueryHandler costTypeQueryHandler) {
        this.costTypeCommandHandler = costTypeCommandHandler;
        this.costTypeQueryHandler = costTypeQueryHandler;
    }
}
