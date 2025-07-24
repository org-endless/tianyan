package org.endless.tianyan.item.components.item.category.item.category.application.command.handler.impl;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.item.components.item.category.item.category.application.command.handler.ItemCategoryCommandHandler;
import org.endless.tianyan.item.components.item.category.item.category.application.command.transfer.ItemCategoryCreateReqCTransfer;
import org.endless.tianyan.item.components.item.category.item.category.application.command.transfer.ItemCategoryCreateRespCTransfer;
import org.endless.tianyan.item.components.item.category.item.category.domain.anticorruption.ItemCategoryRepository;
import org.endless.tianyan.item.components.item.category.item.category.domain.entity.ItemCategoryAggregate;
import org.endless.tianyan.item.components.item.category.item.category.domain.value.NameValue;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * ItemCategoryCommandHandlerImpl
 * <p>资源项分类领域命令处理器
 * <p>
 * create 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see ItemCategoryCommandHandler
 * @since 0.0.1
 */
public class ItemCategoryCommandHandlerImpl implements ItemCategoryCommandHandler {

    /**
     * 资源项分类聚合仓储接口
     */
    private final ItemCategoryRepository itemCategoryRepository;

    public ItemCategoryCommandHandlerImpl(ItemCategoryRepository itemCategoryRepository) {
        this.itemCategoryRepository = itemCategoryRepository;
    }

    @Override
    @Transactional
    @Log(message = "资源项分类创建命令", value = "#command", level = LogLevel.TRACE)
    public ItemCategoryCreateRespCTransfer create(ItemCategoryCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ItemCategoryCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("资源项分类创建命令参数不能为空"));
        ItemCategoryAggregate aggregate = ItemCategoryAggregate.create(ItemCategoryAggregate.builder()
                .nameZh(NameValue.create(NameValue.builder()
                        .fullName(command.getNameZh())))
                .nameEn(NameValue.create(NameValue.builder()
                        .fullName(command.getNameEn())))
                .createUserId(command.getCreateUserId()));
        itemCategoryRepository.save(aggregate);
        return ItemCategoryCreateRespCTransfer.builder()
                .itemCategoryId(aggregate.getItemCategoryId())
                .build().validate();
    }
}
