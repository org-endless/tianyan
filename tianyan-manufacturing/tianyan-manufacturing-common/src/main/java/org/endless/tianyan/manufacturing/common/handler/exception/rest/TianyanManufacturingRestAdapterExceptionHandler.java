package org.endless.tianyan.manufacturing.common.handler.exception.rest;

import org.endless.ddd.starter.common.exception.handler.rest.AbstractRestAdapterExceptionHandler;
import org.endless.tianyan.manufacturing.common.model.sidecar.rest.TianyanManufacturingRestResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * TianyanManufacturingRestExceptionHandler
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
public class TianyanManufacturingRestAdapterExceptionHandler extends AbstractRestAdapterExceptionHandler {

    @Override
    public TianyanManufacturingRestResponse response() {
        return TianyanManufacturingRestResponse.builder().build();
    }
}
