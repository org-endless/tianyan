package org.endless.tianyan.sales.common.model.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.ddd.infrastructure.data.persistence.mapper.DataMapper;
import org.endless.tianyan.sales.common.model.domain.entity.TianyanSalesEntity;
import org.endless.tianyan.sales.common.model.infrastructure.data.record.TianyanSalesRecord;

/**
 * TianyanSalesMapper
 * <p>
 * create 2024/09/03 09:35
 * <p>
 * update 2024/09/03 12:09
 *
 * @see DataMapper
 * @since 0.0.1
 */
public interface TianyanSalesMapper<R extends TianyanSalesRecord<? extends TianyanSalesEntity>>
        extends DataMapper<R> {

}
