package org.endless.tianyan.sales.components.market.group.sidecar.rest;

import org.endless.tianyan.sales.common.model.sidecar.rest.*;
import org.endless.tianyan.sales.components.market.group.facade.adapter.*;
import org.endless.ddd.simplified.starter.common.exception.model.sidecar.rest.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MarketGroupRestController
 * <p>市场分组领域Rest控制器
 * <p>
 * create 2025/07/22 09:08
 * <p>
 * update 2025/07/22 09:08
 *
 * @author Deng Haozhi
 * @see TianyanSalesRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/market/group")
public class MarketGroupRestController implements TianyanSalesRestController {

    /**
     * 市场分组领域主动适配器
     */
    private final MarketGroupDrivingAdapter marketGroupDrivingAdapter;

    public MarketGroupRestController(MarketGroupDrivingAdapter marketGroupDrivingAdapter) {
        this.marketGroupDrivingAdapter = marketGroupDrivingAdapter;
    }
}
