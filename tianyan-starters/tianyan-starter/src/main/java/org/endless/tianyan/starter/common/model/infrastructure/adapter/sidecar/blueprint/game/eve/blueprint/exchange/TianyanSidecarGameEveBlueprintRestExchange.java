package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.game.eve.blueprint.exchange;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.ddd.infrastructure.adapter.rest.exchange.RestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.game.eve.blueprint.transfer.GameEveBlueprintCreateDReqTransfer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * TianyanCommonGameEveBlueprintRestExchange
 * <p>
 * 游戏EVE蓝图REST-EXCHANGE接口
 * <p>
 * create 2025/08/24 19:59
 * <p>
 * update 2025/08/24 20:04
 *
 * @author Deng Haozhi
 * @see RestExchange
 * @since 1.0.0
 */
@HttpExchange(url = "http://127.0.0.1:10002/blueprint/game-eve-blueprint", contentType = "application/json;charset=UTF-8", accept = "application/json")
public interface TianyanSidecarGameEveBlueprintRestExchange extends RestExchange {

    @Valid
    @NotNull(message = "游戏EVE蓝图创建命令响应体不能为空")
    @PostExchange("/command/create")
    RestResponse<Void> create(
            @NotNull(message = "游戏EVE蓝图创建命令被动请求传输对象不能为空")
            @Valid @RequestBody GameEveBlueprintCreateDReqTransfer command);
}
