package org.endless.tianyan.item.components.item.group.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.item.components.item.group.application.command.handler.ItemGroupCommandHandler;
import org.endless.tianyan.item.components.item.group.application.command.transfer.ItemGroupCreateCReqTransfer;
import org.endless.tianyan.item.components.item.group.application.command.transfer.ItemGroupCreateCRespTransfer;
import org.endless.tianyan.item.components.item.group.domain.anticorruption.ItemGroupRepository;
import org.endless.tianyan.item.components.item.group.domain.entity.ItemGroupAggregate;
import org.endless.tianyan.item.components.item.group.domain.value.NameValue;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * ItemGroupCommandHandlerImpl
 * <p>资源项分组领域命令处理器
 * <p>
 * itemCreate 2025/07/21 16:04
 * <p>
 * update 2025/07/21 16:04
 *
 * @author Deng Haozhi
 * @see ItemGroupCommandHandler
 * @since 0.0.1
 */
@Lazy
@Service
@Validated
public class ItemGroupCommandHandlerImpl implements ItemGroupCommandHandler {

    /**
     * 资源项分组聚合仓储接口
     */
    private final ItemGroupRepository itemGroupRepository;

    public ItemGroupCommandHandlerImpl(ItemGroupRepository itemGroupRepository) {
        this.itemGroupRepository = itemGroupRepository;
    }

    @Override
    @Transactional
    @Log(message = "资源项分组创建命令", value = "#command", level = LogLevel.TRACE)
    public ItemGroupCreateCRespTransfer create(ItemGroupCreateCReqTransfer command) {
        ItemGroupAggregate aggregate = ItemGroupAggregate.create(ItemGroupAggregate.builder()
                .itemCategoryId(command.itemCategoryId())
                .nameZh(NameValue.create(NameValue.builder()
                        .fullName(command.fullNameZh())))
                .nameEn(NameValue.create(NameValue.builder()
                        .fullName(command.fullNameEn())))
                .createUserId(command.createUserId()));
        itemGroupRepository.save(aggregate);
        return ItemGroupCreateCRespTransfer.builder()
                .itemGroupId(aggregate.getItemGroupId()).build();
    }
}
