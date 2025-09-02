package org.endless.tianyan.sales.components.market.order.domain.anticorruption;

import jakarta.validation.constraints.NotBlank;
import org.endless.tianyan.sales.common.model.domain.anticorruption.TianyanSalesDrivenAdapter;
import org.endless.tianyan.sales.components.market.order.domain.entity.MarketOrderAggregate;

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

    void generatePrice(
            List<MarketOrderAggregate> aggregates,
            @NotBlank(message = "资源项ID不能为空") String itemId,
            @NotBlank(message = "创建用户ID不能为空") String createUserId);

}
