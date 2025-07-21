package org.endless.tianyan.finance.components.pricing.price.facade.adapter.spring;

import org.endless.tianyan.finance.components.pricing.price.facade.adapter.*;
import org.endless.tianyan.finance.components.pricing.price.application.command.handler.*;
import org.endless.tianyan.finance.components.pricing.price.application.query.handler.*;
import org.endless.ddd.simplified.starter.common.exception.model.facade.adapter.*;

/**
 * SpringPriceDrivingAdapter
 * <p>价格领域主动适配器Spring实现类
 * <p>
 * create 2025/07/19 08:27
 * <p>
 * update 2025/07/19 08:27
 *
 * @author Deng Haozhi
 * @see PriceDrivingAdapter
 * @since 0.0.1
 */
public class SpringPriceDrivingAdapter implements PriceDrivingAdapter {

    /**
     * 价格领域命令处理器
     */
    private final PriceCommandHandler priceCommandHandler;

    /**
     * 价格领域查询处理器
     */
    private final PriceQueryHandler priceQueryHandler;

    public SpringPriceDrivingAdapter(PriceCommandHandler priceCommandHandler, PriceQueryHandler priceQueryHandler) {
        this.priceCommandHandler = priceCommandHandler;
        this.priceQueryHandler = priceQueryHandler;
    }
}
