package org.endless.tianyan.metadata.components.event.type.application.query.handler.impl;

import org.endless.tianyan.metadata.components.event.type.application.query.handler.*;
import org.endless.tianyan.metadata.components.event.type.application.query.anticorruption.*;
import org.endless.tianyan.metadata.components.event.type.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.handler.*;

/**
 * EventTypeQueryHandlerImpl
 * <p>事件类型领域查询处理器
 * <p>
 * create 2025/07/28 18:41
 * <p>
 * update 2025/07/28 18:41
 *
 * @author Deng Haozhi
 * @see EventTypeQueryHandler
 * @since 0.0.1
 */
public class EventTypeQueryHandlerImpl implements EventTypeQueryHandler {

    /**
     * 事件类型聚合查询仓储接口
     */
    private final EventTypeQueryRepository eventTypeQueryRepository;

    public EventTypeQueryHandlerImpl(EventTypeQueryRepository eventTypeQueryRepository) {
        this.eventTypeQueryRepository = eventTypeQueryRepository;
    }
}
