package org.endless.tianyan.finance.common.model.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.ddd.infrastructure.data.persistence.mapper.DataMapper;
import org.endless.tianyan.finance.common.model.domain.entity.TianyanFinanceEntity;
import org.endless.tianyan.finance.common.model.infrastructure.data.record.TianyanFinanceRecord;

/**
 * TianyanFinanceMapper
 * <p>
 * create 2024/09/03 09:35
 * <p>
 * update 2024/09/03 12:09
 *
 * @see DataMapper
 * @since 0.0.1
 */
public interface TianyanFinanceMapper<R extends TianyanFinanceRecord<? extends TianyanFinanceEntity>>
        extends DataMapper<R> {

}
