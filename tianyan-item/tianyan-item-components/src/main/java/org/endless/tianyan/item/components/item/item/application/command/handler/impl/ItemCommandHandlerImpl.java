package org.endless.tianyan.item.components.item.item.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.item.components.item.item.application.command.handler.ItemCommandHandler;
import org.endless.tianyan.item.components.item.item.application.command.transfer.ItemCreateCReqTransfer;
import org.endless.tianyan.item.components.item.item.application.command.transfer.ItemCreateCRespTransfer;
import org.endless.tianyan.item.components.item.item.domain.anticorruption.ItemRepository;
import org.endless.tianyan.item.components.item.item.domain.entity.ItemAggregate;
import org.endless.tianyan.item.components.item.item.domain.value.NameValue;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ItemCommandHandlerImpl
 * <p>资源项领域命令处理器
 * <p>
 * itemCreate 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see ItemCommandHandler
 * @since 0.0.1
 */
@Lazy
@Service
public class ItemCommandHandlerImpl implements ItemCommandHandler {

    /**
     * 资源项聚合仓储接口
     */
    private final ItemRepository itemRepository;

    public ItemCommandHandlerImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    @Transactional
    @Log(message = "资源项创建命令", value = "#command", level = LogLevel.TRACE)
    public ItemCreateCRespTransfer create(ItemCreateCReqTransfer command) {
        ItemAggregate aggregate = ItemAggregate.create(ItemAggregate.builder()
                .metaGroupId(command.metaGroupId())
                .itemGroupId(command.itemGroupId())
                .marketGroupId(command.marketGroupId())
                .nameZh(NameValue.create(NameValue.builder()
                        .fullName(command.fullNameZh())))
                .nameEn(command.fullNameEn() == null ? null : NameValue.create(NameValue.builder()
                        .fullName(command.fullNameEn())))
                .description(command.description())
                .createUserId(command.createUserId()));
        itemRepository.save(aggregate);
        return ItemCreateCRespTransfer.builder()
                .itemId(aggregate.getItemId())
                .build().validate();
    }
}
