package org.endless.tianyan.metadata.components.event.type.facade.adapter.spring;

import org.endless.tianyan.metadata.components.event.type.application.command.handler.EventTypeCommandHandler;
import org.endless.tianyan.metadata.components.event.type.application.command.transfer.EventTypeCreateReqCTransfer;
import org.endless.tianyan.metadata.components.event.type.application.query.handler.EventTypeQueryHandler;
import org.endless.tianyan.metadata.components.event.type.facade.adapter.EventTypeDrivingAdapter;

/**
 * SpringEventTypeDrivingAdapter
 * <p>事件类型领域主动适配器Spring实现类
 * <p>
 * create 2025/07/28 18:41
 * <p>
 * update 2025/07/28 18:41
 *
 * @author Deng Haozhi
 * @see EventTypeDrivingAdapter
 * @since 0.0.1
 */
public class SpringEventTypeDrivingAdapter implements EventTypeDrivingAdapter {

    /**
     * 事件类型领域命令处理器
     */
    private final EventTypeCommandHandler eventTypeCommandHandler;

    /**
     * 事件类型领域查询处理器
     */
    private final EventTypeQueryHandler eventTypeQueryHandler;

    public SpringEventTypeDrivingAdapter(EventTypeCommandHandler eventTypeCommandHandler, EventTypeQueryHandler eventTypeQueryHandler) {
        this.eventTypeCommandHandler = eventTypeCommandHandler;
        this.eventTypeQueryHandler = eventTypeQueryHandler;
    }

    @Override
    public void create(EventTypeCreateReqCTransfer command) {
        eventTypeCommandHandler.create(command);
    }
}
