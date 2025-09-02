package org.endless.tianyan.metadata.components.industry.industry.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.metadata.components.industry.industry.application.command.handler.IndustryCommandHandler;
import org.endless.tianyan.metadata.components.industry.industry.application.command.transfer.IndustryCreateReqCReqTransfer;
import org.endless.tianyan.metadata.components.industry.industry.domain.anticorruption.IndustryRepository;
import org.endless.tianyan.metadata.components.industry.industry.domain.entity.IndustryAggregate;
import org.endless.tianyan.metadata.components.industry.industry.domain.value.IndustryNameValue;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

/**
 * IndustryCommandHandlerImpl
 * <p>行业领域命令处理器
 * <p>
 * create 2025/07/28 19:04
 * <p>
 * update 2025/07/28 19:04
 *
 * @author Deng Haozhi
 * @see IndustryCommandHandler
 * @since 0.0.1
 */
@Lazy
@Service
@Validated
public class IndustryCommandHandlerImpl implements IndustryCommandHandler {

    /**
     * 行业聚合仓储接口
     */
    private final IndustryRepository industryRepository;

    public IndustryCommandHandlerImpl(IndustryRepository industryRepository) {
        this.industryRepository = industryRepository;
    }

    @Override
    @Log(message = "行业创建命令", value = "#command", level = LogLevel.TRACE)
    public void create(IndustryCreateReqCReqTransfer command) {
        Optional.ofNullable(command)
                .map(IndustryCreateReqCReqTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("行业创建命令参数不能为空"));
        IndustryAggregate aggregate = IndustryAggregate.create(IndustryAggregate.builder()
                .industryCategoryId(command.getIndustryCategoryId())
                .code(command.getCode())
                .name(IndustryNameValue.create(IndustryNameValue.builder()
                        .nameZh(command.getNameZh())
                        .nameEn(command.getNameEn())))
                .description(command.getDescription())
                .createUserId(command.getCreateUserId()));
        industryRepository.save(aggregate);
    }
}
