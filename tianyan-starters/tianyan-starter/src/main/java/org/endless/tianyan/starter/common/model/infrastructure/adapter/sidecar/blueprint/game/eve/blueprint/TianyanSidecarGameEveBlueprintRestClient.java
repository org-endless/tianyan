package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.game.eve.blueprint;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.rest.TianyanCommonRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.game.eve.blueprint.transfer.GameEveBlueprintCreateDReqTransfer;

/**
 * TianyanCommonGameEveBlueprintRestClient
 * <p>
 * 游戏EVE蓝图REST客户端接口
 * <p>
 * create 2025/08/24 20:01
 * <p>
 * update 2025/08/24 20:01
 *
 * @author Deng Haozhi
 * @see TianyanCommonRestClient
 * @since 1.0.0
 */
public interface TianyanSidecarGameEveBlueprintRestClient extends TianyanCommonRestClient {

    /**
     * 游戏EVE蓝图创建命令
     *
     * @param command 游戏EVE蓝图创建命令被动请求传输对象
     */
    void create(
            @NotNull(message = "游戏EVE蓝图创建命令被动请求传输对象不能为空")
            @Valid GameEveBlueprintCreateDReqTransfer command);
}
