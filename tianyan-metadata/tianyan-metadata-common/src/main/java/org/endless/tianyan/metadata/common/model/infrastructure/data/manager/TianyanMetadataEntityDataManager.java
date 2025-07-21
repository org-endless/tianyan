package org.endless.tianyan.metadata.common.model.infrastructure.data.manager;

import org.endless.ddd.simplified.starter.common.model.infrastructure.data.manager.EntityDataManager;
import org.endless.tianyan.metadata.common.model.application.query.anticorruption.TianyanMetadataQueryRepository;
import org.endless.tianyan.metadata.common.model.domain.entity.TianyanMetadataEntity;
import org.endless.tianyan.metadata.common.model.infrastructure.data.record.TianyanMetadataRecord;

/**
 * TianyanMetadataEntityDataManager
 * <p>
 * create 2024/09/03 12:25
 * <p>
 * update 2024/11/03 19:03
 *
 * @author Deng Haozhi
 * @see TianyanMetadataQueryRepository
 * @see EntityDataManager
 * @since 0.0.1
 */
public interface TianyanMetadataEntityDataManager<R extends TianyanMetadataRecord<E>, E extends TianyanMetadataEntity>
        extends TianyanMetadataQueryRepository<E>, EntityDataManager<R, E> {

}
