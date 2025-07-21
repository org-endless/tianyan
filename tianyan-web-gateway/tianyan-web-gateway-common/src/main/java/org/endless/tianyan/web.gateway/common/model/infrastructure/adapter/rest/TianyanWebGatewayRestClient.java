package org.endless.tianyan.web.gateway.common.model.infrastructure.adapter.rest;

import org.endless.ddd.simplified.starter.common.model.infrastructure.adapter.rest.RestClientAdapter;
import org.endless.tianyan.web.gateway.common.model.infrastructure.adapter.transfer.TianyanWebGatewayDrivenTransfer;

/**
 * TianyanWebGatewayDrivenRestAdapter
 * <p>
 * create 2024/09/05 09:40
 * <p>
 * update 2025/01/08 12:45
 *
 * @author Deng Haozhi
 * @see RestClientAdapter
 * @since 0.0.1
 */
public interface TianyanWebGatewayRestClient<T extends TianyanWebGatewayDrivenTransfer>
        extends RestClientAdapter {

}
