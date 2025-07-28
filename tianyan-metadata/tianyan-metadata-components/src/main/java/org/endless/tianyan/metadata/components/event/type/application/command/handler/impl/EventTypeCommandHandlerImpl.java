package org.endless.tianyan.metadata.components.event.type.application.command.handler.impl;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.metadata.components.event.type.application.command.handler.EventTypeCommandHandler;
import org.endless.tianyan.metadata.components.event.type.application.command.transfer.EventTypeCreateReqCTransfer;
import org.endless.tianyan.metadata.components.event.type.domain.anticorruption.EventTypeRepository;
import org.endless.tianyan.metadata.components.event.type.domain.entity.EventTypeAggregate;
import org.endless.tianyan.metadata.components.event.type.domain.value.EventTypeNameValue;

import java.util.Optional;

/**
 * EventTypeCommandHandlerImpl
 * <p>事件类型领域命令处理器
 * <p>
 * create 2025/07/28 18:41
 * <p>
 * update 2025/07/28 18:41
 *
 * @author Deng Haozhi
 * @see EventTypeCommandHandler
 * @since 0.0.1
 */
public class EventTypeCommandHandlerImpl implements EventTypeCommandHandler {

    /**
     * 事件类型聚合仓储接口
     */
    private final EventTypeRepository eventTypeRepository;

    public EventTypeCommandHandlerImpl(EventTypeRepository eventTypeRepository) {
        this.eventTypeRepository = eventTypeRepository;
    }

    @Override
    @Log(message = "事件类型创建命令", value = "#command", level = LogLevel.TRACE)
    public void create(EventTypeCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(EventTypeCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("事件类型创建命令参数不能为空"));
        EventTypeAggregate aggregate = EventTypeAggregate.create(EventTypeAggregate.builder()
                .code(command.getCode())
                .name(EventTypeNameValue.create(EventTypeNameValue.builder()
                        .nameZh(command.getNameZh())
                        .nameEn(command.getNameEn())))
                .description(command.getDescription())
                .createUserId(command.getCreateUserId()));
        eventTypeRepository.save(aggregate);
    }
}
