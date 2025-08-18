package org.endless.tianyan.item.common.model.domain.event;

import org.endless.ddd.starter.common.ddd.domain.event.Event;
import org.endless.tianyan.item.common.model.domain.entity.TianyanItemAggregate;

/**
 * TianyanItemEvent
 * <p>
 * create 2024/09/06 15:14
 * <p>
 * update 2024/09/06 15:15
 *
 * @author Deng Haozhi
 * @see Event
 * @since 0.0.1
 */
public interface TianyanItemEvent<A extends TianyanItemAggregate>
        extends Event<A> {

}
