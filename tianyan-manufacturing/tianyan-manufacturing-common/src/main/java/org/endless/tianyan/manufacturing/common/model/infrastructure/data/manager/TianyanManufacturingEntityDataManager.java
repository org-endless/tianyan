package org.endless.tianyan.manufacturing.common.model.infrastructure.data.manager;

import org.endless.ddd.starter.common.ddd.infrastructure.data.manager.EntityDataManager;
import org.endless.tianyan.manufacturing.common.model.application.query.anticorruption.TianyanManufacturingQueryRepository;
import org.endless.tianyan.manufacturing.common.model.domain.entity.TianyanManufacturingEntity;
import org.endless.tianyan.manufacturing.common.model.infrastructure.data.record.TianyanManufacturingRecord;

/**
 * TianyanManufacturingEntityDataManager
 * <p>
 * create 2024/09/03 12:25
 * <p>
 * update 2024/11/03 19:03
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingQueryRepository
 * @see EntityDataManager
 * @since 0.0.1
 */
public interface TianyanManufacturingEntityDataManager<R extends TianyanManufacturingRecord<E>, E extends TianyanManufacturingEntity>
        extends TianyanManufacturingQueryRepository<E>, EntityDataManager<R, E> {

}
