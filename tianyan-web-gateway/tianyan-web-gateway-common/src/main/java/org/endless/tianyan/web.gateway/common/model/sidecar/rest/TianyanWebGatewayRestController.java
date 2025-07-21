package org.endless.tianyan.web.gateway.common.model.sidecar.rest;

import org.endless.ddd.simplified.starter.common.model.sidecar.rest.RestController;

/**
 * TianyanWebGatewayRestController
 * <p>
 * create 2024/09/06 15:29
 * <p>
 * update 2024/09/11 00:59
 *
 * @author Deng Haozhi
 * @see RestController
 * @since 0.0.1
 */
public interface TianyanWebGatewayRestController extends RestController {

    default TianyanWebGatewayRestResponse response() {
        return TianyanWebGatewayRestResponse.builder().build();
    }
}
