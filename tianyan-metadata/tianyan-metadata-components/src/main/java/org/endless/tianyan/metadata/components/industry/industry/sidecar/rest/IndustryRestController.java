package org.endless.tianyan.metadata.components.industry.industry.sidecar.rest;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.metadata.common.model.sidecar.rest.TianyanMetadataRestController;
import org.endless.tianyan.metadata.components.industry.industry.application.command.transfer.IndustryCreateReqCTransfer;
import org.endless.tianyan.metadata.components.industry.industry.facade.adapter.IndustryDrivingAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * IndustryRestController
 * <p>行业领域Rest控制器
 * <p>
 * create 2025/07/28 19:04
 * <p>
 * update 2025/07/28 19:04
 *
 * @author Deng Haozhi
 * @see TianyanMetadataRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/industry")
public class IndustryRestController implements TianyanMetadataRestController {

    /**
     * 行业领域主动适配器
     */
    private final IndustryDrivingAdapter industryDrivingAdapter;

    public IndustryRestController(IndustryDrivingAdapter industryDrivingAdapter) {
        this.industryDrivingAdapter = industryDrivingAdapter;
    }

    @PostMapping("/command/create")
    @Log(message = "行业创建", value = "#command")
    public ResponseEntity<RestResponse> create(@RequestBody IndustryCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(IndustryCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("行业创建参数不能为空"));
        industryDrivingAdapter.create(command);
        return response().success("行业创建成功");
    }
}
