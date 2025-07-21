package org.endless.tianyan.web.gateway.common.model.infrastructure.data.persistence.mapper;

import org.endless.ddd.simplified.starter.common.model.infrastructure.data.persistence.mapper.DataMapper;
import org.endless.tianyan.web.gateway.common.model.domain.entity.TianyanWebGatewayEntity;
import org.endless.tianyan.web.gateway.common.model.infrastructure.data.record.TianyanWebGatewayRecord;

/**
 * TianyanWebGatewayMapper
 * <p>
 * create 2024/09/03 09:35
 * <p>
 * update 2024/09/03 12:09
 *
 * @see DataMapper
 * @since 0.0.1
 */
public interface TianyanWebGatewayMapper<R extends TianyanWebGatewayRecord<? extends TianyanWebGatewayEntity>>
        extends DataMapper<R> {

}
