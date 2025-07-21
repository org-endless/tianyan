package org.endless.tianyan.metadata.common.model.infrastructure.data.manager;

import org.endless.ddd.simplified.starter.common.model.infrastructure.data.manager.AggregateDataManager;
import org.endless.tianyan.metadata.common.model.application.query.anticorruption.TianyanMetadataQueryRepository;
import org.endless.tianyan.metadata.common.model.domain.anticorruption.TianyanMetadataRepository;
import org.endless.tianyan.metadata.common.model.domain.entity.TianyanMetadataAggregate;
import org.endless.tianyan.metadata.common.model.infrastructure.data.record.TianyanMetadataRecord;

/**
 * TianyanMetadataAggregateDataManager
 * <p>
 * create 2024/09/03 12:25
 * <p>
 * update 2024/09/12 13:19
 * update 2024/11/03 19:03
 *
 * @author Deng Haozhi
 * @see TianyanMetadataRepository
 * @see TianyanMetadataQueryRepository
 * @see AggregateDataManager
 * @since 0.0.1
 */
public interface TianyanMetadataAggregateDataManager<R extends TianyanMetadataRecord<A>, A extends TianyanMetadataAggregate>
        extends TianyanMetadataRepository<A>, TianyanMetadataQueryRepository<A>, AggregateDataManager<R, A> {

}
