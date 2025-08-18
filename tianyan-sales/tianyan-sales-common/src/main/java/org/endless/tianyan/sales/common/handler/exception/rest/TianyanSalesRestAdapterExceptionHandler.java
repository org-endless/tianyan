package org.endless.tianyan.sales.common.handler.exception.rest;

import org.endless.ddd.starter.common.exception.handler.rest.AbstractRestAdapterExceptionHandler;
import org.endless.tianyan.sales.common.model.sidecar.rest.TianyanSalesRestResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * TianyanSalesRestExceptionHandler
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
public class TianyanSalesRestAdapterExceptionHandler extends AbstractRestAdapterExceptionHandler {

    @Override
    public TianyanSalesRestResponse response() {
        return TianyanSalesRestResponse.builder().build();
    }
}
