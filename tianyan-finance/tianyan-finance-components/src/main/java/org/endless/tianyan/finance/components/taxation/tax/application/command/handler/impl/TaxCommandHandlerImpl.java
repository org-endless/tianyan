package org.endless.tianyan.finance.components.taxation.tax.application.command.handler.impl;

import org.endless.tianyan.finance.components.taxation.tax.application.command.handler.TaxCommandHandler;
import org.endless.tianyan.finance.components.taxation.tax.domain.anticorruption.TaxRepository;

/**
 * TaxCommandHandlerImpl
 * <p>税务领域命令处理器
 * <p>
 * create 2025/07/19 08:27
 * <p>
 * update 2025/07/19 08:27
 *
 * @author Deng Haozhi
 * @see TaxCommandHandler
 * @since 0.0.1
 */
public class TaxCommandHandlerImpl implements TaxCommandHandler {

    /**
     * 税务聚合仓储接口
     */
    private final TaxRepository taxRepository;

    public TaxCommandHandlerImpl(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }
}
