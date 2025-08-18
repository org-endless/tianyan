package org.endless.tianyan.finance.components.cost.rule.sidecar.rest;

import org.endless.tianyan.finance.common.model.sidecar.rest.TianyanFinanceRestController;
import org.endless.tianyan.finance.components.cost.rule.facade.adapter.CostRuleDrivingAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CostRuleRestController
 * <p>成本规则领域Rest控制器
 * <p>
 * create 2025/07/28 20:10
 * <p>
 * update 2025/07/28 20:10
 *
 * @author Deng Haozhi
 * @see TianyanFinanceRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/cost/rule")
public class CostRuleRestController implements TianyanFinanceRestController {

    /**
     * 成本规则领域主动适配器
     */
    private final CostRuleDrivingAdapter costRuleDrivingAdapter;

    public CostRuleRestController(CostRuleDrivingAdapter costRuleDrivingAdapter) {
        this.costRuleDrivingAdapter = costRuleDrivingAdapter;
    }
}
