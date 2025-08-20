package org.endless.tianyan.item.components.item.group.item.group.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.item.components.item.group.item.group.application.command.handler.ItemGroupCommandHandler;
import org.endless.tianyan.item.components.item.group.item.group.application.command.transfer.ItemGroupCreateReqCReqTransfer;
import org.endless.tianyan.item.components.item.group.item.group.application.command.transfer.ItemGroupCreateRespCReqTransfer;
import org.endless.tianyan.item.components.item.group.item.group.domain.anticorruption.ItemGroupRepository;
import org.endless.tianyan.item.components.item.group.item.group.domain.entity.ItemGroupAggregate;
import org.endless.tianyan.item.components.item.group.item.group.domain.value.NameValue;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
    public ItemGroupCreateRespCReqTransfer create(ItemGroupCreateReqCReqTransfer command) {
        Optional.ofNullable(command)
                .map(ItemGroupCreateReqCReqTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("资源项分组创建命令令参数不能为空"));
        ItemGroupAggregate aggregate = ItemGroupAggregate.create(ItemGroupAggregate.builder()
                .nameZh(NameValue.create(NameValue.builder()
                        .fullName(command.getFullNameZh())))
                .nameEn(NameValue.create(NameValue.builder()
                        .fullName(command.getFullNameEn())))
                .createUserId(command.getCreateUserId()));
        itemGroupRepository.save(aggregate);
        return ItemGroupCreateRespCReqTransfer.builder()
                .itemGroupId(aggregate.getItemGroupId())
                .build().validate();
    }
}
