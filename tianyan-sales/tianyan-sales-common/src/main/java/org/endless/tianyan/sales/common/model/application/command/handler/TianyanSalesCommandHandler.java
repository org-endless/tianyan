package org.endless.tianyan.sales.common.model.application.command.handler;

import org.endless.ddd.simplified.starter.common.model.application.command.handler.CommandHandler;
import org.endless.tianyan.sales.common.model.domain.entity.TianyanSalesAggregate;

/**
 * TianyanSalesCommandHandler
 * <p>
 * create 2024/08/30 17:19
 * <p>
 * update 2024/08/30 17:20
 *
 * @author Deng Haozhi
 * @see CommandHandler
 * @since 0.0.1
 */
public interface TianyanSalesCommandHandler<A extends TianyanSalesAggregate> extends CommandHandler<A> {

}
