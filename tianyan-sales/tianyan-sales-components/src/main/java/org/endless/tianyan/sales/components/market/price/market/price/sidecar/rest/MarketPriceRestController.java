package org.endless.tianyan.sales.components.market.price.market.price.sidecar.rest;

import org.endless.tianyan.sales.common.model.sidecar.rest.TianyanSalesRestController;
import org.endless.tianyan.sales.components.market.price.market.price.facade.adapter.MarketPriceDrivingAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MarketPriceRestController
 * <p>市场价格领域Rest控制器
 * <p>
 * create 2025/07/26 18:56
 * <p>
 * update 2025/07/26 18:56
 *
 * @author Deng Haozhi
 * @see TianyanSalesRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/market/price")
public class MarketPriceRestController implements TianyanSalesRestController {

    /**
     * 市场价格领域主动适配器
     */
    private final MarketPriceDrivingAdapter marketPriceDrivingAdapter;

    public MarketPriceRestController(MarketPriceDrivingAdapter marketPriceDrivingAdapter) {
        this.marketPriceDrivingAdapter = marketPriceDrivingAdapter;
    }
}
