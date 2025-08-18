package org.endless.tianyan.item.common.model.infrastructure.data.persistence.mapper;

import org.endless.ddd.starter.common.ddd.infrastructure.data.persistence.mapper.DataMapper;
import org.endless.tianyan.item.common.model.domain.entity.TianyanItemEntity;
import org.endless.tianyan.item.common.model.infrastructure.data.record.TianyanItemRecord;

/**
 * TianyanItemMapper
 * <p>
 * create 2024/09/03 09:35
 * <p>
 * update 2024/09/03 12:09
 *
 * @see DataMapper
 * @since 0.0.1
 */
public interface TianyanItemMapper<R extends TianyanItemRecord<? extends TianyanItemEntity>>
        extends DataMapper<R> {

}
