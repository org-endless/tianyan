package org.endless.tianyan.item.components.item.group.item.group.facade.adapter.spring;

import org.endless.tianyan.item.components.item.group.item.group.application.command.handler.ItemGroupCommandHandler;
import org.endless.tianyan.item.components.item.group.item.group.application.command.transfer.ItemGroupCreateReqCReqTransfer;
import org.endless.tianyan.item.components.item.group.item.group.application.command.transfer.ItemGroupCreateRespCReqTransfer;
import org.endless.tianyan.item.components.item.group.item.group.application.query.handler.ItemGroupQueryHandler;
import org.endless.tianyan.item.components.item.group.item.group.facade.adapter.ItemGroupDrivingAdapter;

/**
 * SpringItemGroupDrivingAdapter
 * <p>资源项分组领域主动适配器Spring实现类
 * <p>
 * itemCreate 2025/07/21 16:04
 * <p>
 * update 2025/07/21 16:04
 *
 * @author Deng Haozhi
 * @see ItemGroupDrivingAdapter
 * @since 0.0.1
 */
public class SpringItemGroupDrivingAdapter implements ItemGroupDrivingAdapter {

    /**
     * 资源项分组领域命令处理器
     */
    private final ItemGroupCommandHandler itemGroupCommandHandler;

    /**
     * 资源项分组领域查询处理器
     */
    private final ItemGroupQueryHandler itemGroupQueryHandler;

    public SpringItemGroupDrivingAdapter(ItemGroupCommandHandler itemGroupCommandHandler, ItemGroupQueryHandler itemGroupQueryHandler) {
        this.itemGroupCommandHandler = itemGroupCommandHandler;
        this.itemGroupQueryHandler = itemGroupQueryHandler;
    }

    @Override
    public ItemGroupCreateRespCReqTransfer create(ItemGroupCreateReqCReqTransfer command) {
        return itemGroupCommandHandler.create(command);
    }
}
