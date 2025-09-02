package org.endless.tianyan.metadata.components.industry.category.facade.rest;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.metadata.common.model.facade.rest.TianyanMetadataRestController;
import org.endless.tianyan.metadata.components.industry.category.application.command.handler.IndustryCategoryCommandHandler;
import org.endless.tianyan.metadata.components.industry.category.application.command.transfer.IndustryCategoryCreateReqCReqTransfer;
import org.endless.tianyan.metadata.components.industry.category.application.query.handler.IndustryCategoryQueryHandler;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * IndustryCategoryRestController
 * <p>行业分类领域REST控制器
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
     * 行业分类领域命令处理器
     */
    private final IndustryCategoryCommandHandler industryCategoryCommandHandler;

    /**
     * 行业分类领域查询处理器
     */
    private final IndustryCategoryQueryHandler industryCategoryQueryHandler;

    public IndustryCategoryRestController(IndustryCategoryCommandHandler industryCategoryCommandHandler, IndustryCategoryQueryHandler industryCategoryQueryHandler) {
        this.industryCategoryCommandHandler = industryCategoryCommandHandler;
        this.industryCategoryQueryHandler = industryCategoryQueryHandler;
    }


    @PostMapping("/command/create")
    @Log(message = "行业分类创建", value = "#command")
    public ResponseEntity<RestResponse<Void>> create(@RequestBody IndustryCategoryCreateReqCReqTransfer command) {
        Optional.ofNullable(command)
                .map(IndustryCategoryCreateReqCReqTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("行业分类创建参数不能为空"));
        industryCategoryCommandHandler.create(command);
        return response().success("行业分类创建成功");
    }

    @Override
    public String domainDescription() {
        return "行业分类领域";
    }
}
