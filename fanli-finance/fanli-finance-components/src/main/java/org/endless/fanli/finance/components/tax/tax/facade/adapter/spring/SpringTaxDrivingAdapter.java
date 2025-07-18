package org.endless.fanli.finance.components.tax.tax.facade.adapter.spring;

import org.endless.fanli.finance.components.tax.tax.facade.adapter.*;
import org.endless.fanli.finance.components.tax.tax.application.command.handler.*;
import org.endless.fanli.finance.components.tax.tax.application.query.handler.*;
import org.endless.ddd.simplified.starter.common.exception.model.facade.adapter.*;

/**
 * SpringTaxDrivingAdapter
 * <p>税务领域主动适配器Spring实现类
 * <p>
 * create 2025/07/19 04:31
 * <p>
 * update 2025/07/19 04:31
 *
 * @author Deng Haozhi
 * @see TaxDrivingAdapter
 * @since 0.0.1
 */
public class SpringTaxDrivingAdapter implements TaxDrivingAdapter {

    /**
     * 税务领域命令处理器
     */
    private final TaxCommandHandler taxCommandHandler;

    /**
     * 税务领域查询处理器
     */
    private final TaxQueryHandler taxQueryHandler;

    public SpringTaxDrivingAdapter(TaxCommandHandler taxCommandHandler, TaxQueryHandler taxQueryHandler) {
        this.taxCommandHandler = taxCommandHandler;
        this.taxQueryHandler = taxQueryHandler;
    }
}
