package org.endless.tianyan.metadata.components.industry.category.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.metadata.components.industry.category.application.command.handler.IndustryCategoryCommandHandler;
import org.endless.tianyan.metadata.components.industry.category.application.command.transfer.IndustryCategoryCreateReqCTransfer;
import org.endless.tianyan.metadata.components.industry.category.domain.anticorruption.IndustryCategoryRepository;
import org.endless.tianyan.metadata.components.industry.category.domain.entity.IndustryCategoryAggregate;
import org.endless.tianyan.metadata.components.industry.category.domain.value.IndustryCategoryNameValue;

import java.util.Optional;

/**
 * IndustryCategoryCommandHandlerImpl
 * <p>行业分类领域命令处理器
 * <p>
 * create 2025/07/28 18:57
 * <p>
 * update 2025/07/28 18:57
 *
 * @author Deng Haozhi
 * @see IndustryCategoryCommandHandler
 * @since 0.0.1
 */
public class IndustryCategoryCommandHandlerImpl implements IndustryCategoryCommandHandler {

    /**
     * 行业分类聚合仓储接口
     */
    private final IndustryCategoryRepository industryCategoryRepository;

    public IndustryCategoryCommandHandlerImpl(IndustryCategoryRepository industryCategoryRepository) {
        this.industryCategoryRepository = industryCategoryRepository;
    }

    @Override
    @Log(message = "行业分类创建命令", value = "#command", level = LogLevel.TRACE)
    public void create(IndustryCategoryCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(IndustryCategoryCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("行业分类创建命令参数不能为空"));
        IndustryCategoryAggregate aggregate = IndustryCategoryAggregate.create(IndustryCategoryAggregate.builder()
                .code(command.getCode())
                .name(IndustryCategoryNameValue.create(IndustryCategoryNameValue.builder()
                        .nameZh(command.getNameZh())
                        .nameEn(command.getNameEn())))
                .description(command.getDescription())
                .createUserId(command.getCreateUserId()));
        industryCategoryRepository.save(aggregate);
    }
}
