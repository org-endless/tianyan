package org.endless.tianyan.finance.components.profit.estimate.infrastructure.data.manager;

import org.endless.tianyan.finance.common.model.infrastructure.data.manager.TianyanFinanceEntityDataManager;
import org.endless.tianyan.finance.components.profit.estimate.application.query.anticorruption.ProfitMetricQueryRepository;
import org.endless.tianyan.finance.components.profit.estimate.domain.entity.ProfitMetricEntity;
import org.endless.tianyan.finance.components.profit.estimate.infrastructure.data.persistence.mapper.ProfitMetricMapper;
import org.endless.tianyan.finance.components.profit.estimate.infrastructure.data.record.ProfitMetricRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * ProfitMetricDataManager
 * <p>利润指标实体数据管理器
 * <p>
 * create 2025/07/28 19:36
 * <p>
 * update 2025/07/28 19:36
 *
 * @author Deng Haozhi
 * @see ProfitMetricQueryRepository
 * @see TianyanFinanceEntityDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class ProfitMetricDataManager implements ProfitMetricQueryRepository, TianyanFinanceEntityDataManager<ProfitMetricRecord, ProfitMetricEntity> {

    /**
     * 利润指标实体 Mybatis-Plus 数据访问对象
     */
    private final ProfitMetricMapper profitMetricMapper;

    public ProfitMetricDataManager(ProfitMetricMapper profitMetricMapper) {
        this.profitMetricMapper = profitMetricMapper;
    }
}
