package org.endless.tianyan.sales.components.market.order.market.order.facade.adapter;

import org.endless.tianyan.sales.common.model.facade.adapter.TianyanSalesDrivingAdapter;
import org.endless.tianyan.sales.components.market.order.market.order.application.command.transfer.MarketOrderCreateReqCTransfer;
import org.endless.tianyan.sales.components.market.order.market.order.application.command.transfer.MarketOrderCreateRespCTransfer;

/**
 * MarketOrderDrivingAdapter
 * <p>市场订单领域主动适配器
 * <p>
 * create 2025/07/25 13:11
 * <p>
 * update 2025/07/25 13:11
 *
 * @author Deng Haozhi
 * @see TianyanSalesDrivingAdapter
 * @since 0.0.1
 */
public interface MarketOrderDrivingAdapter extends TianyanSalesDrivingAdapter {

    MarketOrderCreateRespCTransfer create(MarketOrderCreateReqCTransfer command);

    MarketOrderCreateRespCTransfer modify(MarketOrderCreateReqCTransfer command);
}
