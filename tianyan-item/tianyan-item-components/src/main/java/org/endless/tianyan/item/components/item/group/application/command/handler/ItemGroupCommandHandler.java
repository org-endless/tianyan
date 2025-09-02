package org.endless.tianyan.item.components.item.group.application.command.handler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.item.common.model.application.command.handler.TianyanItemCommandHandler;
import org.endless.tianyan.item.components.item.group.application.command.transfer.ItemGroupCreateCReqTransfer;
import org.endless.tianyan.item.components.item.group.application.command.transfer.ItemGroupCreateCRespTransfer;
import org.endless.tianyan.item.components.item.group.domain.entity.ItemGroupAggregate;

/**
 * ItemGroupCommandHandler
 * <p>资源项分组领域命令处理器
 * <p>
 * itemCreate 2025/07/21 16:04
 * <p>
 * update 2025/07/21 16:04
 *
 * @author Deng Haozhi
 * @see TianyanItemCommandHandler<ItemGroupAggregate>
 * @since 0.0.1
 */
public interface ItemGroupCommandHandler extends TianyanItemCommandHandler<ItemGroupAggregate> {

    /**
     * 资源项分组创建命令
     *
     * @param command 资源项分组创建命令请求传输对象
     * @return {@link ItemGroupCreateCRespTransfer }
     */
    @Valid
    @NotNull(message = "资源项分组创建命令响应传输对象不能为空")
    ItemGroupCreateCRespTransfer create(
            @NotNull(message = "资源项分组创建命令请求传输对象不能为空")
            @Valid ItemGroupCreateCReqTransfer command);

}
