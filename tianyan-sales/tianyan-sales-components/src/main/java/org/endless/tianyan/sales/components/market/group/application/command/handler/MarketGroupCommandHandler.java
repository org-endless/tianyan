package org.endless.tianyan.sales.components.market.group.application.command.handler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.sales.common.model.application.command.handler.TianyanSalesCommandHandler;
import org.endless.tianyan.sales.components.market.group.application.command.transfer.MarketGroupCreateCReqTransfer;
import org.endless.tianyan.sales.components.market.group.application.command.transfer.MarketGroupCreateCRespTransfer;
import org.endless.tianyan.sales.components.market.group.application.command.transfer.MarketGroupModifyParentCReqTransfer;
import org.endless.tianyan.sales.components.market.group.domain.entity.MarketGroupAggregate;

/**
 * MarketGroupCommandHandler
 * <p>市场分组领域命令处理器
 * <p>
 * create 2025/07/24 17:36
 * <p>
 * update 2025/07/24 17:36
 *
 * @author Deng Haozhi
 * @see TianyanSalesCommandHandler<MarketGroupAggregate>
 * @since 0.0.1
 */
public interface MarketGroupCommandHandler extends TianyanSalesCommandHandler<MarketGroupAggregate> {

    /**
     * 市场分组创建命令
     *
     * @param command 市场分组创建命令请求传输对象
     * @return {@link MarketGroupCreateCRespTransfer }
     */
    @Valid
    @NotNull(message = "市场分组创建命令响应传输对象不能为空")
    MarketGroupCreateCRespTransfer create(
            @NotNull(message = "市场分组创建命令请求传输对象不能为空")
            @Valid MarketGroupCreateCReqTransfer command);

    /**
     * 市场分组修改父分组命令
     *
     * @param command 市场分组修改父分组命令请求传输对象
     */
    void modifyParent(
            @NotNull(message = "市场分组修改父分组命令请求传输对象不能为空")
            @Valid MarketGroupModifyParentCReqTransfer command);
}
