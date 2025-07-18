package org.endless.tianyan.finance.common.handler.exception.rest;

import org.endless.ddd.simplified.starter.common.handler.exception.rest.AbstractRestAdapterExceptionHandler;
import org.endless.tianyan.finance.common.model.sidecar.rest.TianyanFinanceRestResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * TianyanFinanceRestExceptionHandler
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
public class TianyanFinanceRestAdapterExceptionHandler extends AbstractRestAdapterExceptionHandler {

    @Override
    public TianyanFinanceRestResponse response() {
        return TianyanFinanceRestResponse.builder().build();
    }
}
