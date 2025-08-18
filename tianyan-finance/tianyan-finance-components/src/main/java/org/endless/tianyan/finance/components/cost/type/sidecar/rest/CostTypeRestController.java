package org.endless.tianyan.finance.components.cost.type.sidecar.rest;

import org.endless.tianyan.finance.common.model.sidecar.rest.TianyanFinanceRestController;
import org.endless.tianyan.finance.components.cost.type.facade.adapter.CostTypeDrivingAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CostTypeRestController
 * <p>成本类型领域Rest控制器
 * <p>
 * create 2025/07/28 20:09
 * <p>
 * update 2025/07/28 20:09
 *
 * @author Deng Haozhi
 * @see TianyanFinanceRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/cost/type")
public class CostTypeRestController implements TianyanFinanceRestController {

    /**
     * 成本类型领域主动适配器
     */
    private final CostTypeDrivingAdapter costTypeDrivingAdapter;

    public CostTypeRestController(CostTypeDrivingAdapter costTypeDrivingAdapter) {
        this.costTypeDrivingAdapter = costTypeDrivingAdapter;
    }
}
