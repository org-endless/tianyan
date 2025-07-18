package org.endless.tianyan.item.components.item.item.application.query.handler.impl;

import org.endless.tianyan.item.components.item.item.application.query.handler.*;
import org.endless.tianyan.item.components.item.item.application.query.anticorruption.*;
import org.endless.tianyan.item.components.item.item.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.handler.*;

/**
 * ItemQueryHandlerImpl
 * <p>物品领域查询处理器
 * <p>
 * create 2025/07/19 07:15
 * <p>
 * update 2025/07/19 07:15
 *
 * @author Deng Haozhi
 * @see ItemQueryHandler
 * @since 0.0.1
 */
public class ItemQueryHandlerImpl implements ItemQueryHandler {

    /**
     * 物品聚合查询仓储接口
     */
    private final ItemQueryRepository itemQueryRepository;

    public ItemQueryHandlerImpl(ItemQueryRepository itemQueryRepository) {
        this.itemQueryRepository = itemQueryRepository;
    }
}
