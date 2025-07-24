package org.endless.tianyan.item.components.item.item.facade.adapter.spring;

import org.endless.tianyan.item.components.item.item.application.command.handler.ItemCommandHandler;
import org.endless.tianyan.item.components.item.item.application.command.transfer.ItemCreateReqCTransfer;
import org.endless.tianyan.item.components.item.item.application.command.transfer.ItemCreateRespCTransfer;
import org.endless.tianyan.item.components.item.item.application.query.handler.ItemQueryHandler;
import org.endless.tianyan.item.components.item.item.facade.adapter.ItemDrivingAdapter;

/**
 * SpringItemDrivingAdapter
 * <p>资源项领域主动适配器Spring实现类
 * <p>
 * create 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see ItemDrivingAdapter
 * @since 0.0.1
 */
public class SpringItemDrivingAdapter implements ItemDrivingAdapter {

    /**
     * 资源项领域命令处理器
     */
    private final ItemCommandHandler itemCommandHandler;

    /**
     * 资源项领域查询处理器
     */
    private final ItemQueryHandler itemQueryHandler;

    public SpringItemDrivingAdapter(ItemCommandHandler itemCommandHandler, ItemQueryHandler itemQueryHandler) {
        this.itemCommandHandler = itemCommandHandler;
        this.itemQueryHandler = itemQueryHandler;
    }

    @Override
    public ItemCreateRespCTransfer create(ItemCreateReqCTransfer command) {
        return itemCommandHandler.create(command);
    }
}
