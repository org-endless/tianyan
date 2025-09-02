package org.endless.tianyan.metadata.components.event.type.application.command.handler;

import org.endless.tianyan.metadata.common.model.application.command.handler.TianyanMetadataCommandHandler;
import org.endless.tianyan.metadata.components.event.type.application.command.transfer.EventTypeCreateReqCReqTransfer;
import org.endless.tianyan.metadata.components.event.type.domain.entity.EventTypeAggregate;

/**
 * EventTypeCommandHandler
 * <p>事件类型领域命令处理器
 * <p>
 * create 2025/07/28 18:41
 * <p>
 * update 2025/07/28 18:41
 *
 * @author Deng Haozhi
 * @see TianyanMetadataCommandHandler<EventTypeAggregate>
 * @since 0.0.1
 */
public interface EventTypeCommandHandler extends TianyanMetadataCommandHandler<EventTypeAggregate> {

    void create(EventTypeCreateReqCReqTransfer command);

}
