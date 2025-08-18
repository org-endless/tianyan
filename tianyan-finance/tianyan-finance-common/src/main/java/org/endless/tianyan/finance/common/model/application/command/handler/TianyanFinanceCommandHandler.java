package org.endless.tianyan.finance.common.model.application.command.handler;

import org.endless.ddd.starter.common.ddd.application.command.handler.CommandHandler;
import org.endless.tianyan.finance.common.model.domain.entity.TianyanFinanceAggregate;

/**
 * TianyanFinanceCommandHandler
 * <p>
 * create 2024/08/30 17:19
 * <p>
 * update 2024/08/30 17:20
 *
 * @author Deng Haozhi
 * @see CommandHandler
 * @since 0.0.1
 */
public interface TianyanFinanceCommandHandler<A extends TianyanFinanceAggregate>
        extends CommandHandler<A> {

}
