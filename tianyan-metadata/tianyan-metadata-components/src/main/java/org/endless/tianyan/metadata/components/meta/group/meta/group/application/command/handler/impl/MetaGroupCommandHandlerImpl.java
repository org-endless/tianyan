package org.endless.tianyan.metadata.components.meta.group.meta.group.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.metadata.components.meta.group.meta.group.application.command.handler.MetaGroupCommandHandler;
import org.endless.tianyan.metadata.components.meta.group.meta.group.application.command.transfer.MetaGroupCreateReqCTransfer;
import org.endless.tianyan.metadata.components.meta.group.meta.group.application.command.transfer.MetaGroupCreateRespCTransfer;
import org.endless.tianyan.metadata.components.meta.group.meta.group.domain.anticorruption.MetaGroupRepository;
import org.endless.tianyan.metadata.components.meta.group.meta.group.domain.entity.MetaGroupAggregate;
import org.endless.tianyan.metadata.components.meta.group.meta.group.domain.value.NameValue;

import java.util.Optional;

/**
 * MetaGroupCommandHandlerImpl
 * <p>元分组领域命令处理器
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see MetaGroupCommandHandler
 * @since 0.0.1
 */
public class MetaGroupCommandHandlerImpl implements MetaGroupCommandHandler {

    /**
     * 元分组聚合仓储接口
     */
    private final MetaGroupRepository metaGroupRepository;

    public MetaGroupCommandHandlerImpl(MetaGroupRepository metaGroupRepository) {
        this.metaGroupRepository = metaGroupRepository;
    }

    @Override
    @Log(message = "元分组创建命令", value = "#command", level = LogLevel.TRACE)
    public MetaGroupCreateRespCTransfer create(MetaGroupCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(MetaGroupCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("元分组创建命令参数不能为空"));
        MetaGroupAggregate aggregate = MetaGroupAggregate.create(MetaGroupAggregate.builder()
                .nameZh(NameValue.create(NameValue.builder()
                        .fullName(command.getFullNameZh())))
                .nameEn(NameValue.create(NameValue.builder()
                        .fullName(command.getFullNameEn())))
                .createUserId(command.getCreateUserId()));
        metaGroupRepository.save(aggregate);
        return MetaGroupCreateRespCTransfer.builder()
                .metaGroupId(aggregate.getMetaGroupId())
                .build().validate();
    }
}
