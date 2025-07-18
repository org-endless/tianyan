package org.endless.tianyan.item.common.model.infrastructure.data.manager;

import org.endless.ddd.simplified.starter.common.model.infrastructure.data.manager.EntityDataManager;
import org.endless.tianyan.item.common.model.application.query.anticorruption.TianyanItemQueryRepository;
import org.endless.tianyan.item.common.model.domain.entity.TianyanItemEntity;
import org.endless.tianyan.item.common.model.infrastructure.data.record.TianyanItemRecord;

/**
 * TianyanItemEntityDataManager
 * <p>
 * create 2024/09/03 12:25
 * <p>
 * update 2024/11/03 19:03
 *
 * @author Deng Haozhi
 * @see TianyanItemQueryRepository
 * @see EntityDataManager
 * @since 0.0.1
 */
public interface TianyanItemEntityDataManager<R extends TianyanItemRecord<E>, E extends TianyanItemEntity>
        extends TianyanItemQueryRepository<E>, EntityDataManager<R, E> {

}
