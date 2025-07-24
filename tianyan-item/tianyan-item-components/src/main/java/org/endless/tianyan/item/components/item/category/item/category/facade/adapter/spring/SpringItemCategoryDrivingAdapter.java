package org.endless.tianyan.item.components.item.category.item.category.facade.adapter.spring;

import org.endless.tianyan.item.components.item.category.item.category.application.command.handler.ItemCategoryCommandHandler;
import org.endless.tianyan.item.components.item.category.item.category.application.command.transfer.ItemCategoryCreateReqCTransfer;
import org.endless.tianyan.item.components.item.category.item.category.application.command.transfer.ItemCategoryCreateRespCTransfer;
import org.endless.tianyan.item.components.item.category.item.category.application.query.handler.ItemCategoryQueryHandler;
import org.endless.tianyan.item.components.item.category.item.category.facade.adapter.ItemCategoryDrivingAdapter;

/**
 * SpringItemCategoryDrivingAdapter
 * <p>资源项分类领域主动适配器Spring实现类
 * <p>
 * create 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see ItemCategoryDrivingAdapter
 * @since 0.0.1
 */
public class SpringItemCategoryDrivingAdapter implements ItemCategoryDrivingAdapter {

    /**
     * 资源项分类领域命令处理器
     */
    private final ItemCategoryCommandHandler itemCategoryCommandHandler;

    /**
     * 资源项分类领域查询处理器
     */
    private final ItemCategoryQueryHandler itemCategoryQueryHandler;

    public SpringItemCategoryDrivingAdapter(ItemCategoryCommandHandler itemCategoryCommandHandler, ItemCategoryQueryHandler itemCategoryQueryHandler) {
        this.itemCategoryCommandHandler = itemCategoryCommandHandler;
        this.itemCategoryQueryHandler = itemCategoryQueryHandler;
    }

    @Override
    public ItemCategoryCreateRespCTransfer create(ItemCategoryCreateReqCTransfer command) {
        return itemCategoryCommandHandler.create(command);
    }
}
