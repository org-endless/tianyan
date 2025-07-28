package org.endless.tianyan.metadata.components.industry.category.sidecar.rest;

import com.alibaba.fastjson2.JSONException;
import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.CommandReqTransferNullException;
import org.endless.ddd.simplified.starter.common.exception.model.sidecar.rest.RestErrorException;
import org.endless.ddd.simplified.starter.common.model.sidecar.rest.RestResponse;
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
        try {
            industryCategoryDrivingAdapter.create(command);
            return response().success("行业分类创建成功");
        } catch (JSONException | NullPointerException e) {
            throw new RestErrorException("行业分类创建失败", e);
        }
    }
}
