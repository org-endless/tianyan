package org.endless.tianyan.sales.common.model.infrastructure.data.manager;

import org.endless.ddd.starter.common.ddd.infrastructure.data.manager.EntityDataManager;
import org.endless.tianyan.sales.common.model.application.query.anticorruption.TianyanSalesQueryRepository;
import org.endless.tianyan.sales.common.model.domain.entity.TianyanSalesEntity;
import org.endless.tianyan.sales.common.model.infrastructure.data.record.TianyanSalesRecord;

/**
 * TianyanSalesEntityDataManager
 * <p>
 * create 2024/09/03 12:25
 * <p>
 * update 2024/11/03 19:03
 *
 * @author Deng Haozhi
 * @see TianyanSalesQueryRepository
 * @see EntityDataManager
 * @since 0.0.1
 */
public interface TianyanSalesEntityDataManager<R extends TianyanSalesRecord<E>, E extends TianyanSalesEntity>
        extends TianyanSalesQueryRepository<E>, EntityDataManager<R, E> {

}
