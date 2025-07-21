package org.endless.tianyan.metadata.common.handler.exception.rest;

import org.endless.ddd.simplified.starter.common.handler.exception.rest.AbstractRestAdapterExceptionHandler;
import org.endless.tianyan.metadata.common.model.sidecar.rest.TianyanMetadataRestResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * TianyanMetadataRestExceptionHandler
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
public class TianyanMetadataRestAdapterExceptionHandler extends AbstractRestAdapterExceptionHandler {

    @Override
    public TianyanMetadataRestResponse response() {
        return TianyanMetadataRestResponse.builder().build();
    }
}
