package org.endless.tianyan.finance.components.cost.rule.infrastructure.data.manager;

import org.endless.tianyan.finance.common.model.infrastructure.data.manager.TianyanFinanceAggregateDataManager;
import org.endless.tianyan.finance.components.cost.rule.application.query.anticorruption.CostRuleQueryRepository;
import org.endless.tianyan.finance.components.cost.rule.domain.anticorruption.CostRuleRepository;
import org.endless.tianyan.finance.components.cost.rule.domain.entity.CostRuleAggregate;
import org.endless.tianyan.finance.components.cost.rule.infrastructure.data.persistence.mapper.CostRuleMapper;
import org.endless.tianyan.finance.components.cost.rule.infrastructure.data.record.CostRuleRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * CostRuleDataManager
 * <p>成本规则聚合根数据管理器
 * <p>
 * create 2025/07/28 20:10
 * <p>
 * update 2025/07/28 20:10
 *
 * @author Deng Haozhi
 * @see CostRuleRepository
 * @see CostRuleQueryRepository
 * @see TianyanFinanceAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class CostRuleDataManager implements CostRuleRepository, CostRuleQueryRepository, TianyanFinanceAggregateDataManager<CostRuleRecord, CostRuleAggregate> {

    /**
     * 成本规则聚合 Mybatis-Plus 数据访问对象
     */
    private final CostRuleMapper costRuleMapper;

    public CostRuleDataManager(CostRuleMapper costRuleMapper) {
        this.costRuleMapper = costRuleMapper;
    }

    @Override
    public CostRuleAggregate save(CostRuleAggregate aggregate) {
        return null;
    }

    @Override
    public void remove(CostRuleAggregate aggregate) {

    }

    @Override
    public CostRuleAggregate modify(CostRuleAggregate aggregate) {
        return null;
    }

    @Override
    public Optional<CostRuleAggregate> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<CostRuleAggregate> findByIdForUpdate(String id) {
        return Optional.empty();
    }
}
