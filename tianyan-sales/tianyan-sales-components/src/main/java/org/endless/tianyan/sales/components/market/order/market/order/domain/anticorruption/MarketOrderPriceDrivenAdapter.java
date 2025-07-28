package org.endless.tianyan.sales.components.market.order.market.order.domain.anticorruption;

import org.endless.tianyan.sales.common.model.domain.anticorruption.TianyanSalesDrivenAdapter;
import org.endless.tianyan.sales.components.market.order.market.order.domain.entity.MarketOrderAggregate;

import java.util.List;

/**
 * MarketOrderPriceDrivenAdapter
 * <p>
 * create 2025/07/26 19:30
 * <p>
 * update 2025/07/26 19:30
 *
 * @author Deng Haozhi
 * @see TianyanSalesDrivenAdapter
 * @since 2.0.0
 */
public interface MarketOrderPriceDrivenAdapter extends TianyanSalesDrivenAdapter {

    void generatePrice(List<MarketOrderAggregate> aggregates, String itemId, String createUserId);

}
