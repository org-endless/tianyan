package org.endless.tianyan.finance.components.cost.type.infrastructure.data.manager;

import org.endless.tianyan.finance.common.model.infrastructure.data.manager.TianyanFinanceAggregateDataManager;
import org.endless.tianyan.finance.components.cost.type.application.query.anticorruption.CostTypeQueryRepository;
import org.endless.tianyan.finance.components.cost.type.domain.anticorruption.CostTypeRepository;
import org.endless.tianyan.finance.components.cost.type.domain.entity.CostTypeAggregate;
import org.endless.tianyan.finance.components.cost.type.infrastructure.data.persistence.mapper.CostTypeMapper;
import org.endless.tianyan.finance.components.cost.type.infrastructure.data.record.CostTypeRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * CostTypeDataManager
 * <p>成本类型聚合数据管理器
 * <p>
 * create 2025/07/28 20:09
 * <p>
 * update 2025/07/28 20:09
 *
 * @author Deng Haozhi
 * @see CostTypeRepository
 * @see CostTypeQueryRepository
 * @see TianyanFinanceAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class CostTypeDataManager implements CostTypeRepository, CostTypeQueryRepository, TianyanFinanceAggregateDataManager<CostTypeRecord, CostTypeAggregate> {

    /**
     * 成本类型聚合 Mybatis-Plus 数据访问对象
     */
    private final CostTypeMapper costTypeMapper;

    public CostTypeDataManager(CostTypeMapper costTypeMapper) {
        this.costTypeMapper = costTypeMapper;
    }

    @Override
    public CostTypeAggregate save(CostTypeAggregate aggregate) {
        return null;
    }

    @Override
    public void remove(CostTypeAggregate aggregate) {

    }

    @Override
    public CostTypeAggregate modify(CostTypeAggregate aggregate) {
        return null;
    }

    @Override
    public Optional<CostTypeAggregate> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<CostTypeAggregate> findByIdForUpdate(String id) {
        return Optional.empty();
    }
}
