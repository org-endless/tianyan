package org.endless.tianyan.item.components.item.item.application.command.handler.impl;

import org.endless.tianyan.item.components.item.item.application.command.handler.*;
import org.endless.tianyan.item.components.item.item.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.handler.*;

/**
 * ItemCommandHandlerImpl
 * <p>物品领域命令处理器
 * <p>
 * create 2025/07/19 07:15
 * <p>
 * update 2025/07/19 07:15
 *
 * @author Deng Haozhi
 * @see ItemCommandHandler
 * @since 0.0.1
 */
public class ItemCommandHandlerImpl implements ItemCommandHandler {

    /**
     * 物品聚合仓储接口
     */
    private final ItemRepository itemRepository;

    public ItemCommandHandlerImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
}
