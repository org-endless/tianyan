package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.blueprint.exchange;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.ddd.infrastructure.adapter.rest.exchange.RestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.blueprint.transfer.BlueprintCreateDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.blueprint.transfer.BlueprintCreateDRespTransfer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * TianyanCommonBlueprintRestExchange
 * <p>
 * 蓝图REST-EXCHANGE接口
 * <p>
 * create 2025/08/23 01:34
 * <p>
 * update 2025/08/24 20:04
 *
 * @author Deng Haozhi
 * @see RestExchange
 * @since 1.0.0
 */
@HttpExchange(url = "http://127.0.0.1:10101/blueprint/blueprint", contentType = "application/json;charset=UTF-8", accept = "application/json")
public interface TianyanSidecarBlueprintRestExchange extends RestExchange {

    @Valid
    @NotNull(message = "蓝图创建命令响应体不能为空")
    @PostExchange("/command/create")
    RestResponse<BlueprintCreateDRespTransfer> blueprintCreate(
            @NotNull(message = "蓝图创建命令被动请求传输对象不能为空")
            @Valid @RequestBody BlueprintCreateDReqTransfer command);

}
