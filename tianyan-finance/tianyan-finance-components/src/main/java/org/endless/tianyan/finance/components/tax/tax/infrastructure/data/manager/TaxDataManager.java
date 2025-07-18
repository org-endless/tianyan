package org.endless.tianyan.finance.components.tax.tax.infrastructure.data.manager;

import org.endless.tianyan.finance.common.model.infrastructure.data.manager.*;
import org.endless.tianyan.finance.components.tax.tax.application.query.anticorruption.*;
import org.endless.tianyan.finance.components.tax.tax.domain.anticorruption.*;
import org.endless.tianyan.finance.components.tax.tax.domain.entity.*;
import org.endless.tianyan.finance.components.tax.tax.infrastructure.data.persistence.mapper.*;
import org.endless.tianyan.finance.components.tax.tax.infrastructure.data.record.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * TaxDataManager
 * <p>税务聚合数据管理器
 * <p>
 * create 2025/07/19 05:08
 * <p>
 * update 2025/07/19 05:08
 *
 * @author Deng Haozhi
 * @see TaxRepository
 * @see TaxQueryRepository
 * @see TianyanFinanceAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class TaxDataManager implements TaxRepository, TaxQueryRepository, TianyanFinanceAggregateDataManager<TaxRecord, TaxAggregate> {

    /**
     * 税务聚合 Mybatis-Plus 数据访问对象
     */
    private final TaxMapper taxMapper;

    public TaxDataManager(TaxMapper taxMapper) {
        this.taxMapper = taxMapper;
    }

    @Override
    public TaxAggregate save(TaxAggregate taxAggregate) {
        return null;
    }

    @Override
    public void remove(TaxAggregate taxAggregate) {

    }

    @Override
    public TaxAggregate modify(TaxAggregate taxAggregate) {
        return null;
    }

    @Override
    public Optional<TaxAggregate> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<TaxAggregate> findByIdForUpdate(String s) {
        return Optional.empty();
    }
}
