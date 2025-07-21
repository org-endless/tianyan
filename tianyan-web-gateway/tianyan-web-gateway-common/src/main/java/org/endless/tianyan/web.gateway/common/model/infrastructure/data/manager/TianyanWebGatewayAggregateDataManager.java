package org.endless.tianyan.web.gateway.common.model.infrastructure.data.manager;

import org.endless.ddd.simplified.starter.common.model.infrastructure.data.manager.AggregateDataManager;
import org.endless.tianyan.web.gateway.common.model.application.query.anticorruption.TianyanWebGatewayQueryRepository;
import org.endless.tianyan.web.gateway.common.model.domain.anticorruption.TianyanWebGatewayRepository;
import org.endless.tianyan.web.gateway.common.model.domain.entity.TianyanWebGatewayAggregate;
import org.endless.tianyan.web.gateway.common.model.infrastructure.data.record.TianyanWebGatewayRecord;

/**
 * TianyanWebGatewayAggregateDataManager
 * <p>
 * create 2024/09/03 12:25
 * <p>
 * update 2024/09/12 13:19
 * update 2024/11/03 19:03
 *
 * @author Deng Haozhi
 * @see TianyanWebGatewayRepository
 * @see TianyanWebGatewayQueryRepository
 * @see AggregateDataManager
 * @since 0.0.1
 */
public interface TianyanWebGatewayAggregateDataManager<R extends TianyanWebGatewayRecord<A>, A extends TianyanWebGatewayAggregate>
        extends TianyanWebGatewayRepository<A>, TianyanWebGatewayQueryRepository<A>, AggregateDataManager<R, A> {

}
