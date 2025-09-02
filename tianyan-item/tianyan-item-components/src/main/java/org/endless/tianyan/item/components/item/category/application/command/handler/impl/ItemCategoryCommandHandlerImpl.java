package org.endless.tianyan.item.components.item.category.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.item.components.item.category.application.command.handler.ItemCategoryCommandHandler;
import org.endless.tianyan.item.components.item.category.application.command.transfer.ItemCategoryCreateCReqTransfer;
import org.endless.tianyan.item.components.item.category.application.command.transfer.ItemCategoryCreateCRespTransfer;
import org.endless.tianyan.item.components.item.category.domain.anticorruption.ItemCategoryRepository;
import org.endless.tianyan.item.components.item.category.domain.entity.ItemCategoryAggregate;
import org.endless.tianyan.item.components.item.category.domain.value.NameValue;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * ItemCategoryCommandHandlerImpl
 * <p>资源项分类领域命令处理器
 * <p>
 * itemCreate 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see ItemCategoryCommandHandler
 * @since 0.0.1
 */
@Lazy
@Service
@Validated
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
    public ItemCategoryCreateCRespTransfer create(ItemCategoryCreateCReqTransfer command) {
        ItemCategoryAggregate aggregate = ItemCategoryAggregate.create(ItemCategoryAggregate.builder()
                .nameZh(NameValue.create(NameValue.builder()
                        .fullName(command.fullNameZh())))
                .nameEn(NameValue.create(NameValue.builder()
                        .fullName(command.fullNameEn())))
                .createUserId(command.createUserId()));
        itemCategoryRepository.save(aggregate);
        return ItemCategoryCreateCRespTransfer.builder()
                .itemCategoryId(aggregate.getItemCategoryId()).build();
    }
}
