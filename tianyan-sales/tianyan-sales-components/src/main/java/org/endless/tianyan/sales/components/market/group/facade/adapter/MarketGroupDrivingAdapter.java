package org.endless.tianyan.sales.components.market.group.facade.adapter;

import org.endless.tianyan.sales.common.model.facade.adapter.TianyanSalesDrivingAdapter;
import org.endless.tianyan.sales.components.market.group.application.command.transfer.MarketGroupCreateReqCTransfer;
import org.endless.tianyan.sales.components.market.group.application.command.transfer.MarketGroupCreateRespCTransfer;
import org.endless.tianyan.sales.components.market.group.application.query.transfer.MarketGroupFindByIdReqQTransfer;

/**
 * MarketGroupDrivingAdapter
 * <p>市场分组领域主动适配器
 * <p>
 * create 2025/07/22 16:05
 * <p>
 * update 2025/07/22 16:05
 *
 * @author Deng Haozhi
 * @see TianyanSalesDrivingAdapter
 * @since 0.0.1
 */
public interface MarketGroupDrivingAdapter extends TianyanSalesDrivingAdapter {

    MarketGroupCreateRespCTransfer create(MarketGroupCreateReqCTransfer command);

    void existsById(MarketGroupFindByIdReqQTransfer query);
}
