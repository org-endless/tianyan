package org.endless.tianyan.web.gateway.common.handler.exception.rest;

import org.endless.ddd.starter.common.exception.handler.rest.AbstractRestAdapterExceptionHandler;
import org.endless.tianyan.web.gateway.common.model.sidecar.rest.TianyanWebGatewayRestResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * TianyanWebGatewayRestExceptionHandler
 * <p>
 * create 2024/11/02 06:53
 * <p>
 * update 2024/11/03 14:33
 *
 * @author Deng Haozhi
 * @see AbstractRestAdapterExceptionHandler
 * @since 0.0.1
 */
@RestControllerAdvice
public class TianyanWebGatewayRestAdapterExceptionHandler extends AbstractRestAdapterExceptionHandler {

    @Override
    public TianyanWebGatewayRestResponse response() {
        return TianyanWebGatewayRestResponse.builder().build();
    }
}
