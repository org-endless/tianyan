package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.metagroup;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.ddd.infrastructure.adapter.rest.RestClientAdapter;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.rest.TianyanCommonRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.metagroup.transfer.MetagroupCreateDReqTransfer;

import java.util.Optional;

/**
 * TianyanCommonMetagroupRestClient
 * <p>元分组REST客户端接口
 * <p>
 * create 2025/08/23 22:57
 * <p>
 * update 2025/08/23 23:10
 *
 * @author Deng Haozhi
 * @see TianyanCommonRestClient
 * @since 1.0.0
 */
public interface TianyanSidecarMetagroupRestClient extends TianyanCommonRestClient, RestClientAdapter {

    /**
     * 元分组创建命令
     *
     * @param command 元分组创建命令被动请求传输对象不能为空
     * @return {@link Optional }<{@link String }>
     */
    Optional<String> create(
            @NotNull(message = "元分组创建命令被动请求传输对象不能为空")
            @Valid MetagroupCreateDReqTransfer command);
}
