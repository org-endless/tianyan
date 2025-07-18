package org.endless.tianyan.item.common.handler.exception.rest;

import org.endless.ddd.simplified.starter.common.handler.exception.rest.AbstractRestAdapterExceptionHandler;
import org.endless.tianyan.item.common.model.sidecar.rest.TianyanItemRestResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * TianyanItemRestExceptionHandler
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
public class TianyanItemRestAdapterExceptionHandler extends AbstractRestAdapterExceptionHandler {

    @Override
    public TianyanItemRestResponse response() {
        return TianyanItemRestResponse.builder().build();
    }
}
