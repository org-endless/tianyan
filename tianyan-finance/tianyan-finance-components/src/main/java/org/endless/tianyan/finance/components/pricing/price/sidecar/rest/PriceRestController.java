package org.endless.tianyan.finance.components.pricing.price.sidecar.rest;

import org.endless.tianyan.finance.common.model.sidecar.rest.*;
import org.endless.tianyan.finance.components.pricing.price.facade.adapter.*;
import org.endless.ddd.simplified.starter.common.exception.model.sidecar.rest.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PriceRestController
 * <p>价格领域Rest控制器
 * <p>
 * create 2025/07/19 08:27
 * <p>
 * update 2025/07/19 08:27
 *
 * @author Deng Haozhi
 * @see TianyanFinanceRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/pricing/price")
public class PriceRestController implements TianyanFinanceRestController {

    /**
     * 价格领域主动适配器
     */
    private final PriceDrivingAdapter priceDrivingAdapter;

    public PriceRestController(PriceDrivingAdapter priceDrivingAdapter) {
        this.priceDrivingAdapter = priceDrivingAdapter;
    }
}
