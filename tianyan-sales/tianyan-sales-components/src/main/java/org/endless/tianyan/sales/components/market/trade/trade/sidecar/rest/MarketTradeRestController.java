package org.endless.tianyan.sales.components.market.trade.trade.sidecar.rest;

import org.endless.tianyan.sales.common.model.facade.rest.TianyanSalesRestController;
import org.endless.tianyan.sales.components.market.trade.trade.facade.adapter.MarketTradeDrivingAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MarketTradeRestController
 * <p>市场交易领域REST控制器
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
@RequestMapping("/market/trade")
public class MarketTradeRestController implements TianyanSalesRestController {

    /**
     * 市场交易领域主动适配器
     */
    private final MarketTradeDrivingAdapter marketTradeDrivingAdapter;

    public MarketTradeRestController(MarketTradeDrivingAdapter marketTradeDrivingAdapter) {
        this.marketTradeDrivingAdapter = marketTradeDrivingAdapter;
    }

    @Override
    public String domainDescription() {
        return "市场交易领域";
    }
}
