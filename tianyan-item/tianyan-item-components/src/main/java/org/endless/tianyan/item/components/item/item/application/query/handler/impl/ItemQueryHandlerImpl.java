package org.endless.tianyan.item.components.item.item.application.query.handler.impl;

import org.endless.tianyan.item.components.item.item.application.query.anticorruption.ItemQueryRepository;
import org.endless.tianyan.item.components.item.item.application.query.handler.ItemQueryHandler;

/**
 * ItemQueryHandlerImpl
 * <p>资源项领域查询处理器
 * <p>
 * create 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see ItemQueryHandler
 * @since 0.0.1
 */
public class ItemQueryHandlerImpl implements ItemQueryHandler {

    /**
     * 资源项聚合查询仓储接口
     */
    private final ItemQueryRepository itemQueryRepository;

    public ItemQueryHandlerImpl(ItemQueryRepository itemQueryRepository) {
        this.itemQueryRepository = itemQueryRepository;
    }
}
