package org.endless.tianyan.sales.components.market.price.history.sidecar.rest;

import org.endless.tianyan.sales.common.model.sidecar.rest.TianyanSalesRestController;
import org.endless.tianyan.sales.components.market.price.history.facade.adapter.MarketPriceHistoryDrivingAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MarketPriceHistoryRestController
 * <p>市场价格历史领域Rest控制器
 * <p>
 * create 2025/07/26 18:57
 * <p>
 * update 2025/07/26 18:57
 *
 * @author Deng Haozhi
 * @see TianyanSalesRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/market/price/history")
public class MarketPriceHistoryRestController implements TianyanSalesRestController {

    /**
     * 市场价格历史领域主动适配器
     */
    private final MarketPriceHistoryDrivingAdapter marketPriceHistoryDrivingAdapter;

    public MarketPriceHistoryRestController(MarketPriceHistoryDrivingAdapter marketPriceHistoryDrivingAdapter) {
        this.marketPriceHistoryDrivingAdapter = marketPriceHistoryDrivingAdapter;
    }
}
