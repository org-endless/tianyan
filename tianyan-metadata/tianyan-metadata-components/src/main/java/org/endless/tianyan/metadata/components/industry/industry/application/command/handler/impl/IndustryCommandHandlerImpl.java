package org.endless.tianyan.metadata.components.industry.industry.application.command.handler.impl;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.metadata.components.industry.category.application.query.transfer.IndustryCategoryFindByIdReqQTransfer;
import org.endless.tianyan.metadata.components.industry.category.facade.adapter.IndustryCategoryDrivingAdapter;
import org.endless.tianyan.metadata.components.industry.industry.application.command.handler.IndustryCommandHandler;
import org.endless.tianyan.metadata.components.industry.industry.application.command.transfer.IndustryCreateReqCTransfer;
import org.endless.tianyan.metadata.components.industry.industry.domain.anticorruption.IndustryRepository;
import org.endless.tianyan.metadata.components.industry.industry.domain.entity.IndustryAggregate;
import org.endless.tianyan.metadata.components.industry.industry.domain.value.IndustryNameValue;

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
public class IndustryCommandHandlerImpl implements IndustryCommandHandler {

    /**
     * 行业聚合仓储接口
     */
    private final IndustryRepository industryRepository;

    private final IndustryCategoryDrivingAdapter industryCategoryDrivingAdapter;

    public IndustryCommandHandlerImpl(IndustryRepository industryRepository, IndustryCategoryDrivingAdapter industryCategoryDrivingAdapter) {
        this.industryRepository = industryRepository;
        this.industryCategoryDrivingAdapter = industryCategoryDrivingAdapter;
    }

    @Override
    @Log(message = "行业创建命令", value = "#command", level = LogLevel.TRACE)
    public void create(IndustryCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(IndustryCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("行业创建命令参数不能为空"));
        industryCategoryDrivingAdapter.existsById(IndustryCategoryFindByIdReqQTransfer.builder()
                .industryCategoryId(command.getIndustryCategoryId()).build().validate());
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
