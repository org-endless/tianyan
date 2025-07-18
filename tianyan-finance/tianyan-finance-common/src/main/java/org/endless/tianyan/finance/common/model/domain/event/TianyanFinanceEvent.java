package org.endless.tianyan.finance.common.model.domain.event;

import org.endless.ddd.simplified.starter.common.model.domain.event.Event;
import org.endless.tianyan.finance.common.model.domain.entity.TianyanFinanceAggregate;

/**
 * TianyanFinanceEvent
 * <p>
 * create 2024/09/06 15:14
 * <p>
 * update 2024/09/06 15:15
 *
 * @author Deng Haozhi
 * @see Event
 * @since 0.0.1
 */
public interface TianyanFinanceEvent<A extends TianyanFinanceAggregate>
        extends Event<A> {

}
