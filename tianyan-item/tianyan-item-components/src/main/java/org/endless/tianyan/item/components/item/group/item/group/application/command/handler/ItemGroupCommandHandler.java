package org.endless.tianyan.item.components.item.group.item.group.application.command.handler;

import org.endless.tianyan.item.common.model.application.command.handler.TianyanItemCommandHandler;
import org.endless.tianyan.item.components.item.group.item.group.application.command.transfer.ItemGroupCreateReqCReqTransfer;
import org.endless.tianyan.item.components.item.group.item.group.application.command.transfer.ItemGroupCreateRespCReqTransfer;
import org.endless.tianyan.item.components.item.group.item.group.domain.entity.ItemGroupAggregate;

/**
 * ItemGroupCommandHandler
 * <p>资源项分组领域命令处理器
 * <p>
 * create 2025/07/21 16:04
 * <p>
 * update 2025/07/21 16:04
 *
 * @author Deng Haozhi
 * @see TianyanItemCommandHandler<ItemGroupAggregate>
 * @since 0.0.1
 */
public interface ItemGroupCommandHandler extends TianyanItemCommandHandler<ItemGroupAggregate> {

    ItemGroupCreateRespCReqTransfer create(ItemGroupCreateReqCReqTransfer command);

}
