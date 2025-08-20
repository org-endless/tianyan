package org.endless.tianyan.item.components.item.item.application.command.handler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.item.common.model.application.command.handler.TianyanItemCommandHandler;
import org.endless.tianyan.item.components.item.item.application.command.transfer.ItemCreateCReqTransfer;
import org.endless.tianyan.item.components.item.item.application.command.transfer.ItemCreateCRespTransfer;
import org.endless.tianyan.item.components.item.item.domain.entity.ItemAggregate;

/**
 * ItemCommandHandler
 * <p>资源项领域命令处理器
 * <p>
 * itemCreate 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see TianyanItemCommandHandler<ItemAggregate>
 * @since 0.0.1
 */
public interface ItemCommandHandler extends TianyanItemCommandHandler<ItemAggregate> {

    /**
     * 资源项创建命令
     *
     * @param command 资源项创建命令请求传输对象
     * @return {@link ItemCreateCRespTransfer }
     */
    @Valid
    @NotNull(message = "资源项创建命令响应传输对象不能为空")
    ItemCreateCRespTransfer create(
            @NotNull(message = "资源项创建命令请求传输对象不能为空")
            @Valid ItemCreateCReqTransfer command);
}
