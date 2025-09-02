package org.endless.tianyan.item.components.item.group.application.query.handler.impl;

import org.endless.tianyan.item.components.item.group.application.query.anticorruption.ItemGroupQueryRepository;
import org.endless.tianyan.item.components.item.group.application.query.handler.ItemGroupQueryHandler;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * ItemGroupQueryHandlerImpl
 * <p>资源项分组领域查询处理器
 * <p>
 * itemCreate 2025/07/21 16:04
 * <p>
 * update 2025/07/21 16:04
 *
 * @author Deng Haozhi
 * @see ItemGroupQueryHandler
 * @since 0.0.1
 */
@Lazy
@Service
@Validated
public class ItemGroupQueryHandlerImpl implements ItemGroupQueryHandler {

    /**
     * 资源项分组聚合查询仓储接口
     */
    private final ItemGroupQueryRepository itemGroupQueryRepository;

    public ItemGroupQueryHandlerImpl(ItemGroupQueryRepository itemGroupQueryRepository) {
        this.itemGroupQueryRepository = itemGroupQueryRepository;
    }
}
