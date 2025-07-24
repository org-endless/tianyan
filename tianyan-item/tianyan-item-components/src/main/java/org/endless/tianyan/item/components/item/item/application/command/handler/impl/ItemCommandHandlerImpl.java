package org.endless.tianyan.item.components.item.item.application.command.handler.impl;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.item.components.item.item.application.command.handler.ItemCommandHandler;
import org.endless.tianyan.item.components.item.item.application.command.transfer.ItemCreateReqCTransfer;
import org.endless.tianyan.item.components.item.item.application.command.transfer.ItemCreateRespCTransfer;
import org.endless.tianyan.item.components.item.item.domain.anticorruption.ItemRepository;
import org.endless.tianyan.item.components.item.item.domain.entity.ItemAggregate;
import org.endless.tianyan.item.components.item.item.domain.value.NameValue;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * ItemCommandHandlerImpl
 * <p>资源项领域命令处理器
 * <p>
 * create 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see ItemCommandHandler
 * @since 0.0.1
 */
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
    public ItemCreateRespCTransfer create(ItemCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ItemCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("资源项创建参数不能为空"));
        ItemAggregate aggregate = ItemAggregate.create(ItemAggregate.builder()
                .itemGroupId(command.getItemGroupId())
                .marketGroupId(command.getMarketGroupId())
                .nameZh(NameValue.create(NameValue.builder()
                        .fullName(command.getFullNameZh())))
                .nameEn(NameValue.create(NameValue.builder()
                        .fullName(command.getFullNameEn())))
                .description(command.getDescription())
                .createUserId(command.getCreateUserId()));
        itemRepository.save(aggregate);
        return ItemCreateRespCTransfer.builder()
                .itemId(aggregate.getItemId())
                .build().validate();
    }
}
