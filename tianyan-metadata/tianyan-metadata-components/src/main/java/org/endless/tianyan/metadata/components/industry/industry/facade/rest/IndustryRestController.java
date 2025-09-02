package org.endless.tianyan.metadata.components.industry.industry.facade.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.tianyan.metadata.common.model.facade.rest.TianyanMetadataRestController;
import org.endless.tianyan.metadata.components.industry.industry.application.command.handler.IndustryCommandHandler;
import org.endless.tianyan.metadata.components.industry.industry.application.command.transfer.IndustryCreateReqCReqTransfer;
import org.endless.tianyan.metadata.components.industry.industry.application.query.handler.IndustryQueryHandler;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * IndustryRestController
 * <p>行业领域REST控制器
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
     * 行业领域命令处理器
     */
    private final IndustryCommandHandler industryCommandHandler;

    /**
     * 行业领域查询处理器
     */
    private final IndustryQueryHandler industryQueryHandler;

    public IndustryRestController(IndustryCommandHandler industryCommandHandler, IndustryQueryHandler industryQueryHandler) {
        this.industryCommandHandler = industryCommandHandler;
        this.industryQueryHandler = industryQueryHandler;
    }


    @PostMapping("/command/create")
    @Log(message = "行业创建", value = "#command")
    public ResponseEntity<RestResponse<Void>> create(
            @NotNull
            @Valid @RequestBody IndustryCreateReqCReqTransfer command) {
        industryCommandHandler.create(command);
        return response().success("行业创建成功");
    }

    @Override
    public String domainDescription() {
        return "行业领域";
    }
}
