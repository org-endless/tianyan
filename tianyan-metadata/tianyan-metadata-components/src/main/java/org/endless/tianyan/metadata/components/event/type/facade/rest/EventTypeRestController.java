package org.endless.tianyan.metadata.components.event.type.facade.rest;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.metadata.common.model.facade.rest.TianyanMetadataRestController;
import org.endless.tianyan.metadata.components.event.type.application.command.handler.EventTypeCommandHandler;
import org.endless.tianyan.metadata.components.event.type.application.command.transfer.EventTypeCreateReqCReqTransfer;
import org.endless.tianyan.metadata.components.event.type.application.query.handler.EventTypeQueryHandler;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * EventTypeRestController
 * <p>事件类型领域REST控制器
 * <p>
 * create 2025/07/28 18:41
 * <p>
 * update 2025/07/28 18:41
 *
 * @author Deng Haozhi
 * @see TianyanMetadataRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/event/type")
public class EventTypeRestController implements TianyanMetadataRestController {

    /**
     * 事件类型领域命令处理器
     */
    private final EventTypeCommandHandler eventTypeCommandHandler;

    /**
     * 事件类型领域查询处理器
     */
    private final EventTypeQueryHandler eventTypeQueryHandler;

    public EventTypeRestController(EventTypeCommandHandler eventTypeCommandHandler, EventTypeQueryHandler eventTypeQueryHandler) {
        this.eventTypeCommandHandler = eventTypeCommandHandler;
        this.eventTypeQueryHandler = eventTypeQueryHandler;
    }


    @PostMapping("/command/create")
    @Log(message = "事件类型创建", value = "#command")
    public ResponseEntity<RestResponse<Void>> create(@RequestBody EventTypeCreateReqCReqTransfer command) {
        Optional.ofNullable(command)
                .map(EventTypeCreateReqCReqTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("事件类型创建参数不能为空"));
        eventTypeCommandHandler.create(command);
        return response().success("事件类型创建成功");
    }

    @Override
    public String domainDescription() {
        return "事件类型领域";
    }
}
