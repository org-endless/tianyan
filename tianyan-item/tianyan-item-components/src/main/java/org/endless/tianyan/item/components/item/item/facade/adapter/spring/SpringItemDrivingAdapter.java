package org.endless.tianyan.item.components.item.item.facade.adapter.spring;

import org.endless.tianyan.item.components.item.item.facade.adapter.*;
import org.endless.tianyan.item.components.item.item.application.command.handler.*;
import org.endless.tianyan.item.components.item.item.application.query.handler.*;
import org.endless.ddd.simplified.starter.common.exception.model.facade.adapter.*;

/**
 * SpringItemDrivingAdapter
 * <p>物品领域主动适配器Spring实现类
 * <p>
 * create 2025/07/19 07:15
 * <p>
 * update 2025/07/19 07:15
 *
 * @author Deng Haozhi
 * @see ItemDrivingAdapter
 * @since 0.0.1
 */
public class SpringItemDrivingAdapter implements ItemDrivingAdapter {

    /**
     * 物品领域命令处理器
     */
    private final ItemCommandHandler itemCommandHandler;

    /**
     * 物品领域查询处理器
     */
    private final ItemQueryHandler itemQueryHandler;

    public SpringItemDrivingAdapter(ItemCommandHandler itemCommandHandler, ItemQueryHandler itemQueryHandler) {
        this.itemCommandHandler = itemCommandHandler;
        this.itemQueryHandler = itemQueryHandler;
    }
}
