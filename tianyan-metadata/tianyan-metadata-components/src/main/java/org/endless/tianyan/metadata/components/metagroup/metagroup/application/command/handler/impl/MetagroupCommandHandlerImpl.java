package org.endless.tianyan.metadata.components.metagroup.metagroup.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.metadata.components.metagroup.metagroup.application.command.handler.MetagroupCommandHandler;
import org.endless.tianyan.metadata.components.metagroup.metagroup.application.command.transfer.MetagroupCreateCReqTransfer;
import org.endless.tianyan.metadata.components.metagroup.metagroup.application.command.transfer.MetagroupCreateCRespTransfer;
import org.endless.tianyan.metadata.components.metagroup.metagroup.domain.anticorruption.MetagroupRepository;
import org.endless.tianyan.metadata.components.metagroup.metagroup.domain.entity.MetagroupAggregate;
import org.endless.tianyan.metadata.components.metagroup.metagroup.domain.value.NameValue;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * MetagroupCommandHandlerImpl
 * <p>元分组领域命令处理器
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see MetagroupCommandHandler
 * @since 0.0.1
 */
@Lazy
@Service
@Validated
public class MetagroupCommandHandlerImpl implements MetagroupCommandHandler {

    /**
     * 元分组聚合仓储接口
     */
    private final MetagroupRepository metaGroupRepository;

    public MetagroupCommandHandlerImpl(MetagroupRepository metaGroupRepository) {
        this.metaGroupRepository = metaGroupRepository;
    }

    @Override
    @Log(message = "元分组创建命令", value = "#command", level = LogLevel.TRACE)
    public MetagroupCreateCRespTransfer create(MetagroupCreateCReqTransfer command) {
        MetagroupAggregate aggregate = MetagroupAggregate.create(MetagroupAggregate.builder()
                .nameZh(NameValue.create(NameValue.builder()
                        .fullName(command.fullNameZh())))
                .nameEn(NameValue.create(NameValue.builder()
                        .fullName(command.fullNameEn())))
                .createUserId(command.createUserId()));
        metaGroupRepository.save(aggregate);
        return MetagroupCreateCRespTransfer.builder()
                .metagroupId(aggregate.getMetagroupId())
                .build().validate();
    }
}
