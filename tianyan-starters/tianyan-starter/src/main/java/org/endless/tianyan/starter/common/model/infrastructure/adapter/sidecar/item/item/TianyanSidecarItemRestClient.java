package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.item;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.rest.TianyanCommonRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.item.transfer.ItemCreateDReqTransfer;

import java.util.Optional;

/**
 * TianyanCommonItemRestClient
 * <p>资源项REST客户端接口
 * <p>
 * create 2025/08/23 00:27
 * <p>
 * update 2025/08/23 00:28
 *
 * @author Deng Haozhi
 * @see TianyanCommonRestClient
 * @since 1.0.0
 */
public interface TianyanSidecarItemRestClient extends TianyanCommonRestClient {

    /**
     * 资源项创建命令
     *
     * @param command 资源项创建命令被动请求传输对象
     * @return {@link Optional }<{@link String }>
     */
    Optional<String> create(
            @NotNull(message = "资源项创建命令被动请求传输对象不能为空")
            @Valid ItemCreateDReqTransfer command);
}
