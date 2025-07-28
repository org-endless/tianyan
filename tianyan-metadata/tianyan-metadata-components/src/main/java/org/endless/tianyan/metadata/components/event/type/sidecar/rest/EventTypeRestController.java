package org.endless.tianyan.metadata.components.event.type.sidecar.rest;

import com.alibaba.fastjson2.JSONException;
import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.CommandReqTransferNullException;
import org.endless.ddd.simplified.starter.common.exception.model.sidecar.rest.RestErrorException;
import org.endless.ddd.simplified.starter.common.model.sidecar.rest.RestResponse;
import org.endless.tianyan.metadata.common.model.sidecar.rest.TianyanMetadataRestController;
import org.endless.tianyan.metadata.components.event.type.application.command.transfer.EventTypeCreateReqCTransfer;
import org.endless.tianyan.metadata.components.event.type.facade.adapter.EventTypeDrivingAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * EventTypeRestController
 * <p>事件类型领域Rest控制器
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
     * 事件类型领域主动适配器
     */
    private final EventTypeDrivingAdapter eventTypeDrivingAdapter;

    public EventTypeRestController(EventTypeDrivingAdapter eventTypeDrivingAdapter) {
        this.eventTypeDrivingAdapter = eventTypeDrivingAdapter;
    }

    @PostMapping("/command/create")
    @Log(message = "事件类型创建", value = "#command")
    public ResponseEntity<RestResponse> create(@RequestBody EventTypeCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(EventTypeCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("事件类型创建参数不能为空"));
        try {
            eventTypeDrivingAdapter.create(command);
            return response().success("事件类型创建成功");
        } catch (JSONException | NullPointerException e) {
            throw new RestErrorException("事件类型创建失败", e);
        }
    }
}
