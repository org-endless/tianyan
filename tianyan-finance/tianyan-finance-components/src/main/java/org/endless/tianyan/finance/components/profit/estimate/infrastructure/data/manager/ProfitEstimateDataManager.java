package org.endless.tianyan.finance.components.profit.estimate.infrastructure.data.manager;

import org.endless.tianyan.finance.common.model.infrastructure.data.manager.TianyanFinanceAggregateDataManager;
import org.endless.tianyan.finance.components.profit.estimate.application.query.anticorruption.ProfitEstimateQueryRepository;
import org.endless.tianyan.finance.components.profit.estimate.domain.anticorruption.ProfitEstimateRepository;
import org.endless.tianyan.finance.components.profit.estimate.domain.entity.ProfitEstimateAggregate;
import org.endless.tianyan.finance.components.profit.estimate.infrastructure.data.persistence.mapper.ProfitEstimateMapper;
import org.endless.tianyan.finance.components.profit.estimate.infrastructure.data.persistence.mapper.ProfitMetricMapper;
import org.endless.tianyan.finance.components.profit.estimate.infrastructure.data.record.ProfitEstimateRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * ProfitEstimateDataManager
 * <p>预估利润聚合数据管理器
 * <p>
 * create 2025/07/28 19:36
 * <p>
 * update 2025/07/28 19:36
 *
 * @author Deng Haozhi
 * @see ProfitEstimateRepository
 * @see ProfitEstimateQueryRepository
 * @see TianyanFinanceAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class ProfitEstimateDataManager implements ProfitEstimateRepository, ProfitEstimateQueryRepository, TianyanFinanceAggregateDataManager<ProfitEstimateRecord, ProfitEstimateAggregate> {

    /**
     * 预估利润聚合 Mybatis-Plus 数据访问对象
     */
    private final ProfitEstimateMapper profitEstimateMapper;

    /**
     * 利润指标实体 Mybatis-Plus 数据访问对象
     */
    private final ProfitMetricMapper profitMetricMapper;

    public ProfitEstimateDataManager(ProfitEstimateMapper profitEstimateMapper, ProfitMetricMapper profitMetricMapper) {
        this.profitEstimateMapper = profitEstimateMapper;
        this.profitMetricMapper = profitMetricMapper;
    }

    @Override
    public ProfitEstimateAggregate save(ProfitEstimateAggregate aggregate) {
        return null;
    }

    @Override
    public void remove(ProfitEstimateAggregate aggregate) {

    }

    @Override
    public ProfitEstimateAggregate modify(ProfitEstimateAggregate aggregate) {
        return null;
    }

    @Override
    public Optional<ProfitEstimateAggregate> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<ProfitEstimateAggregate> findByIdForUpdate(String id) {
        return Optional.empty();
    }
}
