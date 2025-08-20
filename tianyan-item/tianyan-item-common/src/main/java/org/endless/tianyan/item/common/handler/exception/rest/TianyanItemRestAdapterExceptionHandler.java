package org.endless.tianyan.item.common.handler.exception.rest;

import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.exception.handler.rest.AbstractRestAdapterExceptionHandler;
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

    public RestResponse<Void> response() {
        return RestResponse.<Void>builder().serviceDescription(serviceDescription()).build();
    }

    @Override
    public String serviceDescription() {
        return "天演-资源项服务";
    }
}
