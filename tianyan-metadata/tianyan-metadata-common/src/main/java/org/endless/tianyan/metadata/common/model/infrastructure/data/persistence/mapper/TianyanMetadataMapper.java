package org.endless.tianyan.metadata.common.model.infrastructure.data.persistence.mapper;

import org.endless.ddd.simplified.starter.common.model.infrastructure.data.persistence.mapper.DataMapper;
import org.endless.tianyan.metadata.common.model.domain.entity.TianyanMetadataEntity;
import org.endless.tianyan.metadata.common.model.infrastructure.data.record.TianyanMetadataRecord;

/**
 * TianyanMetadataMapper
 * <p>
 * create 2024/09/03 09:35
 * <p>
 * update 2024/09/03 12:09
 *
 * @see DataMapper
 * @since 0.0.1
 */
public interface TianyanMetadataMapper<R extends TianyanMetadataRecord<? extends TianyanMetadataEntity>>
        extends DataMapper<R> {

}
