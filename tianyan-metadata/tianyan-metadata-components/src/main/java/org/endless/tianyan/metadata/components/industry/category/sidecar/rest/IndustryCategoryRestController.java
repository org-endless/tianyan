package org.endless.tianyan.metadata.components.industry.category.sidecar.rest;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.metadata.common.model.sidecar.rest.TianyanMetadataRestController;
import org.endless.tianyan.metadata.components.industry.category.application.command.transfer.IndustryCategoryCreateReqCTransfer;
import org.endless.tianyan.metadata.components.industry.category.facade.adapter.IndustryCategoryDrivingAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * IndustryCategoryRestController
 * <p>行业分类领域Rest控制器
 * <p>
 * create 2025/07/28 18:57
 * <p>
 * update 2025/07/28 18:57
 *
 * @author Deng Haozhi
 * @see TianyanMetadataRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/industry/category")
public class IndustryCategoryRestController implements TianyanMetadataRestController {

    /**
     * 行业分类领域主动适配器
     */
    private final IndustryCategoryDrivingAdapter industryCategoryDrivingAdapter;

    public IndustryCategoryRestController(IndustryCategoryDrivingAdapter industryCategoryDrivingAdapter) {
        this.industryCategoryDrivingAdapter = industryCategoryDrivingAdapter;
    }

    @PostMapping("/command/create")
    @Log(message = "行业分类创建", value = "#command")
    public ResponseEntity<RestResponse> create(@RequestBody IndustryCategoryCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(IndustryCategoryCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("行业分类创建参数不能为空"));
        industryCategoryDrivingAdapter.create(command);
        return response().success("行业分类创建成功");
    }
}
