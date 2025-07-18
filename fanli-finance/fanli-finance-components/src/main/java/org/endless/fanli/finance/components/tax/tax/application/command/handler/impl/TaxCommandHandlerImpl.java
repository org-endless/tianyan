package org.endless.fanli.finance.components.tax.tax.application.command.handler.impl;

import org.endless.fanli.finance.components.tax.tax.application.command.handler.*;
import org.endless.fanli.finance.components.tax.tax.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.handler.*;

/**
 * TaxCommandHandlerImpl
 * <p>税务领域命令处理器
 * <p>
 * create 2025/07/19 04:31
 * <p>
 * update 2025/07/19 04:31
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
