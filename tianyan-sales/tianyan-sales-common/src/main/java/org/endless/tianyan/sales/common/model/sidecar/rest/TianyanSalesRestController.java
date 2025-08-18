package org.endless.tianyan.sales.common.model.sidecar.rest;


import org.endless.ddd.starter.common.ddd.facade.rest.RestController;

/**
 * TianyanSalesRestController
 * <p>
 * create 2024/09/06 15:29
 * <p>
 * update 2024/09/11 00:59
 *
 * @author Deng Haozhi
 * @see RestController
 * @since 0.0.1
 */
public interface TianyanSalesRestController extends RestController {

    default TianyanSalesRestResponse response() {
        return TianyanSalesRestResponse.builder().build();
    }
}
