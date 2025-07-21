package org.endless.tianyan.finance.components.pricing.price.application.query.handler.impl;

import org.endless.tianyan.finance.components.pricing.price.application.query.handler.*;
import org.endless.tianyan.finance.components.pricing.price.application.query.anticorruption.*;
import org.endless.tianyan.finance.components.pricing.price.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.handler.*;

/**
 * PriceQueryHandlerImpl
 * <p>价格领域查询处理器
 * <p>
 * create 2025/07/19 08:27
 * <p>
 * update 2025/07/19 08:27
 *
 * @author Deng Haozhi
 * @see PriceQueryHandler
 * @since 0.0.1
 */
public class PriceQueryHandlerImpl implements PriceQueryHandler {

    /**
     * 价格聚合查询仓储接口
     */
    private final PriceQueryRepository priceQueryRepository;

    public PriceQueryHandlerImpl(PriceQueryRepository priceQueryRepository) {
        this.priceQueryRepository = priceQueryRepository;
    }
}
