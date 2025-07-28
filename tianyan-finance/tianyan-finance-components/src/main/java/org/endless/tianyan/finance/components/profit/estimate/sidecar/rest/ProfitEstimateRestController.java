package org.endless.tianyan.finance.components.profit.estimate.sidecar.rest;

import org.endless.tianyan.finance.common.model.sidecar.rest.*;
import org.endless.tianyan.finance.components.profit.estimate.facade.adapter.*;
import org.endless.ddd.simplified.starter.common.exception.model.sidecar.rest.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProfitEstimateRestController
 * <p>预估利润领域Rest控制器
 * <p>
 * create 2025/07/28 19:36
 * <p>
 * update 2025/07/28 19:36
 *
 * @author Deng Haozhi
 * @see TianyanFinanceRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/profit/estimate")
public class ProfitEstimateRestController implements TianyanFinanceRestController {

    /**
     * 预估利润领域主动适配器
     */
    private final ProfitEstimateDrivingAdapter profitEstimateDrivingAdapter;

    public ProfitEstimateRestController(ProfitEstimateDrivingAdapter profitEstimateDrivingAdapter) {
        this.profitEstimateDrivingAdapter = profitEstimateDrivingAdapter;
    }
}
