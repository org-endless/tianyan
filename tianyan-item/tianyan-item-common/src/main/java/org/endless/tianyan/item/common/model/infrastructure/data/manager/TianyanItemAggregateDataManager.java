package org.endless.tianyan.item.common.model.infrastructure.data.manager;

import org.endless.ddd.simplified.starter.common.model.infrastructure.data.manager.AggregateDataManager;
import org.endless.tianyan.item.common.model.application.query.anticorruption.TianyanItemQueryRepository;
import org.endless.tianyan.item.common.model.domain.anticorruption.TianyanItemRepository;
import org.endless.tianyan.item.common.model.domain.entity.TianyanItemAggregate;
import org.endless.tianyan.item.common.model.infrastructure.data.record.TianyanItemRecord;

/**
 * TianyanItemAggregateDataManager
 * <p>
 * create 2024/09/03 12:25
 * <p>
 * update 2024/09/12 13:19
 * update 2024/11/03 19:03
 *
 * @author Deng Haozhi
 * @see TianyanItemRepository
 * @see TianyanItemQueryRepository
 * @see AggregateDataManager
 * @since 0.0.1
 */
public interface TianyanItemAggregateDataManager<R extends TianyanItemRecord<A>, A extends TianyanItemAggregate>
        extends TianyanItemRepository<A>, TianyanItemQueryRepository<A>, AggregateDataManager<R, A> {

}
