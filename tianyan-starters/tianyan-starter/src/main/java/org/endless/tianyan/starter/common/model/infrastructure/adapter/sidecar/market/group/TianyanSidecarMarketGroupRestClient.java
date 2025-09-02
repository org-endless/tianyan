package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.group;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.rest.TianyanCommonRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.group.transfer.MarketGroupCreateDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.group.transfer.MarketGroupModifyParentDReqTransfer;

import java.util.Optional;

/**
 * TianyanCommonMarketGroupRestClient
 * <p>市场分组REST客户端接口
 * <p>
 * create 2025/08/24 05:12
 * <p>
 * update 2025/08/24 05:15
 *
 * @author Deng Haozhi
 * @see TianyanCommonRestClient
 * @since 1.0.0
 */
public interface TianyanSidecarMarketGroupRestClient extends TianyanCommonRestClient {

    /**
     * 市场分组创建命令
     *
     * @param command 市场分组创建命令被动请求传输对象
     * @return {@link Optional }<{@link String }>
     */
    Optional<String> create(
            @NotNull(message = "市场分组创建命令被动请求传输对象不能为空")
            @Valid MarketGroupCreateDReqTransfer command);

    /**
     * 市场分组修改父分组命令
     *
     * @param command 市场分组修改父分组命令被动请求传输对象
     */
    void modifyParent(
            @NotNull(message = "市场分组修改父分组命令被动请求传输对象不能为空")
            @Valid MarketGroupModifyParentDReqTransfer command);
}
