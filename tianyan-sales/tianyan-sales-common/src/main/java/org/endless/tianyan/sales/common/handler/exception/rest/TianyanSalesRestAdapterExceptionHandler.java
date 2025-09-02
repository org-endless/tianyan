package org.endless.tianyan.sales.common.handler.exception.rest;

import org.endless.ddd.starter.common.exception.AbstractRestExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * TianyanSalesRestExceptionHandler
 * <p>
 * create 2024/11/02 06:53
 * <p>
 * update 2024/11/03 14:33
 *
 * @author Deng Haozhi
 * @see AbstractRestExceptionHandler
 * @since 0.0.1
 */
@RestControllerAdvice
public class TianyanSalesRestAdapterExceptionHandler extends AbstractRestExceptionHandler {

    @Override
    public String serviceDescription() {
        return "天演-销售服务";
    }
}
