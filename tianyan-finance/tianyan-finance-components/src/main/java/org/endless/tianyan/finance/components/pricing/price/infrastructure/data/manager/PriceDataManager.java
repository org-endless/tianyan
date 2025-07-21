package org.endless.tianyan.finance.components.pricing.price.infrastructure.data.manager;

import org.endless.tianyan.finance.common.model.infrastructure.data.manager.*;
import org.endless.tianyan.finance.components.pricing.price.application.query.anticorruption.*;
import org.endless.tianyan.finance.components.pricing.price.domain.anticorruption.*;
import org.endless.tianyan.finance.components.pricing.price.domain.entity.*;
import org.endless.tianyan.finance.components.pricing.price.infrastructure.data.persistence.mapper.*;
import org.endless.tianyan.finance.components.pricing.price.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.manager.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * PriceDataManager
 * <p>价格聚合数据管理器
 * <p>
 * create 2025/07/19 08:27
 * <p>
 * update 2025/07/19 08:27
 *
 * @author Deng Haozhi
 * @see PriceRepository
 * @see PriceQueryRepository
 * @see TianyanFinanceAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class PriceDataManager implements PriceRepository, PriceQueryRepository, TianyanFinanceAggregateDataManager<PriceRecord, PriceAggregate> {

    /**
     * 价格聚合 Mybatis-Plus 数据访问对象
     */
    private final PriceMapper priceMapper;

    public PriceDataManager(PriceMapper priceMapper) {
        this.priceMapper = priceMapper;
    }

    @Override
    public PriceAggregate save(PriceAggregate priceAggregate) {
        return null;
    }

    @Override
    public void remove(PriceAggregate priceAggregate) {

    }

    @Override
    public PriceAggregate modify(PriceAggregate priceAggregate) {
        return null;
    }

    @Override
    public Optional<PriceAggregate> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<PriceAggregate> findByIdForUpdate(String s) {
        return Optional.empty();
    }
}
