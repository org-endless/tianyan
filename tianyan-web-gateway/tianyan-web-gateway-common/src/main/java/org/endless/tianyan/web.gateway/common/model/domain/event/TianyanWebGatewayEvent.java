package org.endless.tianyan.web.gateway.common.model.domain.event;

import org.endless.ddd.starter.common.ddd.domain.event.Event;
import org.endless.tianyan.web.gateway.common.model.domain.entity.TianyanWebGatewayAggregate;

/**
 * TianyanWebGatewayEvent
 * <p>
 * create 2024/09/06 15:14
 * <p>
 * update 2024/09/06 15:15
 *
 * @author Deng Haozhi
 * @see Event
 * @since 0.0.1
 */
public interface TianyanWebGatewayEvent<A extends TianyanWebGatewayAggregate>
        extends Event<A> {

}
