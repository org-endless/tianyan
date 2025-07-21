package org.endless.tianyan.item.components.item.category.item.category.application.command.handler;

import org.endless.tianyan.item.common.model.application.command.handler.TianyanItemCommandHandler;
import org.endless.tianyan.item.components.item.category.item.category.application.command.transfer.ItemCategoryCreateReqCTransfer;
import org.endless.tianyan.item.components.item.category.item.category.application.command.transfer.ItemCategoryCreateRespCTransfer;
import org.endless.tianyan.item.components.item.category.item.category.domain.entity.ItemCategoryAggregate;

/**
 * ItemCategoryCommandHandler
 * <p>物品分类领域命令处理器
 * <p>
 * create 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see TianyanItemCommandHandler<ItemCategoryAggregate>
 * @since 0.0.1
 */
public interface ItemCategoryCommandHandler extends TianyanItemCommandHandler<ItemCategoryAggregate> {

    ItemCategoryCreateRespCTransfer create(ItemCategoryCreateReqCTransfer command);

}
