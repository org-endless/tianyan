package org.endless.tianyan.item.components.item.group.item.group.application.command.handler.impl;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.item.components.item.group.item.group.application.command.handler.ItemGroupCommandHandler;
import org.endless.tianyan.item.components.item.group.item.group.application.command.transfer.ItemGroupCreateReqCTransfer;
import org.endless.tianyan.item.components.item.group.item.group.application.command.transfer.ItemGroupCreateRespCTransfer;
import org.endless.tianyan.item.components.item.group.item.group.domain.anticorruption.ItemGroupRepository;
import org.endless.tianyan.item.components.item.group.item.group.domain.entity.ItemGroupAggregate;
import org.endless.tianyan.item.components.item.group.item.group.domain.value.NameValue;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * ItemGroupCommandHandlerImpl
 * <p>物品分组领域命令处理器
 * <p>
 * create 2025/07/21 16:04
 * <p>
 * update 2025/07/21 16:04
 *
 * @author Deng Haozhi
 * @see ItemGroupCommandHandler
 * @since 0.0.1
 */
public class ItemGroupCommandHandlerImpl implements ItemGroupCommandHandler {

    /**
     * 物品分组聚合仓储接口
     */
    private final ItemGroupRepository itemGroupRepository;

    public ItemGroupCommandHandlerImpl(ItemGroupRepository itemGroupRepository) {
        this.itemGroupRepository = itemGroupRepository;
    }

    @Override
    @Transactional
    @Log(message = "物品分类创建命令", value = "#command", level = LogLevel.TRACE)
    public ItemGroupCreateRespCTransfer create(ItemGroupCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ItemGroupCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("物品分类创建命令令参数不能为空"));
        ItemGroupAggregate aggregate = ItemGroupAggregate.create(ItemGroupAggregate.builder()
                .nameZh(NameValue.create(NameValue.builder()
                        .fullName(command.getNameZh())))
                .nameEn(NameValue.create(NameValue.builder()
                        .fullName(command.getNameEn())))
                .createUserId(command.getCreateUserId()));
        itemGroupRepository.save(aggregate);
        return ItemGroupCreateRespCTransfer.builder()
                .itemGroupId(aggregate.getItemGroupId())
                .build().validate();
    }
}
