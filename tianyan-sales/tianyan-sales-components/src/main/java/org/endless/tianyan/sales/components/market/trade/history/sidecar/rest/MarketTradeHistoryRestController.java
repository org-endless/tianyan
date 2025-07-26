package org.endless.tianyan.sales.components.market.trade.history.sidecar.rest;

import org.endless.tianyan.sales.common.model.sidecar.rest.*;
import org.endless.tianyan.sales.components.market.trade.history.facade.adapter.*;
import org.endless.ddd.simplified.starter.common.exception.model.sidecar.rest.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MarketTradeHistoryRestController
 * <p>市场交易历史领域Rest控制器
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
@RequestMapping("/market/trade/history")
public class MarketTradeHistoryRestController implements TianyanSalesRestController {

    /**
     * 市场交易历史领域主动适配器
     */
    private final MarketTradeHistoryDrivingAdapter marketTradeHistoryDrivingAdapter;

    public MarketTradeHistoryRestController(MarketTradeHistoryDrivingAdapter marketTradeHistoryDrivingAdapter) {
        this.marketTradeHistoryDrivingAdapter = marketTradeHistoryDrivingAdapter;
    }
}
