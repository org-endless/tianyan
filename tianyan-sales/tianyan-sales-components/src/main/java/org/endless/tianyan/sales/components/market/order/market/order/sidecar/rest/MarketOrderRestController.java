package org.endless.tianyan.sales.components.market.order.market.order.sidecar.rest;

import org.endless.tianyan.sales.common.model.sidecar.rest.*;
import org.endless.tianyan.sales.components.market.order.market.order.facade.adapter.*;
import org.endless.ddd.simplified.starter.common.exception.model.sidecar.rest.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MarketOrderRestController
 * <p>市场订单领域Rest控制器
 * <p>
 * create 2025/07/25 13:11
 * <p>
 * update 2025/07/25 13:11
 *
 * @author Deng Haozhi
 * @see TianyanSalesRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/market/order")
public class MarketOrderRestController implements TianyanSalesRestController {

    /**
     * 市场订单领域主动适配器
     */
    private final MarketOrderDrivingAdapter marketOrderDrivingAdapter;

    public MarketOrderRestController(MarketOrderDrivingAdapter marketOrderDrivingAdapter) {
        this.marketOrderDrivingAdapter = marketOrderDrivingAdapter;
    }
}
