package org.endless.tianyan.web.gateway.common.model.infrastructure.data.manager;

import org.endless.ddd.simplified.starter.common.model.infrastructure.data.manager.EntityDataManager;
import org.endless.tianyan.web.gateway.common.model.application.query.anticorruption.TianyanWebGatewayQueryRepository;
import org.endless.tianyan.web.gateway.common.model.domain.entity.TianyanWebGatewayEntity;
import org.endless.tianyan.web.gateway.common.model.infrastructure.data.record.TianyanWebGatewayRecord;

/**
 * TianyanWebGatewayEntityDataManager
 * <p>
 * create 2024/09/03 12:25
 * <p>
 * update 2024/11/03 19:03
 *
 * @author Deng Haozhi
 * @see TianyanWebGatewayQueryRepository
 * @see EntityDataManager
 * @since 0.0.1
 */
public interface TianyanWebGatewayEntityDataManager<R extends TianyanWebGatewayRecord<E>, E extends TianyanWebGatewayEntity>
        extends TianyanWebGatewayQueryRepository<E>, EntityDataManager<R, E> {

}
