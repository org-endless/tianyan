package org.endless.tianyan.sales.common.model.infrastructure.data.manager;

import org.endless.ddd.starter.common.ddd.infrastructure.data.manager.AggregateDataManager;
import org.endless.tianyan.sales.common.model.application.query.anticorruption.TianyanSalesQueryRepository;
import org.endless.tianyan.sales.common.model.domain.anticorruption.TianyanSalesRepository;
import org.endless.tianyan.sales.common.model.domain.entity.TianyanSalesAggregate;
import org.endless.tianyan.sales.common.model.infrastructure.data.record.TianyanSalesRecord;

/**
 * TianyanSalesAggregateDataManager
 * <p>
 * create 2024/09/03 12:25
 * <p>
 * update 2024/09/12 13:19
 * update 2024/11/03 19:03
 *
 * @author Deng Haozhi
 * @see TianyanSalesRepository
 * @see TianyanSalesQueryRepository
 * @see AggregateDataManager
 * @since 0.0.1
 */
public interface TianyanSalesAggregateDataManager<R extends TianyanSalesRecord<A>, A extends TianyanSalesAggregate>
        extends TianyanSalesRepository<A>, TianyanSalesQueryRepository<A>, AggregateDataManager<R, A> {

}
