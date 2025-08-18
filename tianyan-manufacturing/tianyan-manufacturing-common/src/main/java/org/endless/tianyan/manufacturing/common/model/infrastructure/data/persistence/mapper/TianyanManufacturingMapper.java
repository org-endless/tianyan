package org.endless.tianyan.manufacturing.common.model.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.ddd.infrastructure.data.persistence.mapper.DataMapper;
import org.endless.tianyan.manufacturing.common.model.domain.entity.TianyanManufacturingEntity;
import org.endless.tianyan.manufacturing.common.model.infrastructure.data.record.TianyanManufacturingRecord;

/**
 * TianyanManufacturingMapper
 * <p>
 * create 2024/09/03 09:35
 * <p>
 * update 2024/09/03 12:09
 *
 * @see DataMapper
 * @since 0.0.1
 */
public interface TianyanManufacturingMapper<R extends TianyanManufacturingRecord<? extends TianyanManufacturingEntity>>
        extends DataMapper<R> {

}
