package org.endless.tianyan.sales.common.model.domain.event;

import org.endless.ddd.simplified.starter.common.model.domain.event.Event;
import org.endless.tianyan.sales.common.model.domain.entity.TianyanSalesAggregate;

/**
 * TianyanSalesEvent
 * <p>
 * create 2024/09/06 15:14
 * <p>
 * update 2024/09/06 15:15
 *
 * @author Deng Haozhi
 * @see Event
 * @since 0.0.1
 */
public interface TianyanSalesEvent<A extends TianyanSalesAggregate> extends Event<A> {

}
