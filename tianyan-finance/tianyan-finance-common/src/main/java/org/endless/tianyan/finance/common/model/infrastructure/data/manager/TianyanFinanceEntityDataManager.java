package org.endless.tianyan.finance.common.model.infrastructure.data.manager;

import org.endless.ddd.starter.common.ddd.infrastructure.data.manager.EntityDataManager;
import org.endless.tianyan.finance.common.model.application.query.anticorruption.TianyanFinanceQueryRepository;
import org.endless.tianyan.finance.common.model.domain.entity.TianyanFinanceEntity;
import org.endless.tianyan.finance.common.model.infrastructure.data.record.TianyanFinanceRecord;

/**
 * TianyanFinanceEntityDataManager
 * <p>
 * create 2024/09/03 12:25
 * <p>
 * update 2024/11/03 19:03
 *
 * @author Deng Haozhi
 * @see TianyanFinanceQueryRepository
 * @see EntityDataManager
 * @since 0.0.1
 */
public interface TianyanFinanceEntityDataManager<R extends TianyanFinanceRecord<E>, E extends TianyanFinanceEntity>
        extends TianyanFinanceQueryRepository<E>, EntityDataManager<R, E> {

}
