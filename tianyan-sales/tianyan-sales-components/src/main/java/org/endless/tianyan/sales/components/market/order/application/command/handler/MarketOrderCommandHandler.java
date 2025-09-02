package org.endless.tianyan.sales.components.market.order.application.command.handler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.sales.common.model.application.command.handler.TianyanSalesCommandHandler;
import org.endless.tianyan.sales.components.market.order.application.command.transfer.*;
import org.endless.tianyan.sales.components.market.order.domain.entity.MarketOrderAggregate;

/**
 * MarketOrderCommandHandler
 * <p>市场订单领域命令处理器
 * <p>
 * create 2025/07/25 13:11
 * <p>
 * update 2025/07/25 13:11
 *
 * @author Deng Haozhi
 * @see TianyanSalesCommandHandler<MarketOrderAggregate>
 * @since 0.0.1
 */
public interface MarketOrderCommandHandler extends TianyanSalesCommandHandler<MarketOrderAggregate> {


    /**
     * 市场订单创建命令
     *
     * @param command 市场订单创建命令请求传输对象
     * @return {@link MarketOrderCreateCRespTransfer }
     */
    @Valid
    @NotNull(message = "市场订单创建命令响应传输对象不能为空")
    MarketOrderCreateCRespTransfer create(
            @NotNull(message = "市场订单创建命令请求传输对象不能为空")
            @Valid MarketOrderCreateCReqTransfer command);

    /**
     * 市场订单删除命令
     *
     * @param command 市场订单删除命令请求传输对象
     */
    void remove(
            @NotNull(message = "市场订单删除命令请求传输对象不能为空")
            @Valid MarketOrderRemoveCReqTransfer command);

    /**
     * 市场订单修改命令
     *
     * @param command 市场订单修改命令请求传输对象
     */
    void modify(
            @NotNull(message = "市场订单修改命令请求传输对象不能为空")
            @Valid MarketOrderModifyCReqTransfer command);

    /**
     * 市场订单生成价格命令
     *
     * @param command 市场订单生成价格命令请求传输对象
     */
    void generatePrice(
            @NotNull(message = "市场订单生成价格命令请求传输对象不能为空")
            @Valid MarketOrderGeneratePriceCReqTransfer command);

}
