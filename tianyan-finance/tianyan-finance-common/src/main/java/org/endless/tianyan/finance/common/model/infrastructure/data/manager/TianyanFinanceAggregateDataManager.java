package org.endless.tianyan.finance.common.model.infrastructure.data.manager;

import org.endless.ddd.simplified.starter.common.model.infrastructure.data.manager.AggregateDataManager;
import org.endless.tianyan.finance.common.model.application.query.anticorruption.TianyanFinanceQueryRepository;
import org.endless.tianyan.finance.common.model.domain.anticorruption.TianyanFinanceRepository;
import org.endless.tianyan.finance.common.model.domain.entity.TianyanFinanceAggregate;
import org.endless.tianyan.finance.common.model.infrastructure.data.record.TianyanFinanceRecord;

/**
 * TianyanFinanceAggregateDataManager
 * <p>
 * create 2024/09/03 12:25
 * <p>
 * update 2024/09/12 13:19
 * update 2024/11/03 19:03
 *
 * @author Deng Haozhi
 * @see TianyanFinanceRepository
 * @see TianyanFinanceQueryRepository
 * @see AggregateDataManager
 * @since 0.0.1
 */
public interface TianyanFinanceAggregateDataManager<R extends TianyanFinanceRecord<A>, A extends TianyanFinanceAggregate>
        extends TianyanFinanceRepository<A>, TianyanFinanceQueryRepository<A>, AggregateDataManager<R, A> {

}
