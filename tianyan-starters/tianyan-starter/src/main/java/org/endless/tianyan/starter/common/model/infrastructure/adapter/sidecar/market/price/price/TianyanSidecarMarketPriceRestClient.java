package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.price.price;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.rest.TianyanCommonRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.price.price.transfer.MarketPriceCreateDReqTransfer;

/**
 * TianyanSidecarMarketPriceRestClient
 * <p>
 * create 2025/08/27 12:24
 * <p>
 * update 2025/08/27 12:24
 *
 * @author Deng Haozhi
 * @see TianyanCommonRestClient
 * @since 1.0.0
 */
public interface TianyanSidecarMarketPriceRestClient extends TianyanCommonRestClient {

    /**
     * 市场价格创建命令
     *
     * @param command 市场价格创建命令被动请求传输对象
     */
    void create(
            @NotNull(message = "市场价格创建命令被动请求传输对象不能为空")
            @Valid MarketPriceCreateDReqTransfer command);
}
