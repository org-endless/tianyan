package org.endless.tianyan.item.components.item.item.application.command.handler;

import org.endless.tianyan.item.common.model.application.command.handler.TianyanItemCommandHandler;
import org.endless.tianyan.item.components.item.item.application.command.transfer.ItemCreateCReqTransfer;
import org.endless.tianyan.item.components.item.item.application.command.transfer.ItemCreateCRespTransfer;
import org.endless.tianyan.item.components.item.item.domain.entity.ItemAggregate;

/**
 * ItemCommandHandler
 * <p>资源项领域命令处理器
 * <p>
 * create 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see TianyanItemCommandHandler<ItemAggregate>
 * @since 0.0.1
 */
public interface ItemCommandHandler extends TianyanItemCommandHandler<ItemAggregate> {

    ItemCreateCRespTransfer create(ItemCreateCReqTransfer command);

}
