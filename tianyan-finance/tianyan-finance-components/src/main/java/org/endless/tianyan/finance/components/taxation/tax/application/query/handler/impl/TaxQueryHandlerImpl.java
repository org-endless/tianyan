package org.endless.tianyan.finance.components.taxation.tax.application.query.handler.impl;

import org.endless.tianyan.finance.components.taxation.tax.application.query.anticorruption.TaxQueryRepository;
import org.endless.tianyan.finance.components.taxation.tax.application.query.handler.TaxQueryHandler;

/**
 * TaxQueryHandlerImpl
 * <p>税务领域查询处理器
 * <p>
 * create 2025/07/19 08:27
 * <p>
 * update 2025/07/19 08:27
 *
 * @author Deng Haozhi
 * @see TaxQueryHandler
 * @since 0.0.1
 */
public class TaxQueryHandlerImpl implements TaxQueryHandler {

    /**
     * 税务聚合查询仓储接口
     */
    private final TaxQueryRepository taxQueryRepository;

    public TaxQueryHandlerImpl(TaxQueryRepository taxQueryRepository) {
        this.taxQueryRepository = taxQueryRepository;
    }
}
