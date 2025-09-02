package org.endless.tianyan.manufacturing.components.blueprint.blueprint.facade.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.tianyan.manufacturing.common.model.facade.rest.TianyanManufacturingRestController;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.handler.BlueprintCommandHandler;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.transfer.BlueprintCreateReqCReqTransfer;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.query.handler.BlueprintQueryHandler;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BlueprintRestController
 * <p>蓝图领域REST控制器
 * <p>
 * create 2025/07/23 17:17
 * <p>
 * update 2025/07/23 17:17
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/blueprint")
public class BlueprintRestController implements TianyanManufacturingRestController {

    /**
     * 蓝图领域命令处理器
     */
    private final BlueprintCommandHandler blueprintCommandHandler;

    /**
     * 蓝图领域查询处理器
     */
    private final BlueprintQueryHandler blueprintQueryHandler;

    public BlueprintRestController(BlueprintCommandHandler blueprintCommandHandler, BlueprintQueryHandler blueprintQueryHandler) {
        this.blueprintCommandHandler = blueprintCommandHandler;
        this.blueprintQueryHandler = blueprintQueryHandler;
    }

    @PostMapping("/command/create")
    @Log(message = "蓝图创建命令", value = "#command")
    public ResponseEntity<RestResponse<Void>> create(
            @NotNull(message = "蓝图创建命令请求传输对象不能为空")
            @Valid @RequestBody BlueprintCreateReqCReqTransfer command) {
        blueprintCommandHandler.create(command);
        return response().success("蓝图创建成功");
    }

    @Override
    public String domainDescription() {
        return "蓝图领域";
    }
}
