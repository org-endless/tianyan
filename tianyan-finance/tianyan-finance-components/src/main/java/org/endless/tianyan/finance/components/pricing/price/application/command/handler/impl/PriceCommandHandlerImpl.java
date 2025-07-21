package org.endless.tianyan.finance.components.pricing.price.application.command.handler.impl;

import org.endless.tianyan.finance.components.pricing.price.application.command.handler.*;
import org.endless.tianyan.finance.components.pricing.price.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.handler.*;

/**
 * PriceCommandHandlerImpl
 * <p>价格领域命令处理器
 * <p>
 * create 2025/07/19 08:27
 * <p>
 * update 2025/07/19 08:27
 *
 * @author Deng Haozhi
 * @see PriceCommandHandler
 * @since 0.0.1
 */
public class PriceCommandHandlerImpl implements PriceCommandHandler {

    /**
     * 价格聚合仓储接口
     */
    private final PriceRepository priceRepository;

    public PriceCommandHandlerImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }
}
