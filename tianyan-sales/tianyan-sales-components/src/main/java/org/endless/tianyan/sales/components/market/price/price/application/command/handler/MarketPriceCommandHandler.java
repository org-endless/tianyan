package org.endless.tianyan.sales.components.market.price.price.application.command.handler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.sales.common.model.application.command.handler.TianyanSalesCommandHandler;
import org.endless.tianyan.sales.components.market.price.price.application.command.transfer.MarketPriceCreateCReqTransfer;
import org.endless.tianyan.sales.components.market.price.price.domain.entity.MarketPriceAggregate;

/**
 * MarketPriceCommandHandler
 * <p>市场价格领域命令处理器
 * <p>
 * create 2025/07/26 18:56
 * <p>
 * update 2025/07/26 18:56
 *
 * @author Deng Haozhi
 * @see TianyanSalesCommandHandler<MarketPriceAggregate>
 * @since 0.0.1
 */
public interface MarketPriceCommandHandler extends TianyanSalesCommandHandler<MarketPriceAggregate> {

    /**
     * 市场价格创建命令
     *
     * @param command 市场价格创建命令请求传输对象
     */
    void create(
            @NotNull(message = "市场价格创建命令请求传输对象不能为空")
            @Valid MarketPriceCreateCReqTransfer command);

}
