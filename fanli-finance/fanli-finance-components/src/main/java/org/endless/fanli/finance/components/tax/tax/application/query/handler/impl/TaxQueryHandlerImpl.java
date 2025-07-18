package org.endless.fanli.finance.components.tax.tax.application.query.handler.impl;

import org.endless.fanli.finance.components.tax.tax.application.query.handler.*;
import org.endless.fanli.finance.components.tax.tax.application.query.anticorruption.*;
import org.endless.fanli.finance.components.tax.tax.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.handler.*;

/**
 * TaxQueryHandlerImpl
 * <p>税务领域查询处理器
 * <p>
 * create 2025/07/19 04:31
 * <p>
 * update 2025/07/19 04:31
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
