package org.endless.tianyan.web.gateway.common.model.sidecar.rest;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.endless.ddd.starter.common.config.rest.response.AbstractRestResponse;

/**
 * TianyanWebGatewayRestResponse
 * <p>
 * create 2024/09/06 15:28
 * <p>
 * update 2024/09/06 15:29
 *
 * @author Deng Haozhi
 * @see AbstractRestResponse
 * @since 0.0.1
 */
@Getter
@SuperBuilder
public class TianyanWebGatewayRestResponse extends AbstractRestResponse {


    private static final String SERVICE_DESCRIPTION = "天演-网页网关";

    @Override
    public TianyanWebGatewayRestResponse createInstance(String status, String errorCode, String message, Object data) {
        return TianyanWebGatewayRestResponse.builder().status(status).errorCode(errorCode).message(message).data(data).build();
    }

    @Override
    public String getServiceDescription() {
        return SERVICE_DESCRIPTION;
    }
}
