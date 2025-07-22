package org.endless.tianyan.item.components.item.group.item.group.application.query.handler.impl;

import org.endless.tianyan.item.components.item.group.item.group.application.query.handler.*;
import org.endless.tianyan.item.components.item.group.item.group.application.query.anticorruption.*;
import org.endless.tianyan.item.components.item.group.item.group.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.handler.*;

/**
 * ItemGroupQueryHandlerImpl
 * <p>物品分组领域查询处理器
 * <p>
 * create 2025/07/21 16:04
 * <p>
 * update 2025/07/21 16:04
 *
 * @author Deng Haozhi
 * @see ItemGroupQueryHandler
 * @since 0.0.1
 */
public class ItemGroupQueryHandlerImpl implements ItemGroupQueryHandler {

    /**
     * 物品分组聚合查询仓储接口
     */
    private final ItemGroupQueryRepository itemGroupQueryRepository;

    public ItemGroupQueryHandlerImpl(ItemGroupQueryRepository itemGroupQueryRepository) {
        this.itemGroupQueryRepository = itemGroupQueryRepository;
    }
}
