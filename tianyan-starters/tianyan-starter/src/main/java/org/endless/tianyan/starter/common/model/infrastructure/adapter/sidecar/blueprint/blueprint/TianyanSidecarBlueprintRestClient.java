package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.blueprint;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.rest.TianyanCommonRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.blueprint.transfer.BlueprintCreateDReqTransfer;

import java.util.Optional;

/**
 * TianyanCommonBlueprintRestClient
 * <p>
 * 蓝图REST客户端接口
 * <p>
 * create 2025/08/23 01:33
 * <p>
 * update 2025/08/24 19:54
 *
 * @author Deng Haozhi
 * @see TianyanCommonRestClient
 * @since 1.0.0
 */
public interface TianyanSidecarBlueprintRestClient extends TianyanCommonRestClient {

    /**
     * 蓝图创建命令
     *
     * @param command 蓝图创建命令被动请求传输对象
     * @return {@link Optional}<{@link String}>
     */
    Optional<String> create(
            @NotNull(message = "蓝图创建命令被动请求传输对象不能为空")
            @Valid BlueprintCreateDReqTransfer command);
}
