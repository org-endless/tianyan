package org.endless.tianyan.manufacturing.common.model.infrastructure.data.manager;

import org.endless.ddd.simplified.starter.common.model.infrastructure.data.manager.AggregateDataManager;
import org.endless.tianyan.manufacturing.common.model.application.query.anticorruption.TianyanManufacturingQueryRepository;
import org.endless.tianyan.manufacturing.common.model.domain.anticorruption.TianyanManufacturingRepository;
import org.endless.tianyan.manufacturing.common.model.domain.entity.TianyanManufacturingAggregate;
import org.endless.tianyan.manufacturing.common.model.infrastructure.data.record.TianyanManufacturingRecord;

/**
 * TianyanManufacturingAggregateDataManager
 * <p>
 * create 2024/09/03 12:25
 * <p>
 * update 2024/09/12 13:19
 * update 2024/11/03 19:03
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingRepository
 * @see TianyanManufacturingQueryRepository
 * @see AggregateDataManager
 * @since 0.0.1
 */
public interface TianyanManufacturingAggregateDataManager<R extends TianyanManufacturingRecord<A>, A extends TianyanManufacturingAggregate>
        extends TianyanManufacturingRepository<A>, TianyanManufacturingQueryRepository<A>, AggregateDataManager<R, A> {

}
